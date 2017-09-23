package servlet;

import BServiceImpl.ServiceImpl;
import bean.User;
import bean.UserFormBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import service.Service;
import util.FormBeanUtil;
import  Exception.UserHasExistException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    private Service s = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserFormBean formBean = null;

        try {
          formBean = FormBeanUtil.fillBean(request, UserFormBean.class);
            if (formBean.validate()==false) {
                request.setAttribute("formBean", formBean);
                request.getRequestDispatcher("/login2.jsp").forward(request, response);
                return;
            }
            User user = new User();
            BeanUtils.copyProperties(user, formBean);
            s.regist(user);
            response.sendRedirect("/login2.jsp");
        } catch (UserHasExistException e) {
            formBean.getErrors().put("username", e.getMessage());
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/login2.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

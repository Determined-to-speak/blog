package servlet;

import BServiceImpl.BServiceImpl;
import bean.CommentFormBean;
import common.Page;
import damain.Comment;
import damain.Blog;
import org.apache.commons.beanutils.BeanUtils;
import service.BService;
import util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by asus on 2017/8/14.
 */
//@WebServlet(name = "ControllerServlet")
public class ControllerServlet2 extends HttpServlet {
    private String encoding = "UTF-8";
    private BService s = new BServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=" + encoding);
        String op = request.getParameter("op");
        if ("showAllBlogs".equals(op)) {
            showAllBlogs(request, response);
        }else if ("showAllBlogs2".equals(op)){
            showAllBlogs2(request,response);
        }else if ("customercomment".equals(op)){
            customercomment(request,response);
        }
  }

    private void customercomment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
           CommentFormBean formBean = FormBeanUtil.fillBean(request, CommentFormBean.class);
           request.setAttribute("formBean", formBean);
           Comment c=new Comment();
           BeanUtils.copyProperties(c, formBean);
            s.updateCustomer3(c);
            response.sendRedirect("/index.4.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器忙");
        }
    }

    private void showAllBlogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("num");
        Page page= s.findPage(num);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/index.3.jsp").forward(request, response);
    }
    private void showAllBlogs2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id=request.getParameter("id");
            Blog c=s.findCustomerById2(id);
            request.setAttribute("c",c);
            s.updateCustomer2(c);
            List<Comment> cs=s.findAllComment(id);
            request.setAttribute("cs",cs);
            request.getRequestDispatcher("/show2.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器忙");
        }
    }
}

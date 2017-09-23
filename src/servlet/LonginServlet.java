package servlet;

import BServiceImpl.ServiceImpl;
import bean.User;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LonginServlet")
public class LonginServlet extends HttpServlet {
    private Service s=new ServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if (username==null){
//            response.sendRedirect("/login2.jsp");
            response.getWriter().write("输入信息错误，两秒后自动跳转）");
            response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login2.jsp");
            return;
        }
        User user=s.login(username,password);
        if(user==null){
//            response.sendRedirect("/login2.jsp");
            response.getWriter().write("输入信息错误，（两秒后自动跳转）");
            response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login2.jsp");
            return;
        }else{
        request.getSession().setAttribute("user",user);
        response.sendRedirect("/index.jsp");}
    }
}

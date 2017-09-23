package servlet;

import BServiceImpl.BServiceImpl;
import bean.BlogFormBean;
import common.Page;
import damain.Blog;
import org.apache.commons.beanutils.BeanUtils;
import service.BService;
import util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus on 2017/8/14.
 */
//@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
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
        } else if ("addBlog".equals(op)) {
            addBlog(request, response);
        } else if("editBlogUI".equals(op)){
            editBlogUI(request,response);
        } else if ("editBlog".equals(op)){
            editBlog(request,response);
        }else if ("delOne".equals(op)){
            try {
                delOne(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("showAllBlogs2".equals(op)){
            showAllBlogs2(request,response);
        }
    }
    private void delOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id=request.getParameter("id");
        s.deleteCustomerById(id);
//        response.sendRedirect(request.getContextPath());
        response.sendRedirect("/index.jsp");
    }
    private void editBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            BlogFormBean formBean = FormBeanUtil.fillBean(request, BlogFormBean.class);
            request.setAttribute("formBean", formBean);
            Blog c = new Blog();
            BeanUtils.copyProperties(c, formBean);
            s.updateCustomer(c);
            response.sendRedirect("/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器忙");
        }
    }
    private void editBlogUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        Blog c=s.findCustomerById(id);
        request.setAttribute("c",c);
        request.getRequestDispatcher("/editBlog.jsp").forward(request,response);
    }
    private void addBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BlogFormBean formBean = FormBeanUtil.fillBean(request, BlogFormBean.class);
            request.setAttribute("formBean", formBean);
            Blog c = new Blog();
            BeanUtils.copyProperties(c, formBean);
            s.saveCustomer(c);
            response.sendRedirect("/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器忙");
        }
    }
    private void showAllBlogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("num");
        Page page= s.findPage(num);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/index2.jsp").forward(request, response);
    }
    private void showAllBlogs2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id=request.getParameter("id");
            Blog c=s.findCustomerById2(id);
            request.setAttribute("c",c);
            s.updateCustomer2(c);
            request.getRequestDispatcher("/show.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器忙");
        }
    }
}

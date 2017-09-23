<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Blogin | beautiful and Minimal Blog Template  Designed & Coded by pixelhint.com</title>
    <meta charset="utf-8">
    <meta name="author" content="pixelhint.com">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<header>
    <div class="wrapper">
        <a href="#"><img src="img/logo.png" class="h_logo" alt="Blogin" title=""></a>
        <nav>
            <ul class="main_nav">
                <li class="current"><a href="#">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/login2.jsp">博主登录</a></li>
                <%--<li><a href="${pageContext.request.contextPath}/login2.jsp">退出</a></li>--%>
                <%--<li><a href="#">Contact</a></li>--%>
            </ul>
        </nav>
    </div>
</header><!-- Header End -->

<section class="main wrapper">
    <c:forEach items="${page.records}" var="c" varStatus="vs">
        <article>
            <div class="article_image">
                        <%--<img src="img/pic2.jpg" alt="" title="">--%>
                    <img src="img/${c.photo}.jpg" alt="" title="">
            </div>

            <div class="post">
                <h1 class="title">
                        <%--<td nowrap="nowrap"  style="background-color:transparent">${c.name}</td>--%>
                    <a href="${pageContext.request.contextPath}/ControllerServlet2?op=showAllBlogs2&id=${c.id}">${c.name}</a>
                </h1>
                类型:<p>${c.type}</p>
                文章阅读量:<p>${c.number}</p>
                正文:<p>${c.description}</p>
            </div>

        </article>
    </c:forEach>
    <nav class="pagination">
        <a href="${pageContext.request.contextPath}/ControllerServlet2?op=showAllBlogs&num=${page.prePageNum}" class="previous"><i></i>Previous</a>
        <a href="${pageContext.request.contextPath}/ControllerServlet2?op=showAllBlogs&num=${page.nextPageNum}" class="next">Next<i></i></a>
    </nav><!-- Pagination End -->
</section><!-- Main End -->

<footer>
    <div class="wrapper">
        <img class="logo_footer" src="img/logo_footer.png" alt="Blogin" title="">
        <p class="rights">© 2014 Blogin.com  -  All Rights Reserved  -  Find more free Templates at <a href="http://Pixelhint.com" target="_blink">Pixelhint.com</a> </p>
        <ul class="social_profiles">
            <li class="f"><a href="http://facebook.com/pixelhint" target="_blink"></a></li>
            <li class="t"><a href="http://twitter.com/pixelhint" target="_blink"></a></li>
            <li class="be"><a href="http://behance.net/pixelhint" target="_blink"></a></li>
            <li class="d"><a href="http://dribbble.com/pixelhint" target="_blink"></a></li>
        </ul>
    </div>
</footer><!-- Footer End -->
<script src="${pageContext.request.contextPath}/js/love.js"></script>
</body>
</html>
<%--第${page.currentPageNum}页/共${page.totalPageNum}页&nbsp;&nbsp;--%>
<%--<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=1">首页</a>--%>
<%--<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=${page.prePageNum}">上一页</a>--%>
<%--<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=${page.nextPageNum}">下一页</a>--%>
<%--<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=${page.totalPageNum}">尾页</a>--%>


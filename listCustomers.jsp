<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/8/14
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文章列表</title>
    <style type="text/css">
        body{
            text-align: center;
        }
        .odd{background-color: #c3f3c3;
        }
        .even{
            background-color: #f3c3f3;
        }
    </style>
</head>
<body   background="web/photo/9cd4372db0fda7ce68f7b9c4bee08813.jpg">
<table align="center" width="80%">
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/addCustomer.jsp">添加</a>
            <%--<a href="${pageContext.request.contextPath}/ControllerServlet?op=deleteCustomer">删除</a>--%>
        </td>
    </tr>
    <tr>
        <td>
            <table   width="100%"  >
                <tr>
                    <th nowrap="nowrap">选择</th>
                    <th nowrap="nowrap">作者</th>
                    <th nowrap="nowrap">文章类型</th>
                    <th nowrap="nowrap">文章</th>
                    <th nowrap="nowrap">操作</th>
                </tr>
                <c:forEach items="${cs}" var="c" varStatus="vs">
                    <tr class="${vs.index%2==0?'odd':'even'}">
                        <td nowrap="nowrap">
                            <input type="checkbox" value="${c.id}" name="ids"/>
                        </td>
                        <td nowrap="nowrap"  style="background-color:transparent">${c.name}</td>
                        <td nowrap="nowrap"  style="background-color:transparent">${c.type}</td>
                        <td  style="background-color:transparent" >${c.description}</td>
                        <td nowrap="nowrap"  style="background-color:transparent">
                            <a href="${pageContext.request.contextPath}/ControllerServlet?op=editCustomerUI&id=${c.id}">修改</a>
                            <a href="javascript:delOne('${c.id}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr>
        <td>

        </td>
    </tr>
</table>
第${page.currentPageNum}页/共${page.totalPageNum}页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=1">首页</a>
<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=${page.prePageNum}">上一页</a>
<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=${page.nextPageNum}">下一页</a>
<a href="${pageContext.request.contextPath}/ControllerServlet?op=showAllCustomer&num=${page.totalPageNum}">尾页</a>
<script type="text/javascript ">
    function delOne(customerId) {
        var sure=window.confirm("确定要删除吗？");
        if (sure) {
            window.location.href = "${pageContext.request.contextPath}/ControllerServlet?op=delOne&id=" + customerId;
        }
    }
</script>
</body>

</html>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" href="/resources/CSS/style.css">
    <title>详细信息</title>
</head>

<body>
<form action="/admin/knowupdate" method="post">
<table width="100%" height="444" border="1" cellpadding="0" cellspacing="0"bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
    <tr>
        <td width="100%" height="39">物流知识</td>
    </tr>
    <tr>
        <c:if test="${sessionScope.customer.pow.equals('1')}">
            <td width="100%" height="37">标题：
                    ${knowledge.title}</td>
        </c:if>
        <c:if test="${sessionScope.customer.pow.equals('2')}">
            <td width="100%" height="37">标题：
                <input type="text" name="title" value="${knowledge.title}"></td>
        </c:if>
    </tr>
    <tr>
        <td width="100%" height="36">
   <textarea rows="20" name="content" cols="100">
       ${knowledge.content}</textarea></td>
    </tr>
    <tr>
        <td width="100%" height="27">发布人:
            ${knowledge.author}</td>
    </tr>
    <tr>
        <td width="100%" height="27">发布时间:
            <fmt:formatDate value="${knowledge.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
    </tr>
    <tr>
        <td width="100%" height="27">文章号:
            ${knowledge.id}</td>
    </tr>
    <input type="hidden" name="id" value="${knowledge.id}">
    <tr><td width="100%" height="20">
        <c:if test="${sessionScope.customer.pow.equals('2')}">

            <input type="submit" value="修改">
            <a href="/admin/knowdel?id=+${knowledge.id}">删除</a>  </c:if>
        <input type="button"onClick="window.close()" value="关闭窗口">
    </td>
    </tr>

</table>
</form>
</body>
</html>

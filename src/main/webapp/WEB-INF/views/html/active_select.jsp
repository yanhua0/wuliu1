<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" href="/resources/CSS/style.css">
    <title>
       物流动态
    </title>
</head>

<body bgcolor="#ffffff">
<c:if test="${sessionScope.customer.pow.equals('1')}">
    <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
    <jsp:include page="mtop.jsp"/>
</c:if>
<table width="785" border="1" height="117" border="1" align="center" cellpadding="0" cellspacing="0" bordercolordark="#333333" bordercolorlight="#FFFFFF">
    <tr>
        <td height="38" align="center" colspan="6">动态信息</td>
    </tr>
<c:if test="${sessionScope.customer.pow.equals('2')}">
    <tr>
        <td width="786" align="center" height="27" colspan="9">
            <p align="right"> <a href="/admin/active_add">发布信息...</a></td>
    </tr>
</c:if>
    <tr>
        <td width="108" height="29" align="center">ID</td>
        <td width="108" height="29" align="center">标题</td>
        <td width="108" height="29" align="center">作者</td>
        <td width="209" height="29" align="center">发布日期</td>
        <td width="245" height="29" align="center">操作</td>

    </tr>

<c:forEach var="page" items="${page.list}">
    <tr>
        <td width="108" height="32" align="center">${page.id}</td>
        <td width="108" height="32" align="center">${page.title}</td>
        <td width="108" height="32" align="center">${page.author}</td>
        <td width="209" height="32" align="center"><fmt:formatDate value="${page.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
        <td width="245" height="32" align="center">
            <a href="#"onClick="window.open('/active_show?id=${page.id}','','width=790,height=530');">详细</a></td>
    </tr>
</c:forEach>
    <tr>
        <td height="30" colspan="9" align="right">

            <table width="786" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="786" height="30" colspan="9" align="right">
                        共${page.pages}页&nbsp;&nbsp;
                        <a href="/active_select?page=${page.firstPage}">第一页</a>&nbsp;&nbsp;
                        <a href="/active_select?page=${page.prePage}">上一页</a>&nbsp;&nbsp;
                        <a href="/active_select?page=${page.nextPage}">下一页</a>&nbsp;&nbsp;
                        <a href="/active_select?page=${page.lastPage}">最后一页</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

</table>
</body>
</html>

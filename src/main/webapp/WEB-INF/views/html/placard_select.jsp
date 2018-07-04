<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
    公告信息管理
</title>
</head>


<body bgcolor="#ffffff"><jsp:include page="mtop.jsp"/>
<table width="785" height="117" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td height="38" align="center" colspan="5">网站公告信息</td>
  </tr>
  <tr>
    <td height="29" align="right" colspan="5">
   <a href="/admin/placard_add">发布公告信息</a></td>
  </tr>
  <tr>
    <td width="95" height="29" align="center">ID</td>
    <td width="186" height="29" align="center">标题</td>
    <td width="204" height="29" align="center">作者</td>
    <td width="158" height="29" align="center">发布日期</td>
    <td width="134" height="29" align="center">修改操作</td>
  </tr>
<c:forEach var="placard" items="${page.list}">

 <tr>
    <td width="95" height="32" align="center">${placard.id}</td>
    <td width="186" height="32" align="center">${placard.title}</td>
    <td width="204" height="32" align="center">${placard.author}</td>
    <td width="158" height="32" align="center"><fmt:formatDate value="${placard.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
    <td height="32" align="center">
   <a href="/admin/placard_change?id=${placard.id}">修改</a>&nbsp;
   <a href="/admin/pladel?id=${placard.id}">删除</a></td>
  </tr>

</c:forEach>
    <td height="30" colspan="8" align="right">

<table width="786" align="center">
	<tr>
    <td width="786" height="30" colspan="9" align="right">
共${page.pages}页&nbsp;&nbsp;
        <a href="/admin/placard_select?page=${page.firstPage}">第一页</a>&nbsp;&nbsp;
        <a href="/admin/placard_select?page=${page.prePage}">上一页</a>&nbsp;&nbsp;
        <a href="/admin/placard_select?page=${page.nextPage}">下一页</a>&nbsp;&nbsp;
        <a href="/admin/placard_select?page=${page.lastPage}">最后一页</a>
</td>
</tr>
</table>
</td>
  </tr>

</table>
<jsp:include page="down.jsp"/>
</body>
</html>

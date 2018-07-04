<%@ page contentType="text/html; charset=gb2312" import="java.sql.*, java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
车辆信息
</title>
</head>


<body bgcolor="#ffffff">
<c:if test="${sessionScope.customer.pow.equals('1')}">
    <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
    <jsp:include page="mtop.jsp"/>
</c:if>
<table width="786" height="137" border="1" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#FFFFFF" bordercolordark="#333333">
  <tr>
  <td width="786" colspan="9" height="60">
      <p align="center">车辆信息
  </td>
  </tr>
  <tr>
    <td width="786" height="30" colspan="9" align="right">

   <a href="/car_add">发布信息...</a></td>
  </tr>
  <tr>
    <td width="11%" height="29" align="center">车牌号码</td>
   <td width="11%" height="29" align="center">车辆品名</td>
   <td width="11%" height="29" align="center">类型</td>
    <td width="11%" height="29" align="center">车辆限量</td>
    <td width="11%" height="29" align="center">已使用</td>
    <td width="11%" height="29" align="center">驾驶员驾龄</td>
    <td width="11%" height="29" align="center">运输类型</td>
    <td width="12%" height="29">
   <p align="center">操作</td>
</tr>
    <c:forEach var="page" items="${page.list}">
<tr>
<td width="11%" height="29" align="center">${page.licenceNumber}</td>
<td width="11%" height="29" align="center">${page.driverName}</td>
<td width="11%" height="29" align="center">${page.style}</td>
<td width="11%" height="29" align="center">${page.carload}吨</td>
<td width="11%" height="29" align="center">${page.driverTime}年</td>
<td width="15%" height="29" align="center">${page.userTime}年</td>
<td width="11%" height="29" align="center">${page.transpotStyle}</td>
<td width="12%" height="29" align="center"><a href="/car_show?id=${page.code}">详细</a></td>
</tr>
</c:forEach>
<tr>
    <td width="786" height="30" colspan="9" align="right">

<table width="786" align="center" cellpadding="0" cellspacing="0">
	<tr>
    <td width="786" height="30" colspan="9" align="right">
      共${page.pages}页&nbsp;&nbsp;
        <a href="/car_select?page=${page.firstPage}">第一页</a>&nbsp;&nbsp;
        <a href="/car_select?page=${page.prePage}">上一页</a>&nbsp;&nbsp;
        <a href="/car_select?page=${page.nextPage}">下一页</a>&nbsp;&nbsp;
        <a href="/car_select?page=${page.lastPage}">最后一页</a>
  
</td>
</tr>
</table>
</td>
  </tr>

</table>
</body>
</html>

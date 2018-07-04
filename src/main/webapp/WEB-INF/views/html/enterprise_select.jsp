<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
企业信息
</title>
</head>

<body bgcolor="#ffffff">
<c:if test="${sessionScope.customer.pow.equals('1')}">
    <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
    <jsp:include page="mtop.jsp"/>
</c:if>
<table border="1" width="786" align="center" cellpadding="0" cellspacing="0"bordercolordark="#333333" bordercolorlight="#FFFFFF">
<tr>
    <td width="786" align="center" colspan="9" height="32">企业信息</td>
  </tr>
<tr>
    <td width="786" align="center" height="27" colspan="9">
      <p align="right"> <a href="/enterprise_add">发布信息...</a></td>
  </tr>

  <tr>
    <td width="11%" align="center" height="27">企业类型</td>
    <td width="11%" align="center" height="27">企业名称</td>
    <td width="11%" align="center" height="27">经营范围</td>
    <td width="11%" align="center" height="27">所属区域</td>
    <td width="17%" align="center" height="27">地址</td>
    <td width="11%" align="center" height="27">操作</td>
  </tr>
<c:forEach var="page" items="${page.list}">
 <tr>
    <td width="11%" align="center" height="27">${page.enterpriseSort}</td>
    <td width="11%" align="center" height="27">${page.enterpriseName}</td>
    <td width="11%" align="center" height="27">${page.operation}</td>
    <td width="11%" align="center" height="27">${page.workArea}</td>
    <td width="18%" align="center" height="27">${page.address}</td>
    <td width="11%" align="center" height="27"><a href="/enterprise_show/?id=${page.id}">详细</a>　</td>
  </tr>
</c:forEach>
<tr>
    <td width="786" height="30" colspan="9" align="right">
<table width="786" align="center" cellpadding="0" cellspacing="0">
	<tr>
        <td width="786" height="30" colspan="9" align="right">
            共${page.pages}页&nbsp;&nbsp;
            <a href="/enterprise_select?page=${page.firstPage}">第一页</a>&nbsp;&nbsp;
            <a href="/enterprise_select?page=${page.prePage}">上一页</a>&nbsp;&nbsp;
            <a href="/enterprise_select?page=${page.nextPage}">下一页</a>&nbsp;&nbsp;
            <a href="/enterprise_select?page=${page.lastPage}">最后一页</a>
        </td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>

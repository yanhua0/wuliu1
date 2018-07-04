<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
  企业详细页
</title>
</head>
<body bgcolor="#ffffff">
<c:if test="${sessionScope.customer.pow.equals('1')}">
  <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
  <jsp:include page="mtop.jsp"/>
</c:if>
<table width="786" align="center" cellpadding="0" cellspacing="0"  bordercolordark="#333333" bordercolorlight="#FFFFFF">
    <tr>
    <td width="786" height="40" colspan="4">
      <p align="center"><font size="6">企业信息展示</font></td>
  </tr>
<form name="form1" method="post" action="/update">
  <tr>
    <td width="115" height="36">企业类型：</td>
    <td width="265" height="36"><input type="text" name="style" size="20"  value="${enterprise.enterpriseSort}"></td>
    <td width="125" height="36">企业名称：</td>
    <td width="253" height="36"><input type="text" name="name" size="20" value="${enterprise.enterpriseName}"></td>
  </tr>
  <tr>
    <td width="115" height="35">经营范围</td>
    <td width="265" height="35"><input type="text" name="operation" size="20" value="${enterprise.operation}"></td>
    <td width="125" height="35">所属区域：</td>
    <td width="253" height="35"><input type="text" name="area" size="20"value="${enterprise.workArea}"></td>
  </tr>
  <tr>
    <td width="115" height="38">企业地址</td>
    <td width="265" height="38"><input type="text" name="address" size="20"value="${enterprise.address}"></td>
    <td width="125" height="38">联系电话：</td>
    <td width="253" height="38"><input type="text" name="phone" size="20"value="${enterprise.phone}"></td>
  </tr>
  <tr>
    <td width="115" height="34">联系人：</td>
    <td width="265" height="34"><input type="text" name="linkman" size="20"value="${enterprise.linkMan}"></td>
    <td width="125" height="34">手机号：</td>
    <td width="253" height="34"><input type="text" name="hand" size="20"value="${enterprise.handSet}"></td>
  </tr>
  <tr>
    <td width="115" height="35">传真号：</td>
    <td width="265" height="35"><input type="text" name="fax" size="20"value="${enterprise.fax}"></td>
    <td width="125" height="35">邮件网址</td>
    <td width="253" height="35"><input type="text" name="email" size="20"value="${enterprise.email}"></td>
  </tr>
  <tr>
    <td width="115" height="34">企业网址：</td>
    <td width="265" height="34"><input type="text" name="web" size="20"value="${enterprise.http}"></td>
    <td width="125" height="34">类型介绍：</td>
    <td width="253" height="34"><input type="text" name="intr" size="20"value="${enterprise.intro}"></td>
  </tr>
<tr>
    <td width="115" height="34">发布时间：</td>
    <td width="265" height="34">  <fmt:formatDate value="${enterprise.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
    <td width="125" height="34">发布人：</td>
    <td width="265" height="34"> ${enterprise.userName}</td>
  <input type="hidden"  name="id" value="${enterprise.id}">
<c:if test="${enterprise.userName.equals(sessionScope.customer.name)||sessionScope.customer.pow.equals('2')}">
<tr>
    <td width="786" height="45" colspan="4" align="center">                 
      <p><input type="submit" value="修改" name="B1"><input type="reset" value="重写" name="B2">&nbsp;&nbsp;
     <a href="/del2?id=${enterprise.id}"> 删除</a>
</td>
  </tr>
  </c:if>
</table>
</form>
</body>
</html>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
车辆详细页
</title>
</head>

<body bgcolor="#ffffff">
<c:if test="${sessionScope.customer.pow.equals('1')}">
  <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
  <jsp:include page="mtop.jsp"/>
</c:if>
<form action="/car_change" method="post">
<table width="786" border="0" align="center" cellpadding="0" cellspacing="0"  bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td width="100%" height="62" colspan="4">
      <p align="center"><font size="7">车辆信息展示</font></td>
  </tr>

  <tr>
    <td width="18%" height="34" align="center"><font size="4">车牌号</font></td>
    <td width="32%" height="34" align="center"><input type="text" name="s1" value="${carmessage.licenceNumber}"></td>
    <td width="19%" height="34" align="center"><font size="4">车品名</font></td>
    <td width="31%" height="34" align="center"><input type="text" name="s2" value="${carmessage.driverName}"></td>
  </tr>
  <tr>
    <td width="18%" height="36" align="center"><font size="4">车辆类型</font></td>
    <td width="32%" height="36" align="center"><input type="text" name="s3" value="${carmessage.licenceStyle}"></td>
    <td width="19%" height="36" align="center"><font size="4">车辆载重</font></td>
    <td width="31%" height="36" align="center">&nbsp;<input type="text" name="s4" value="${carmessage.carload}">吨</td>
  </tr>
  <tr>
    <td width="18%" height="37" align="center"><font size="4">使用时间</font></td>
    <td width="32%" height="37" align="center">&nbsp;<input type="text" name="s5" value="${carmessage.driverTime}">年</td>
       <td width="18%" height="37" align="center"><font size="4">驾驶员姓名</font></td>
    <td width="32%" height="37" align="center"><input type="text" name="s6" value="${carmessage.brand}"></td>
  </tr>
  <tr>
    <td width="19%" height="37" align="center"><font size="4">驾驶时间</font></td>
    <td width="31%" height="37" align="center"><input type="text" name="userTime" value="${carmessage.userTime}"></td>
    <td width="18%" height="36" align="center"><font size="4">驾照号码</font></td>
    <td width="32%" height="36" align="center"><input type="text" name="tradeMark" value="${carmessage.tradeMark}"></td>
  </tr>
  <tr>
    <td width="19%" height="36" align="center"><font size="4">驾照类型</font></td>
    <td width="31%" height="36" align="center"><input type="text" name="style" value="${carmessage.style}"></td>
   <td width="19%" height="37" align="center"><font size="4">运输类型</font></td>
     <td width="31%" height="37" align="center"><input type="text" name="transpotStyle" value="${carmessage.transpotStyle}"></td>
</tr>
  <tr>
    <td width="18%" height="42" align="center"><font size="4">联系人</font></td>
    <td width="32%" height="42" align="center"><input type="text" name="linkMan" value="${carmessage.linkMan}"></td>
    <td width="19%" height="42" align="center"><font size="4">联系电话</font></td>
    <td width="31%" height="42" align="center"><input type="text" name="phone" value="${carmessage.linkPhone}"></td>
  </tr>
  <tr>
    <td width="18%" height="65" align="center"><font size="4">备注</font></td>
    <td width="82%" height="65" colspan="3">
      <textarea name="remark" id="" name="remark" cols="30" rows="10">${carmessage.remark}</textarea>

   </td>
  </tr>
  <tr>
    <td width="18%" height="42" align="center">发布时间</td>
    <td width="32%" height="42">
      <p align="center"> <fmt:formatDate value="${carmessage.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
    <td width="19%" height="42" align="center">发布人</td>

    <td width="31%" height="42" align="center">${carmessage.userName}</td>
  </tr>
<c:if test="${carmessage.userName.equals(sessionScope.customer.name)||sessionScope.customer.pow.equals('2')}">
 <tr>
      <td width="100%" height="33" colspan="4" align="center">
        <input type="hidden" name="id" value="${carmessage.code}">
        <input type="submit" value="修改">&nbsp;&nbsp;
        <a href="/del1?id=${carmessage.code}">删除</a>
    </td>
  </tr>
</c:if>
</table>
</form>
</body>
</html>

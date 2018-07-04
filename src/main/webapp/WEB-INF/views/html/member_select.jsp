<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<html>
<head>
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
会员管理
</title>
</head>


<body bgcolor="#ffffff"><jsp:include page="mtop.jsp"/>
<table width="785" height="123" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td height="54" colspan="10" align="center">会员资料信息修改</td>
  </tr>
  <tr>
    <td width="8%" height="16" align="center">ID</td>
    <td width="11%" height="16" align="center">名字</td>

    <td width="13%" height="16" align="center">Email</td>
    <td width="9%" height="16" align="center">性别</td>
    <td width="11%" height="16" align="center">电话</td>
    <td width="14%" height="16" align="center">问题</td>
    <td width="11%" height="16" align="center">答案</td>
    <td width="12%" height="16" align="center">申请日</td>
    <td width="11%" height="16" align="center">操作</td>
  </tr>
 <c:forEach var="customer" items="${page.list}" >
   <tr>
    <td width="8%" height="35" align="center">${customer.id}</td>
    <td width="11%" height="35" align="center">${customer.name}</td>
     <td width="13%" height="35" align="center">${customer.email}</td>
    <td width="9%" height="35" align="center">${customer.sex}</td>
    <td width="11%" height="35" align="center">${customer.phone}</td>
    <td width="14%" height="35" align="center">${customer.question}</td>
    <td width="11%" height="35" align="center">${customer.result}</td>
    <td width="12%" height="35" align="center"><fmt:formatDate value="${customer.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
    <td height="35" align="center"> <a href="/admin/member_change?id=${customer.id}">修改</a> <a href="/admin/delete?id=${customer.id}">删除</a></td>
  </tr>
 </c:forEach>
  <tr>
    <td height="30" colspan="9" align="right">
      <table width="88%" align="center">
        <tr>
          <td width="104%" height="30" colspan="9" align="right"> 共${page.pages}页&nbsp;&nbsp; <a href="/admin/member_select?page=${page.firstPage}">第一页</a>&nbsp;&nbsp; <a href="/admin/member_select?page=${page.prePage}">上一页</a>&nbsp;&nbsp; <a href="/admin/member_select?page=${page.nextPage}">下一页</a>&nbsp;&nbsp; <a href="/admin/member_select?page=${page.lastPage}">最后一页</a> </td>
        </tr>
    </table></td>
  </tr>
</table>
<jsp:include page="down.jsp"/>
</body>
</html>

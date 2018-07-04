<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="/resources/CSS/style.css">
<title>
placard_show page
</title>
</head>
<script language="javascript">
function check()
{
 if(form1.title.value=="")
{
alert("请填写标题！！！");
form1.title.focus();
}
if(form1.content.value=="")
{
alert("请填写内容！！！");
form1.content.focus();
}
}
</script>

<body bgcolor="#ffffff"><jsp:include page="mtop.jsp"/>
<form method="POST" action="/admin/pc"name="form1">
<table width="785" height="238" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td width="100%" height="39">
      <p align="center">公告信息修改</td>
  </tr>

  <tr>
    <td width="100%" height="37"> 标题：
   <input type="text" name="title" size="37" value="${placard.title}"></td>
  </tr>
  <tr>
    <td width="100%" height="37"> *  注意以下内容最多可以写1000个字</td>
  </tr>
  <tr>
    <td width="100%" height="36">
   <textarea rows="10" name="content" cols="100">
   ${placard.content}</textarea></td>
  </tr>
<tr>
<td width="100%" height="16">  发布人:
  <input type="text" name="author" size="37" value="${placard.author}">
</td>
</tr>
<tr>
<td width="100%" height="16"> 发布时间:
    <fmt:formatDate value="${placard.issueDate}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />
</td>
</tr>
<tr>
<td width="100%" height="16"> 文章号:
<input type="hidden" name="id" size="37" value="${placard.id}">
</td>
</tr>
<tr>
<td width="30%" height="16">
   <input type="submit" value="修改" name="B1"onClick="return check()">
   <input type="reset" value="重写" name="B2">
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
   <a href="/admin/placard_select">返回</a>
</td>
   </tr>
</table>
</form><jsp:include page="down.jsp"/>
</body>
</html>

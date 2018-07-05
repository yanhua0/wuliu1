<%@ page contentType="text/html; charset=utf-8" import="java.sql.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="/resources/CSS/style.css">
  <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<title>
用户信息修改
</title>
  <style>
   .mem{
      text-align: center;
    }
  </style>
</head>
<script language="javascript">
      $(function () {
         $("#check").click(function () {

             if(form1.name.value==""){
                 alert("请输入你的用户名");
                 form1.name.focus();
                 return false;
             }

             if(form1.password.value==""){
                 alert("请输入你注册的密码");
                 form1.password.focus();
                 return false;
             }
             if(form1.repassword.value==""){
                 alert("请输入确认密码");
                 form1.repassword.focus();
                 return false;
             }
             if(form1.password.value!=form1.repassword.value){
                 alert("你输入的两次密码不一致");
                 return false;
             }
             if(form1.email.value==""){
                 alert("请输入你的Email址");
                 form1.email.focus();
                 return false;
             }


             if(form1.phone.value==""){
                 alert("请输入你的联系电话");
                 form1.phone.focus();
                 return false;
             }
             if(form1.question.value==""){
                 alert("输入密码提示问题便于取回密码");
                 form1.question.focus;
                 return false;
             }
             if(form1.result.value==""){
                 alert("请输入回答问题的答案");
                 form1.result.focus();
                 return false;
             }
             if(form1.pow.value!=1&&form1.pow.value!=2){
                 alert("权限只能为1或2");
                 form1.result.focus();
                 return false;
             }
             else{

                 $.ajax({
                     cache: false,
                     type: "POST",
                     url:"/admin/change",	//把表单数据发送到ajax.jsp
                     data:$('#for').serialize(),	//要发送的是ajaxFrm表单中的数据
                     dataType:"json",
                     async: false,
                     error: function(request) {
                         alert("发送请求失败！");
                     },
                     success: function(data) {
                         console.log("!1111111111111")
                         if (data.code == 0) {
                           window.location.href = "/logout ";
                         }
                         if(data.code==-1)
                         {
                             window.location.reload();
                         }
                        if(data.code==1){
                               alert("你输入的用户名已被注册！！");
                         }
                     }

                     });
             }

         })



	})
</script>
<body>
<jsp:include page="mtop.jsp"/>
<form method="POST" action="/admin/change" id="for" name="form1">
    <div align="center">
会员修改
   <p> *&nbsp; 注意以下内容必须填写完整。</p>
<table class="mem" width="46%" height="216" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF" >
<tr class="mem">
    <td width="100%" height="34">名字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="name" size="20" value="${customer.name}"></td>
  </tr>
  <tr>
    <td width="100%" height="16">
      <p>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="password" name="password" size="20" value="${customer.password}"></p>
    </td>
  </tr>
  <tr>
    <td width="100%" height="16">
      <p>确认密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <input type="password" name="repassword" size="20" value="${customer.password}"></p>
    </td>
  </tr>
  
  <tr><td width="100%" height="16">
      <p>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="email" size="20" value="${customer.email}">　</p>
    </td>
    
  </tr>
  <tr>

    <td width="100%" height="16">
      性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <c:if test="${customer.sex.equals('man')}">
	  男
      <input type="radio" value="man" checked name="sex">&nbsp;&nbsp;&nbsp;&nbsp;
      女<input type="radio" name="sex" value="moman">
      </c:if>
<c:if test="${customer.sex.equals('woman')}">
      男
      <input type="radio" value="man"  name="sex">&nbsp;&nbsp;&nbsp;&nbsp;
      女<input type="radio" name="sex"checked value="moman">
</c:if>
    </td>
  </tr>
  <tr>
    <td width="100%" height="16">
      <p>电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="phone" size="20" value="${customer.phone}">
      </p>
    </td>
  </tr>
  <tr>
    <td width="100%" height="16">
    <p>找回密码问题：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="question" size="20" value="${customer.question}">
    </p>
    </td>
  </tr>
  <tr>
    <td width="100%" height="16">问题答案：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="result" size="20" value="${customer.result}"></td>
  </tr>
  <c:if test="${!sessionScope.customer.name.equals(customer.name)}">
  <tr>
    <td width="100%" height="16">权限&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="pow" size="20" placeholder="1位普通用户2为管理员" value="${customer.pow}"></td>
  </tr>
  </c:if>
<tr>
    <td width="100%" height="16">&nbsp;ID&nbsp;  &nbsp;   &nbsp;  &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;
      ${customer.id}<input type="hidden" name="id" id="id" size="20"value="${customer.id}"></td>
  </tr>
  <tr>
    <td width="100%" height="16">
    <input type="button" value="修改" name="button" id="check" ><input type="reset" value="重置">
&nbsp;&nbsp;<a href="/admin/member_select">返回</a>
    </td>
  </tr>
</table>
</div>
</form>
<jsp:include page="down.jsp"/>
</body>
</html>

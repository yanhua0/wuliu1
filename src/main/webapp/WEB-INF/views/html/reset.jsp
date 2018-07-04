<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>
<link href="CSS/style.css" type="text/css" rel="stylesheet">
<html>
<head>
    <title>找回密码窗口</title>
</head><script language="javascript">

    function check(){
        if(form1.password.value!=form1.repassword.value){
            alert("你输入的两次密码不一致!");
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
    }
</script>
<body>

<br>  <form action="/changepassword" name="form1" method="post">
    <table width="502" height="213" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#E8FFFF" class="tableBorder">
        <tr>
            <td height="43" colspan="4" align="center" class="head">&nbsp;</td>
        </tr>
        <tr>
            <td width="33" rowspan="4" align="center" valign="middle" >&nbsp;</td>
            <td width="176" height="23">新密码:    </td>
            <td width="258"><input name="password" type="text" size="31"></td>
            <td width="35" rowspan="4">&nbsp;</td>
        </tr>
        <tr>
            <td height="23">确认密码：</td>
            <td height="23"><input name="repassword" type="text" size="31"></td>
        </tr>
        <tr align="center">
            <td height="46" colspan="4">
                <input name="Submit" type="submit" value="修改" onClick="return check()">
                &nbsp;
                <input name="Submit2" type="reset" value="重置">
                &nbsp;&nbsp;<a href="/index">返回到主页</a>
            </td>
        </tr>

    </table>  </form>
</body>
</html>

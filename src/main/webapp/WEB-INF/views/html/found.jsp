<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" %>
<% request.setCharacterEncoding("gb2312"); %>
<link href="/resources/CSS/style.css" type="text/css" rel="stylesheet">
<html>
<head>
    <title>找回密码窗口</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
</head><script language="javascript">

    function check(){
        if(form1.username.value==""){
            alert("这样都能找回密码太好笑了");
            form1.username.focus();
            return false;

        }
        if(form1.email.value==""){
            alert("请输入你的Email址");
            form1.email.focus();
            return false;
        }
        if(form1.question.value==""){
            alert("请输入提示的问题");
            form1.question.focus();
            return false;
        }
        if(form1.result.value==""){
            alert("请输入提示问题的答案");
            form1.result.focus();
            return false;

        }
    }
    $(function () {
        $("#find").click(function () {
            console.log($("#name").val());
            if($("#name").val().length!=0)
            {
                $.post("/findpro",{name:$("#name").val()},function (result) {
                    $("#qe").val(result.question);
                })
            }
            else{
                alert("请输入用户名！");
            }

        });
    })
</script>

<body>

<br>  <form action="/foundPassword" name="form1" method="post">
    <table width="502" height="213" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#E8FFFF" class="tableBorder">
        <h3 style="color:red">${error}</h3>
        <tr>
            <td height="43" colspan="4" align="center" class="head">&nbsp;</td>
        </tr>
        <tr>
            <td width="33" rowspan="4" align="center" valign="middle" >&nbsp;</td>
            <td width="176" height="23">用户名:    </td>
            <td width="258"><input name="name" id="name" type="text" size="31"></td>
            <td width="35" rowspan="4">&nbsp;</td>
        </tr>
        <tr>
            <td height="23">提示的问题:</td>
            <td height="23"><input name="question" id="qe" type="text" size="31"></td>
            <td height="23"><input type="button" id="find" value="查看问题"></td>
        </tr>

        <tr>
            <td height="53">答案:</td>
            <td height="53"><input name="result" type="text" size="31"></td>
        </tr>
        <tr align="center">
            <td height="46" colspan="4">
                <input name="Submit" type="submit" value="查找" onClick="return check()">
                &nbsp;
                <input name="Submit2" type="reset" value="重置">
                &nbsp;&nbsp;<a href="/index">返回到主页</a>
            </td>
        </tr>

    </table>  </form>
</body>
</html>

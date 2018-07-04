<%@ page import="org.wuliu.entity.Customer" %>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <link rel="stylesheet" href="/resources/CSS/style.css">
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
  <title>首页</title>
        <%
Customer login=(Customer) session.getAttribute("customer");

if(login==null)
{
%>
    <script language="javascript">
        $(function () {
            if($("#h3").html()=="")
            {
                alert("您还未登录，不能浏览详细信息！！！");
            }
        })
    </script>
        <%}%>
  <script language="javascript">
      function check1()
      {
          if(form_u.name.value=="")
          {
              alert("请添入姓名");
              form_u.name.focus();
              return false;
          }
          if(form_u.password.value=="")
          {
              alert("请添入密码");
              form_u.password.focus();
              return false;
          }
      }

  </script>


<body  link="#669900" alink="#FFCC66" vlink="#FF3300">

<jsp:include page="top.jsp"/>
<table width="786" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="202" height="255" valign="top" background="/resources/image/8.jpg">

      <jsp:include page="left.jsp" flush="true" /></td>
    <td width="484" valign="top"><table width="100" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="/resources/image/13.jpg" width="370" height="39"></td>
      </tr>
    </table>

      <table width="370"  border="0" cellpadding="0" cellspacing="0" background="/resources/image/14.jpg">
        <tr>
          <td valign="top">

            <table width="370" border="0" cellpadding="0" cellspacing="0">
           <c:forEach var="goodsMeg" items="${goodsMeg}">

              <tr>
                <td width="36" height="25">&nbsp;</td>
                <td width="334"><a href="goods_xiangxi.jsp?id=1">
                ${goodsMeg.goodsName}--${goodsMeg.startProvince}--${goodsMeg.startCity}--${goodsMeg.endProvince}--${goodsMeg.endCity}
                </a></td>

              </tr>
           </c:forEach>
              <tr>
                <td width="36" height="25">&nbsp;</td>
                <td width="334" align="right"><a href="/goods_select">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
              </tr>
            </table>		  		  </td>
        </tr>
      </table>
      <table width="100" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="/resources/image/16.jpg" width="370" height="23"></td>
        </tr>
      </table>
      <table width="370" border="0" cellpadding="0" cellspacing="0" background="/resources/image/17.jpg">
    <c:forEach var="carMessage" items="${carMessage}">
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334"><a href="car_show.jsp?id=">${carMessage.tradeMark}--${carMessage.brand}--${carMessage.style}--${carMessage.carload}--${carMessage.transpotStyle}</td>
        </tr>
    </c:forEach>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334" align="right"><a href="/car_select">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
        </tr>
      </table>
      <table width="100" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="/resources/image/18.jpg" width="370" height="29"></td>
        </tr>
      </table>
      <table width="370" border="0" cellpadding="0" cellspacing="0" background="/resources/image/19.jpg">
<c:forEach var="enterprise" items="${enterprise}">
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334"><a href="enterprise_show.jsp?id=">${enterprise.enterpriseSort}--${enterprise.enterpriseName}--${enterprise.operation}--${enterprise.workArea}
          </a></td>
        </tr>
</c:forEach>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334" align="right"><a href="/enterprise_select">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
        </tr>
      </table></td><!--存放中间的代码-->
    <td valign="top" width="215" background="/resources/image/12.jpg"><jsp:include page="right.jsp" flush="true" /></td>
  </tr>
</table><jsp:include page="down.jsp" flush="true" />

</body>

</html>

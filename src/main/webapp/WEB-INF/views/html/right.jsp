<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<table  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="/resources/image/11.jpg" width="215" height="39"></td>
      </tr>
</table>
	<table width="169" height="29" border="0" align="center" cellpadding="0" cellspacing="0">
   <c:forEach items="${placard}" var="placard">
      <tr>
      <td width="22" height="25">&nbsp;</td>
      <td width="147">${placard.content}</td>
     </tr>
   </c:forEach>
    </table>
	<table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="/resources/image/15.jpg" width="215" height="240"></td>
      </tr>
</table>


<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../CSS/style.css">
<title>
placard page
</title>
</head>
<%!
ResultSet rs=null;
String sql;
int code;
int pagesize=10;
int rowcount=0;
int pagecount=1;
%>
<jsp:include page="mtop.jsp"/>
<body bgcolor="#ffffff">
<table width="785" border="1" align="center" cellpadding="0" cellspacing="0"bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td height="38" align="center" colspan="5">����֪ʶ</td>
  </tr>
  <tr>
    <td height="29" align="right" colspan="5">
   <a href="knowledge_add.jsp">��������֪ʶ</a></td>
  </tr>
  <tr>
    <td width="189" height="29" align="center">ID</td>
    <td width="189" height="29" align="center">����</td>
    <td width="129" height="29" align="center">��������</td>
    <td width="105" height="29" align="center">֪ʶ����</td>
    <td width="166" height="29" align="center">����</td>
  </tr>
<%

sql="select ID,Title,IssueDate,Reside from tb_Knowledge ";
try
{
rs=connection.executeQuery(sql);
if(!rs.next())
{
%>
<script language="javascript">
	alert("û����Ϣ");
</script>
<%
}else
{
rs.last();
rowcount=rs.getRow();
int showpage=1;
pagecount=((rowcount%pagesize)==0?(rowcount/pagesize):(rowcount/pagesize)+1);
 String topage=request.getParameter("topage");
if(topage!=null)
{
showpage=Integer.parseInt(topage);
if(showpage>pagecount){
  showpage=pagecount;
  }else if(showpage<=0){
  showpage=1;
  }
}
rs.absolute((showpage-1)*pagesize+1);
for(int i=1;i<=pagesize;i++)
{
code=rs.getInt("ID");
%>
 <tr>
    <td width="189" height="32" align="center"><%=code%></td>
    <td width="189" height="32" align="center"><%=rs.getString("Title")%></td>
    <td width="129" height="32" align="center"><%=rs.getDate("IssueDate")%></td>
    <td width="105" height="32" align="center"><%=rs.getString("Reside")%></td>
    <td height="32" align="center">
   <a href="knowledge_change.jsp?id=<%=code%>">�޸�</a>
   <a href="knowledge_delete.jsp?id=<%=code%>">&nbsp;&nbsp;ɾ��</a></td>
  </tr>
<%
if(!rs.next())
break;
}
%>
<tr>
    <td height="30" colspan="8" align="right">

<table width="786" align="center" cellpadding="0" cellspacing="0">
	<tr>
    <td width="786" height="30" colspan="9" align="right">
        ��<%=pagecount%>ҳ&nbsp;&nbsp;
        <a href="knowledge_select.jsp?topage=<%=1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="knowledge_select.jsp?topage=<%=showpage-1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="knowledge_select.jsp?topage=<%=showpage+1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="knowledge_select.jsp?topage=<%=pagecount%>">���һҳ</a>
</td>
</tr>
</table>
</td>
  </tr>
<%}}catch(Exception e)
{e.printStackTrace();}
%>
</table>
&nbsp;
<jsp:include page="down.jsp"/>
</body>
</html>
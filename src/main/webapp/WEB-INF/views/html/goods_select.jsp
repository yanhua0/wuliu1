<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" href="/resources/CSS/style.css">
    <title>
        物资信息
    </title>
</head>
<c:if test="${sessionScope.customer.pow.equals('1')}">
    <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
    <jsp:include page="mtop.jsp"/>
</c:if>
<table width="786"  border="1" align="center" cellpadding="0" cellspacing="0"  bordercolordark="#333333" bordercolorlight="#FFFFFF">
    <tr>
        <td width="786" colspan="9">

            <p align="center">货物信息
        </td>
    </tr>
    <tr>
        <td width="786" height="30" colspan="9" align="right"><a href="/goods_add">发布信息...</a></td>
    </tr>
    <tr align="center">
        <td width="786" height="29" align="center">货物类型</td>
        <td width="786" height="29" align="center">货物名称</td>
        <td width="786" height="29" align="center">货物数量</td>
        <td width="786" height="29" align="center">数量单位</td>
        <td width="786" height="29" align="center">起始省份</td>
        <td width="786" height="29" align="center">起始城市</td>
        <td width="786" height="29" align="center">抵达省份</td>
        <td width="786" height="29" align="center">抵达城市</td>
        <td width="786" height="29">操作</td>
    </tr>
<c:forEach var="page" items="${page.list}">
    <tr>
        <td width="786" height="29" align="center">${page.goodsStyle}</td>
        <td width="786" height="29" align="center">${page.goodsName}</td>
        <td width="786" height="29" align="center">${page.goodsNumber}</td>
        <td width="786" height="29" align="center">${page.goodsUnit}</td>
        <td width="786" height="29" align="center">${page.goodsUnit}</td>
        <td width="786" height="29" align="center">${page.startCity}</td>
        <td width="786" height="29" align="center">${page.endProvince}</td>
        <td width="786" height="29" align="center">${page.endCity}</td>
        <td width="786" height="29"> <p align="center">
            <a href="/goods_xiangxi?id=${page.id}">详细</a></td>
    </tr>
</c:forEach>
    <tr>
        <td width="786" height="30" colspan="9" align="right">

            <table width="786" align="center">
                <tr>
                    <td width="786" height="30" colspan="9" align="right">
                        共${page.pages}页&nbsp;&nbsp;
                        <a href="/goods_select?page=${page.firstPage}">第一页</a>&nbsp;&nbsp;
                        <a href="/goods_select?page=${page.prePage}">上一页</a>&nbsp;&nbsp;
                        <a href="/goods_select?page=${page.nextPage}">下一页</a>&nbsp;&nbsp;
                        <a href="/goods_select?page=${page.lastPage}">最后一页</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

</table>
</body>
</html>

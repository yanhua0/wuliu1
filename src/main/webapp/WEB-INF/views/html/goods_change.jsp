<%@ page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" href="/resources/CSS/style.css">
    <title>
        Goods_change page
    </title>
</head>
<Script language="javascript">
    function check()
    {
        if(form1.gclass.value=="")
        {
            alert("请填写货物类型！！");
            form1.gclass.focus();
            return false;
        }
        if(form1.gname.value=="")
        {
            alert("请填写货物名称！！！");
            form1.gname.focus();
            return false;
        }
        if(form1.gcount.value=="")
        {
            alert("请填写货物数量！！！");
            form1.gcount.focus();
            return false;
        }
        if(form1.gunit.value=="")
        {
            alert("请填写货物数量单位！！！");
            form1.gunit.focus();
            return false;
        }
        if(form1.startProvince.value=="")
        {
            alert("请填写起始省份！！！");
            form1.startProvince.focue();
            return false;
        }
        if(form1.gstartcity.value=="")
        {
            alert("请填写起始城市！！！");
            form1.gstartcity.focue();
            return false;
        }
        if(form1.endProvince.value=="")
        {
            alert("请填写抵达省份！！！");
            form1.endProvince.focus();
            return false;
        }
        if(form1.gendcity.value=="")
        {
            alert("请填写抵达城市！！！");
            form1.gendfirm.focus();
            return false;
        }
        if(form1.gtransstyle.value=="")
        {
            alert("请填写运输类型！！！");
            form1.gtransstyle.focue();
            return false;
        }
        if(form1.gtime.value=="")
        {
            alert("请填写运输时间！！！");
            form1.gtime.focus();
            return false;
        }
        if(form1.glink.value=="")
        {alert("请填写联系人！！！");
            form1.glink.focus();
            return false;
        }
        if(form1.gphone.value=="")
        {
            alert("请填写联系电话！！！");
            form1.gphone.focus();
            return false;
        }
        if(form1.gremark.value=="")
        {
            alert("请填写备注！！！");
            form1.gremark.focus();
            return false;
        }
        if(form1.grequest.value=="")
        {
            alert("请填写要求！！！");
            form1.grequest.focus();
            return false;}
        if(form1.username.value=="")
        {
            alert("请填写完整发布人名！！！");
            form1.grequest.focus();
            return false;
        }
    }
</Script>

<body bgcolor="#ffffff"><c:if test="${sessionScope.customer.pow.equals('1')}">
    <jsp:include page="top.jsp"/>
</c:if>
<c:if test="${sessionScope.customer.pow.equals('2')}">
    <jsp:include page="mtop.jsp"/>
</c:if>
<p align="center"><b>货物信息修改</b></p>
<form method="POST" action="/updateGoods" name="form1">

    <table width="786" border="0" align="center" cellpadding="0" cellspacing="0"  bordercolordark="#333333" bordercolorlight="#FFFFFF">
        <tr>
            <td width="20%" height="43">
                <p align="center">货物类型：</p>
            </td>
            <td width="36%" height="43">
                <p align="center"><input type="text" name="gclass" value="${goodsMsg.goodsStyle}" size="20"></p>
            </td>
            <td width="18%" height="43">
                <p align="center">货物名称：</p>
            </td>
            <td width="30%" height="43">
                <p align="center"><input type="text" name="gname" size="20" value="${goodsMsg.goodsName}"></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="42">
                <p align="center">货物数量：</p>
            </td>
            <td width="36%" height="42">
                <p align="center"><input type="text" name="gcount" size="20"value="${goodsMsg.goodsNumber}"></p>
            </td>
            <td width="18%" height="42">
                <p align="center">数量单位：</p>
            </td>
            <td width="30%" height="42">
                <p align="center"><input type="text" name="gunit" size="20" value="${goodsMsg.goodsUnit}"></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="43">
                <p align="center">起始省份：</p>
            </td>
            <td width="36%" height="43">
                <p align="center"><input type="text" name="StartProvince" size="20" value="${goodsMsg.startProvince}"></p>
            </td>
            <td width="18%" height="43">
                <p align="center">起始城市：</p>
            </td>
            <td width="30%" height="43">
                <p align="center"><input type="text" name="StartCity" size="20" value="${goodsMsg.startCity}"></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="46">
                <p align="center">抵达省份：</p>
            </td>
            <td width="36%" height="46">
                <p align="center"><input type="text" name="EndProvince" size="20" value="${goodsMsg.endProvince}"></p>
            </td>
            <td width="18%" height="46">
                <p align="center">抵达城市：</p>
            </td>
            <td width="30%" height="46">
                <p align="center"><input type="text" name="EndCity" size="20" value="${goodsMsg.endCity}"></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="45">
                <p align="center">运输类型：</p>
            </td>
            <td width="36%" height="45">
                <p align="center">
                    <c:if test="${goodsMsg.style.equals('快速')}">
                    &nbsp; <select size="1" name="gtransstyle">
                    <option value="快速" selected>快速</option>
                    <option value="特快">特快</option>
                    <option value="加急">加急</option>
                        </c:if>
                        <c:if test="${goodsMsg.style.equals('特快')}">
                        &nbsp; <select size="1" name="gtransstyle">
                        <option value="快速" >快速</option>
                        <option value="特快" selected>特快</option>
                        <option value="加急">加急</option>
                        </c:if>
                        <c:if test="${goodsMsg.style.equals('加急')}">
                        &nbsp; <select size="1" name="gtransstyle">
                        <option value="快速" >快速</option>
                        <option value="特快" >特快</option>
                        <option value="加急" selected>加急</option>
                        </c:if>
                </select>
                </p>
            </td>
            <td width="18%" height="45">
                <p align="center">运输时间：</p>
            </td>
            <td width="30%" height="45">
                <p align="center"><input type="text" name="gtime" size="20" value="${goodsMsg.transportTime}"></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="45">
                <p align="center">联系电话></p>
            </td>
            <td width="36%" height="45">
                <p align="center"><input type="text" name="gphone" size="20" value="${goodsMsg.phone}"></p>
            </td>
            <td width="18%" height="45">
                <p align="center">联系人：</p>
            </td>
            <td width="30%" height="45">
                <p align="center"><input type="text" name="glink" size="20"value="${goodsMsg.link}"></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="40"  c>
                <p align="center">发布时间：</td>
            <td width="36%" height="40" colspan="3">
               <fmt:formatDate value='${goodsMsg.issueDate}'  pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" />
            </td>
        </tr>
        <tr>
            <td width="20%" height="78">
                <p align="center">备注：</p>
            </td>
            <td width="84%" height="78" colspan="3">
                <p align="left"><textarea rows="5" name="gremark" cols="80">${goodsMsg.remark}</textarea></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="74">
                <p align="center">车辆要求：</p>
            </td>
            <td width="84%" height="74" colspan="3">
                <p align="left"><textarea rows="5" name="grequest" cols="80">${goodsMsg.request}</textarea></p>
            </td>
        </tr>
        <tr>
            <td width="20%" height="33">
                <p align="center">发布人：</td>
            <td width="36%" height="33">
                <p align="center">${goodsMsg.userName}</td>
            <td width="20%" height="33">
                <p align="center">ID</td>
            <td width="20%" height="33">
                <p align="center">${goodsMsg.id}</p>      </td>
        </tr>
        <tr>
            <td width="786" height="40" colspan="4">
                <p align="center">
                    <input type="submit" name="change" value="修改" onClick="return check()">
                    <input type="reset" value="重置">
            </td>
        </tr>
    </table>
    <input type="hidden" name="id1" value="${goodsMsg.id}">
</form>
</body>
</html>

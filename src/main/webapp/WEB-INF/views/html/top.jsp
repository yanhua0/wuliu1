<%@ page contentType="text/html; charset=gb2312" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script>
    $(function () {
        $("#admin").click(function () {
            if($("#name1").val().length!=0)
            {
                $.post("/admin/check",{},function (result) {
                    console.log(result);
                    if(result.code==-1)
                    {
                        window.location.href="/admin/index";
                    }
                    else{
                        alert("你不是管理员！！！");
                    }
                });
            }
           else {
                alert("您还未登录，不能浏览详细信息！！！");
            }

        })
    })
</script>
<input id="name1" type="hidden" value="${sessionScope.customer.name}">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td  height="80" align="center" background="/resources/image/1.jpg">

      <table height="80" border="0" cellpadding="0" cellspacing="0" background="/resources/image/2.jpg">
        <tr>
          <td width="787"></td>
        </tr>
      </table>

    </td>
  </tr>
</table>
<table width="100%" height="32" border="0" cellpadding="0" cellspacing="0" background="/resources/image/3.jpg">
  <tr>
    <td><table width="786"  border="0" align="center" cellpadding="0" cellspacing="0" background="/resources/image/4.jpg">
      <tr>
        <th width="597" height="31" align="center"><a href="/index" class="a1">本站首页</a>&nbsp;|&nbsp;<a href="/active_select" class="a1">物流动态</a>&nbsp;|&nbsp;<a href="/knowledge_select" class="a1">物流知识</a>&nbsp;|&nbsp;<a href="/goods_select" class="a1">货物信息</a>&nbsp;|&nbsp;<a href="/car_select" class="a1">车辆信息</a>&nbsp;|&nbsp;<a href="/enterprise_select" class="a1">企业信息</a>&nbsp;|&nbsp;<a href="/logout" class="a1">退出</a>&nbsp;|&nbsp;<a href="javascript:void(0)"  id="admin" class="a1">后台管理</a></th>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" height="115" border="0" cellpadding="0" cellspacing="0" background="/resources/image/5.jpg" >
  <tr>
    <td valign="top"><table width="787" height="151" border="0" align="center" cellpadding="0" cellspacing="0" background="/resources/image/6.jpg">
      <tr>
        <td><table width="585" align="right">
          <tr>
            <td width="577" height="109" valign="top">
            </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
    <!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form action="dept/save" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr><input type="hidden" name="id" value="${dept.id }">
        <td width="10%" class="tableleft">部门名称</td>
        <td><input type="text" name="name" value="${dept.name }" onkeyup="validateUsername(this.value)"/>
        <span id="msg"></span>
        </td>
    </tr>
    <tr>
        <td class="tableleft">部门描述</td>
        <td><textarea type="text" rows="5" cols="10" name="memo">${dept.memo }</textarea></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="dept/query";
		 });

    });
    
    function validateUsername(username){
    	$.getJSON("<%=path%>/dept/validate?username="+username+"&time="+new Date(),function(json){
    		if (json.flag==0) {
				$("#msg").css("color","red");
			}else{
				$("#msg").css("color","blue");
			}
				$("#msg").html(json.msg);
			
    	})
    	
    }
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
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

@media ( max-width : 980px) {
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
	<form action="user/save" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<input type="hidden" name="userid" value="${user.userid }">
				<td width="10%" class="tableleft">登录名</td>
				<td><input type="text" name="username"
					value="${user.username }" onkeyup="validateUsername(this.value)" />
					<span id="msg"></span></td>
			</tr>
			<tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password"
					value="${user.password }" /></td>
			</tr>
			<tr>
				<td class="tableleft">真实姓名</td>
				<td><input type="text" name="realname"
					value="${user.realname }" /></td>
			</tr>
			<tr>
				<td class="tableleft">手机号码</td>
				<td><input type="text" name="telephone"
					value="${user.telephone}" /></td>
			</tr>
			<tr>
				<td class="tableleft">性别</td>
				<td><select name="sex">
						<option value="2">---请选择性别---</option>
						<option value="0" ${user.sex==0?'selected':'' }>女</option>
						<option value="1" ${user.sex==1?'selected':'' }>男</option>
				</select></td>
			</tr>
			<tr>
				<td class="tableleft">所在部门</td>
				<td><select name="did">
						<option value="0">---请选择所在组---</option>
						<c:forEach items="${deptlist}" var="d">
							<option value="${d.id }" ${d.id==user.did?'selected':'' }>${d.name }</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td><c:forEach items="${rolelist }" var="r">
						<input type="checkbox" name="rids" value="${r.rid }"
							${fn:contains(user.rids,r.rid)?'checked':'' } />${r.rolename }
			</c:forEach></td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="<%=path%>/user/query";
		 });

    });
    function validateUsername(username){
    	$.getJSON("<%=path%>/user/validate?username=" + username + "&time="
				+ new Date(), function(json) {
			if (json.flag == 0) {
				$("#msg").css("color", "red");
			} else {
				$("#msg").css("color", "blue");
			}
			$("#msg").html(json.msg);

		})

	}
</script>
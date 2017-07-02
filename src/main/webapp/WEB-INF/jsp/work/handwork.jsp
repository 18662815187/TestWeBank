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
<form enctype="multipart/form-data" action="work/save" method="post"
		class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<input type="hidden" name="userid"/>
			<tr>
				<td colspan="6"><h3>客户信息</h3></td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">客户姓名</td>
				<td>${work.workorderid }</td>

				<td width="10%" class="tableleft">性别</td>
				<td><select name="customer.sex">
						<option value="0">未知</option>
						<option value="1">男</option>
						<option value="2">女</option>
				</select></td>

				<td width="10%" class="tableleft">证件类型</td>
				<td>
				<select name="customer.certificatetype">
						<c:forEach items="${datalist }" var="d">
						   <c:if test="${d.pid==1 }">
						      <option value="${d.id }" >${d.name }</option>
						   </c:if>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">证件号码</td>
				<td>${work.centificatenumber }</td>

				<td width="10%" class="tableleft">手机号</td>
				<td><input type="text" name="customer.telephone" value="${customer.telephone }"/></td>

				<td width="10%" class="tableleft">微信白名单openId</td>
				<td><input type="text" name="customer.wechatwhite" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">QQ白名单openId</td>
				<td><input type="text" name="customer.qqwhile" /></td>

				<td width="10%" class="tableleft">开户渠道</td>
				<td><select name="customer.openchannel">
						<c:forEach items="${datalist }" var="d">
						   <c:if test="${d.pid==2 }">
						      <option value="${d.id }">${d.name }</option>
						   </c:if>
						</c:forEach>
				</select></td>

				<td width="10%" class="tableleft">客群分类</td>
				<td><input type="text" name="customer.customertype" /></td>
			</tr>
			<tr>
				<td colspan="6"><h3>客户进线信息</h3></td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">进线渠道</td>
				<td><select name="customer.comeinchannel">
						<c:forEach items="${datalist }" var="d">
						   <c:if test="${d.pid==3 }">
						      <option value="${d.id }">${d.name }</option>
						   </c:if>
						</c:forEach>
				</select></td>

				<td width="10%" class="tableleft">来电号码</td>
				<td><input type="text" name="customer.callphone" /></td>


			</tr>
			<tr>
				<td colspan="6"><h3>工单信息</h3></td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">处理时效</td>
					<td>
						${work.aging }
					</td>

				<td width="10%" class="tableleft">紧急程度</td>
				<td>
					${work.urgencylevel }
				</td>

				<td width="10%" class="tableleft">问题类型</td>
				<td>
					${work.problemtypename }
				</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">流转对象</td>
				<td><select name="handlegroup"
					onchange="changeGroup(this.value)">
						<option value="0">--请选择--</option>
						<c:forEach items="${deptlist }" var="d">
						      <option value="${d.id }">${d.name }</option>
						</c:forEach>
				</select></td>

				<td width="10%" class="tableleft">处理人</td>

				<td>
					<%-- ${work.handleperson } --%>
				</td>

				<td width="10%" class="tableleft"></td>
				<td></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">问题描述</td>
				<td colspan="5"><input type="text" name="username" /></td>


			</tr>
			<tr>
				<td width="10%" class="tableleft">上传文件</td>
				<td colspan="5">
				<input type="file" name="files" />
				<input type="file" name="files" />
				</td>

			</tr>
			<tr>

				<td colspan="6" style="text-align: center;">
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
	<div class="panel panel-default definewidth m20">
		<div class="panel-heading">
			<h3>工单处理</h3>
		</div>
		<div class="panel-body">
			<ul id="myTab" class="nav nav-tabs definewidth m20">
				<li class="active"><a href="#addhandle" data-toggle="tab">
						新增处理 </a></li>
				<li><a href="#addDesc" data-toggle="tab">添加描述</a></li>
				<li><a href="#cui" data-toggle="tab">催办</a></li>
			</ul>
			<div id="myTabContent" class="tab-content definewidth m20">
				<c:choose>
				 <c:when test="${work.status!=2 }">
				<div class="tab-pane fade in active" id="addhandle">
					<c:if test="${sessionScope.LOGIN_USER.userid==work.handleperson }">
					<form action="work/handle" method="post">
						<input type="hidden" name="workorderid"
							value="${work.workorderid }">
						<table class="table table-bordered table-hover ">
							<tr>
								<td><input type="radio" name="status" value="1">转办
									<select name="handlegroup" onchange="changeGroup(this.value)">
										<option value="0">--请选择--</option>
										<c:forEach items="${deptlist }" var="d">
											<option value="${d.id }">${d.name }</option>
										</c:forEach>
								</select> <select name="handleperson" id="handleperson">
										<option value="0">--请选择处理人--</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="radio" name="status" value="3">退单
									<select name="backhandleperson">
										<c:forEach items="${backUserList }" var="u">
										    <option value="${u.handleperson }">${u.handlepersonname }</option>
										</c:forEach>
								     </select>
								</td>

							</tr>
							<tr>
								<td><input type="radio" name="status" value="4">挂起
								</td>
							</tr>
							<tr>
								<td><input type="radio" name="status" value="2">归档</td>
							</tr>
							<tr>
								<td><textarea name="descs" placeholder="问题描述"></textarea></td>
							</tr>
							<tr>
								<td>
									<button type="submit" class="btn btn-primary" type="button">保存</button>
									&nbsp;&nbsp;
								</td>
							</tr>
						</table>
					</form>
                   </c:if>
				</div>
				<c:if test="${sessionScope.LOGIN_USER.userid!=work.handleperson }">
				<div class="tab-pane fade" id="addDesc">
					<form action="work/handle" method="post">
						<input type="hidden" name="workorderid"
							value="${work.workorderid }">
						<table class="table table-bordered table-hover ">

							<tr>
								<td><textarea name="descs" placeholder="问题描述"></textarea></td>
							</tr>
							<tr>
								<td>
									<button type="submit" class="btn btn-primary" type="button">保存</button>
									&nbsp;&nbsp;
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div class="tab-pane fade" id="cui">
					<form action="work/handle" method="post">
						<input type="hidden" name="workorderid"
							value="${work.workorderid }">
						<table class="table table-bordered table-hover ">

							<tr>
								<td><textarea name="descs" placeholder="问题描述"></textarea></td>
							</tr>
							<tr>
								<td>
									<button type="submit" class="btn btn-primary" type="button">保存</button>
									&nbsp;&nbsp;
								</td>
							</tr>
						</table>
					</form>
				</div>
				</c:if>
				</c:when>
				<c:otherwise>
				   处理完成，已经归档
				</c:otherwise>
               </c:choose>
			</div>
		</div>
	</div>

	<!-- 下面是历史记录的界面 -->
	<div class="panel panel-default definewidth m20">
		<div class="panel-heading">
			<h3>历史处理记录</h3>
		</div>
		<div class="panel-body">
			<div class="media">
				<c:forEach items="${historylist }" var="h">
					<a class="pull-left" href="#"> <img class="media-object"
						src="assets/img/one.jpg" width="100" height="150" alt="媒体对象">
					</a>
					<div class="media-body">
						<p>处理组：${h.handlegroupname } 处理人：${h.handlepersonname }
						操作：${h.actionstr }</p>
						<p>操作时间：
						   <fmt:formatDate value="${h.createdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						
						处理意见：
						${h.descs }
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="<%=path%>/user/query";
		 });

    });
    function changeGroup(did){
    	$.getJSON("<%=path%>/work/queryByDid?did="+did+"&time="+new Date(),function(json){
    		
    		$("#handleperson").empty();
    		$.each(json,function(i){
    			$("#handleperson").append("<option value='"+json[i].userid+"'>"+json[i].username+"</option>");
    		});
			
    	})
    	
    }
</script>
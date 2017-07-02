<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
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
<form class="form-inline definewidth m20" action="role/query" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"
    class="abc input-default" placeholder="角色名称查询" value="${vo.keywords }">&nbsp;&nbsp;  
    
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增角色</button>

</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>角色id</th>
        <th>角色名称</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    </thead>
    	<c:forEach items="${pageModel.list }" var="role">
    		<tr>
            <td>${role.rid }</td>
            <td>${role.rolename }</td>
            <td>${role.description }</td>
               
            <td>
                
			   <a href="role/updatePage/${role.rid }">编辑</a> 
			   <%-- <a href="user/delete/${user.userid }">删除</a>  --%>
			   <a href="javascript:void(0)" onclick="del(${role.rid })">删除</a>
			                  
            </td>
        </tr>	
    </c:forEach>
	     
</table>
<form action="role/query" id="pager" method="post">
	<input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum }">
	<input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize }">
	<input type="hidden" name="keywords" value="${vo.keywords }"/>
</form>
 <div class="inline pull-right page">
	<%@include file="../../pageBar.jsp" %>
	<%-- <jsp:include page="../../pageBar.jsp"></jsp:include> --%>
</div>  
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="<%=path%>/role/init";
		 });
		 
		 $('#synnew').click(function(){

				window.location.href="sys/user_synUser";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "<%=path%>/role/delete?id="+id;
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
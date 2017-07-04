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
<form class="form-inline definewidth m20" action="work/queryAll" method="post">    
    关键字：
    <input type="text" name="workorderid" id="workorderid"
    class="abc input-default" placeholder="工单编号" value="${vo.workorderid }">&nbsp;&nbsp;
    <input type="text" name="customername" id="customername"
    class="abc input-default" placeholder="客户姓名查询" value="${vo.customername }">&nbsp;&nbsp;
    <input type="text" name="centificatenumber" id="centificatenumber"
    class="abc input-default" placeholder="证件号码查询" value="${vo.centificatenumber }">&nbsp;&nbsp;
    <input type="text" name="status" id="status"
    class="abc input-default" placeholder="状态查询" value="${vo.status }">&nbsp;&nbsp;
    <input type="text" name="handlegroup" id="handlegroup"
    class="abc input-default" placeholder="所在小组查询" value="${vo.handlegroup }">&nbsp;&nbsp;  
    
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">创建工单</button>
    <!-- <button type="button" class="btn btn-success" id="synnew">同步用户</button> -->
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>工单编码</th>
        <th>客户姓名</th>
        <th>证件号码</th>
        <th>问题类型</th>
        <th>处理小组</th>
        <th>处理人员</th>
        <th>紧急程度</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>剩余时效</th>
        <th>催办次数</th>
        <th>首次处理时间</th>
        <!-- <th>操作</th> -->
    </tr>
    </thead>
    	<c:forEach items="${pageModel.list}" var="work">
    		<tr>
            <td><a href="work/handworkPage/${work.workorderid }"/>${work.workorderid }</td>
            <td>${work.customername}</td>
            <td>${work.centificatenumber}</td>
            <td>${work.problemtypename}</td>
            <td>${work.handlegroupname}</td>
            <td>${work.handlepersonname}</td>
            <td>${work.urgencylevelname}</td>
            <td>
            	<c:choose>
            		<c:when test="${work.status==1 }">处理中</c:when>
            		<c:when test="${work.status==2 }">归档</c:when>
            		<c:when test="${work.status==3 }">退单</c:when>
            		<c:when test="${work.status==4 }">挂起</c:when>
            		<c:otherwise>
            				未处理
            		</c:otherwise>
            	</c:choose>
            	
            </td>
            <td>
            	<fmt:formatDate value="${work.creatdate }" pattern="yyyy-MM-dd"/>
			</td>
            <td>剩余2天10小时15分钟</td>
            <td>1</td>
            <td>
            	<fmt:formatDate value="${work.creatdate }" pattern="yyyy-MM-dd"/>
			</td>      
           <%--  <td> 
			   <a href="work/updatePage/${work.userid }">编辑</a> 
			   <a href="user/delete/${user.userid }">删除</a> 
			   <a href="javascript:void(0)" onclick="del(${work.userid })">删除</a>
            </td> --%>
        </tr>	
    </c:forEach>
	     
</table>
<form action="work/queryAll" id="pager" method="post">
	<input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum }">
	<input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize }">
	<input type="hidden" name="workorderid" value="${vo.workorderid }"/>
	<input type="hidden" name="customername" value="${vo.customername }"/>
	<input type="hidden" name="centificatenumber" value="${vo.centificatenumber }"/>
	<input type="hidden" name="status" value="${vo.status }"/>
	<input type="hidden" name="handlegroup" value="${vo.handlegroup }"/>
	<input type="hidden" name="handleperson" value="${vo.handleperson }"/>
</form>
 <div class="inline pull-right page">
	<%@include file="../../pageBar.jsp" %>
</div>  
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="<%=path%>/work/init";
		 });
		 
		 $('#synnew').click(function(){

				window.location.href="sys/user_synUser";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "<%=path%>/work/delete?id="+id;
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
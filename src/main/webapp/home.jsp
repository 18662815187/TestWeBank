<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>后台管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <img src="<%=basePath%>Images/top.png">
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">
    ${user.realname}
    </span><a href="<%=basePath%>/exit" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1'
        				,menu:[
        					{	
        						text:'系统管理'
        						,items:[
        							{
        								id:'12'
        								,text:'部门管理'
        								,href:'dept/query'
        							}
        							,{
        								id:'3'
        								,text:'角色管理'
        								,href:'role/query'
        							}
        							,{
        								id:'4'
        								,text:'用户管理'
        								,href:'user/query'
        							}
        							,{
        								id:'6'
        								,text:'菜单管理'
        								,href:'menu/query'
        							}
        							,{
        								id:'6'
        								,text:'数据字典'
        								,href:'data/query'
        							}
        							]}]}
        							,{
        								id : '7',
        								homePage : '9',
        								menu : [ {
        									text : '工单管理',
        									items : [ {
        										id : '9',
        										text : '创建工单',
        										href : 'work/init'
        									}, {
        										id : '3',
        										text : '我的工单',
        										href : 'work/queryMy'
        									}, {
        										id : '3',
        										text : '本组工单',
        										href : 'work/queryMyGroup'
        									}, {
        										id : '3',
        										text : '本组退单',
        										href : 'work/queryMyGroupBack'
        									}, {
        										id : '3',
        										text : '所有工单',
        										href : 'work/queryAll'
        									}, {
        										id : '3',
        										text : '在线人员',
        										href : 'role/query'
        									} ]
        								} ]
        							}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
<div style="text-align:center;">
<p>来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>
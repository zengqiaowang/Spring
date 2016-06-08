<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body> 
  	<!-- 测试注册
    <form method="post" action='<c:url value="user.html"></c:url>'>
     -->
    <!-- 测试请求数据转为json -->
    <form method="post" action='<c:url value="user/testSessionAttributes1.html"></c:url>'>
    	<table>
    		<tr>
    			<td>用户名</td>
    			<td><input id="userName" name="userName" type="text"></input></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input id="userPwd" name="userPwd" type="password"></input></td>
    		</tr>
    		<tr>
    			<td>姓名</td>
    			<td><input id="name" name="name" type="text"></input></td>
    		</tr>
    		
    		<tr>
    			<td colspan="2"><input type="submit" name="提交"></input></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>

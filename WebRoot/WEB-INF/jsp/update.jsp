<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UPDATE</title>
    
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
    <h1>学生信息编辑</h1>
  	<table border="1" width="100%">
  		<tr>
  			<th>id</th>
  			<th>name</th>
  			<th>学号</th>
  			<th>专业</th>
  			<th>辅导员</th>
  			<th>地区</th>
  		</tr>
  		<form action="/Spring-learning/update" method="post" onsubmit="return check()" name="fr2">
			<tr>
				<td><input type="text" name = "id" value = "${student.id}"></td>
				<td><input type="text" name = "sname" value = "${student.sname}"></td>
				<td><input type="text" name = "sid" value = "${student.sid}"></td>
				<td><input type="text" name = "profession" value = "${student.profession}"></td>
				<td><input type="text" name = "tname" value = "${student.tname}"></td>
				<td><input type="text" name = "area" value = "${student.area}"></td>
			</tr>
			<input type="submit" name="save" value="保存" >
  		</form>
  		
  		<script>
  			function check(){
				if(fr2.sname.value==""||fr2.sid.value==""||fr2.profession.value==""||fr2.tname==""||fr2.area.value==""){
					alert("请填写所有表单数据!");
				return false;
				}
				return true;
			}
  		</script>
  </body>
</html>

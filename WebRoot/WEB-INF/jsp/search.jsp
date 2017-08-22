<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Result</title>
    
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
  <button onclick = "javascript:history.back();">返回</button>
    <table border="1" width="100%">
    	<tr>
    		<th>Id</th>
    		<th>学生姓名</th>
    		<th>学号</th>
    		<th>专业</th>
    		<th>辅导员</th>
    		<th>地区</th>
    		<th>备注</th>
    	</tr>
    		<tr>
    			<td>"${result.id}"</td>
				<td>"${result.sname}"/></td>
				<td>"${result.sid}"/></td>
				<td>"${result.profession}"/></td>
				<td>"${result.tname}"/></td>
				<td>"${result.area}"/></td>
				<td width="100">
					<mvc:form method="post"  name="edit" action = "/Spring-learning/index">
					     <input type="button" name="delete" value="删除" onclick="deleteline(${result.id})" />
					     <input type="button" name="update" value="编辑" onclick="updateline(${result.id})" />
					 </mvc:form>
				</td>
    		</tr>
    	</table>
  </body>
</html>

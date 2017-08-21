<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息表</title>
    
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
    <table border="1" width="100%">
    	<tr>
    		<td>Id</td>
    		<td>学生姓名</td>
    		<td>学号</td>
    		<td>专业</td>
    		<td>辅导员</td>
    		<td>地区</td>
    		<td>备注</td>
    	</tr>
    	<c:forEach var="row" items="${studentsInfo}">
    		<tr>
    			<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.sname}"/></td>
				<td><c:out value="${row.sid}"/></td>
				<td><c:out value="${row.profession}"/></td>
				<td><c:out value="${row.tname}"/></td>
				<td><c:out value="${row.area}"/></td>
				<td width="100">
					<form method="post"  name="edit" action = "/Spring-learning/index">
					     <input type="button" name="delete" value="删除" onclick="deleteline(${row.id})" >
					     <input type="button" name="update" value="编辑" onclick="updateline(${row.id})" >
					 </form>
				</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
<script type="text/javascript">
	function deleteline(id){
		document.edit.action ="/Spring-learning/delete";
		document.edit.submit();
	}
	function updateline(id){
		window.open('update.jsp?id='+id,'EDIT','fullscreen=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no，width=1000,height=500');
	}
</script>
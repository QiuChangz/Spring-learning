<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int maxId = 0;
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
  <h1>学生信息记录</h1>
  <mvc:form action = "/Spring-learning/search">
  	<input type = "text" value = "请输入学生学号"></input>
  	<input type = "submit" value = "搜索"></input>
  </mvc:form>
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
    	<c:forEach var="row" items="${studentsInfo}">
    		<tr>
    			<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.sname}"/></td>
				<td><c:out value="${row.sid}"/></td>
				<td><c:out value="${row.profession}"/></td>
				<td><c:out value="${row.tname}"/></td>
				<td><c:out value="${row.area}"/></td>
				<td width="100">
					<mvc:form method="post"  name="edit" action = "/Spring-learning/index">
					     <input type="button" name="delete" value="删除" onclick="deleteline(${row.id})" >
					     <input type="button" name="update" value="编辑" onclick="updateline(${row.id})" >
					 </mvc:form>
				</td>
    		</tr>
    		<%maxId++; %>
    	</c:forEach>
    	
    	<mvc:form action="/Spring-learning/add" method="POST" name="add" onsubmit="return check()">
  			<tr>
  				<td><input type="hidden" name ="id" size=2 value=<%=maxId+1 %>><%=maxId+1 %></td>
  				<td><input type="text" name="sname" size="4" maxlength="4"></td>
  				<td><input type="text" name="sid" size="9" maxlength="9"></td>
  				<td><input type="text" name="profession" size="9" maxlength="10"></td>
  				<td><input type="text" name="tname" size="4" maxlength="4"></td>
  				<td><input type="text" name="area" size="5" maxlength="5"></td>
  				<td><input type="submit" name="add" value="添加"></td>
  			</tr>
  		</mvc:form>
  		
    </table>
  </body>
</html>
<script type="text/javascript">

	function check(){
		if(add.sname.value==""||add.sid.value==""||add.profession.value==""||add.tname==""||add.area.value==""){
			alert("请填写所有表单数据!");
			return false;
		}
		return true;
	}
	function deleteline(id){
		document.forms.edit.action ="/Spring-learning/delete?id="+id;
		document.forms.edit.submit();
	}
	function updateline(id){
		window.open('update?id='+id,'EDIT','fullscreen=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no，width=1000,height=500');
	}
</script>
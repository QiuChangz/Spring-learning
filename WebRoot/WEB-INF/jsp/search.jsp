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
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  
  <body>

    <table width="100%" class="table table-hover">
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
    			<td>${result.id}</td>
				<td>${result.sname}</td>
				<td>${result.sid}</td>
				<td>${result.profession}</td>
				<td>${result.tname}</td>
				<td>${result.area}</td>
				<td width="100">
					<mvc:form method="get"  name="edit" action = "/Spring-learning/index">
					     <input type="button" name="delete" value="删除" class="btn btn-default onclick="deleteline(${result.id})" />
					     <input type="button" name="update" value="编辑" class="btn btn-default onclick="updateline(${result.id})" />
					 </mvc:form>
				</td>
    		</tr>
    	</table>
    	<button class="btn btn-default" onclick = "javascript:window.close();">返回</button>
  </body>
</html>
<script type="text/javascript">
	function deleteline(id){
		document.forms.edit.action ="/Spring-learning/delete/"+id;
		document.forms.edit.submit();
	}
	function updateline(id){
		window.open('update/'+id,'EDIT','fullscreen=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no，width=1000,height=500');
	}
</script>

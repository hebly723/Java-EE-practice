<%@ page language="java" import="java.util.* ,java.sql.*,data.*,order.*" pageEncoding="utf-8"%>
<jsp:include page="top.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>员工页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<link rel="stylesheet" type="text/css" href="css/employee.css">

  </head>
  
   <body>
    <form class="guide"  action="Employee_select" method="post">
  		employeeNo<input type="text" name="employeeNo"/>
		employeeName<input type="text" name="employeeName"/>
		gender<input type="text" name="gender"/>
		birthday<input type="text" name="birthday"/>
		address<input type="text" name="address"/>
		telephone<input type="text" name="telephone"/>
		hireDate<input type="text" name="hireDate"/>
		department<input type="text" name="department"/>
		headShip<input type="text" name="headShip"/>
		salary<input type="text" name="salary"/>
  		<input type="submit" value="查询" class="select_employee_btn">
  	</form>
  	<input type="text" name="employeeNo" value="employeeNo" class="search_condition"/>
		<input type="text" name="employeeName" value="employeeName" class="search_condition"/>
		<input type="text" name="gender" value="gender" class="search_condition"/>
		<input type="text" name="birthday" value="birthday" class="search_condition"/>
		<input type="text" name="address" value="address" class="search_condition"/>
		<input type="text" name="telephone" value="telephone" class="search_condition"/>
		<input type="text" name="hireDate" value="hireDate" class="search_condition"/>
		<input type="text" name="department" value="department" class="search_condition"/>
		<input type="text" name="headShip" value="headShip" class="search_condition"/>
		<input type="text" name="salary" value="salary" class="search_condition"/>
  		<input value="操作" type="image"/>
  			<br/>
  		 <%
 		try{
  		String sql = request.getAttribute("sql").toString();
  		if (sql!=null&&sql.trim()!=""){
  		ResultSet ret = product.select(sql);
  			 if (ret!=null){
  			 while (ret.next()){
  		 %>
			 				<form class="update_form" action="Employee_update" method="post">
							<input type="text" name="employeeNo" value="<%=ret.getString("employeeNo")%>"readonly="readonly" class="search_result"/>
							<input type="text" name="employeeName" value="<%=ret.getString("employeeName")%>" class="search_result"/>
							<input type="text" name="gender" value="<%=ret.getString("gender")%>" class="search_result"/>
							<input type="text" name="birthday" value="<%=ret.getString("birthday")%>" class="search_result"/>
							<input type="text" name="address" value="<%=ret.getString("address")%>" class="search_result"/>
							<input type="text" name="telephone" value="<%=ret.getString("telephone")%>" class="search_result"/>
							<input type="text" name="hireDate" value="<%=ret.getString("hireDate")%>" class="search_result"/>
							<input type="text" name="department" value="<%=ret.getString("department")%>" class="search_result"/>
							<input type="text" name="headShip" value="<%=ret.getString("headShip")%>" class="search_result"/>
							<input type="text" name="salary" value="<%=ret.getString("salary")%>" class="search_result"/>
							<input class="update_btn" value="修改" type="submit">
							<a href="Employee_update?product_id=<%=ret.getString("employeeNo") %>"class="delete_btn" >
							删除
							</a>
						</form>
  		 <% 
  		 		 }}}}catch(Exception e)
		 {
		 }
  		 //}
  		 //}
  		 %>
  		 <form class="add_form" action="Product_add" method="post">
  		 	<input class="info_add" name="productNo"/>
  		 	<input class="info_add" name="productName"/>
  		 	<input class="info_add" name="productClass"/>
  		 	<input class="info_add" name="productPrice"/>
  		 	<input class="info_add" name="inStock"/>
  		 	<input  
  		 	class="add_btn" value="提交" type="submit"/>
  		 	</form>
  		 
  </body>
</html>

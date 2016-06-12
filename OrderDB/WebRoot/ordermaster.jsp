<%@ page language="java" import="java.util.* ,java.sql.*,data.*,order.*" pageEncoding="utf-8"%>
<jsp:include page="top.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单主表</title>
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<link rel="stylesheet" type="text/css" href="css/ordermaster.css">

  </head>
  
    <body>
    <form class="guide"  action="OrderMaster_select" method="post">
  		ordertNo:<input type="text" name="ordertNo"/>
  		employeeNo:<input type="text" name="employeeNo"/>
  		customerNo:<input type="text" name="customerNo"/>
  		orderDate:<input type="text" name="orderDate"/>
  		orderSum:<input type="text" name="orderSum"/>
  		invoiceNo:<input type="text" name="invoiceNo"/><br/>
  		<input type="submit" value="查询" class="select_ordermaster_btn">
  	</form>
	<form>
  			<input value="ordertNo" type="text" class="search_condition"/>
  		 	<input value="employeeNo" type="text" class="search_condition"/>
  		 	<input value="customerNo" type="text" class="search_condition"/>
  		 	<input value="orderDate" type="text" class="search_condition"/>
  		 	<input value="orderSum" type="text" class="search_condition"/>
  		 	<input value="invoiceNo" type="text" class="search_condition"/>
  		 	<input value="操作" type="image"/>
  	</form>
  		<%
 		try
		{
		String sql = request.getAttribute("sql").toString();
  		if (sql!=null&&sql.trim()!="")
			{
  			ResultSet ret = product.select(sql);
  			if (ret!=null)
				{
  			 while (ret.next())
					{
  		%>
			 				<form class="update_form" action="OrderMaster_update" method="post">
								<input value="<%=ret.getString("orderNo")%>" class="search_result" readonly="readonly" name="orderNo"/>
  		 						<input value="<%=ret.getString("employeeNo")%>" class="search_result" name="employeeNo"/>
  		 						<input value="<%=ret.getString("customerNo")%>" class="search_result" name="customerNo"/>
  		 						<input value="<%=ret.getString("orderDate")%>" class="search_result" name="orderDate"/>
  		 						<input value="<%=ret.getString("orderSum")%>" class="search_result" name="orderSum"/>
  		 						<input value="<%=ret.getString("invoiceNo")%>" class="search_result" name="invoiceNo"/>
								<input class="update_btn" value="修改" type="submit">
								<a href="OrderMaster_update?ordermaster_id=<%=ret.getString("orderNo") %>"class="delete_btn" >
								删除
								</a>
							</form>
  		<% 
					}
				}
			}
		}catch(Exception e)
		{
		}
  		%>
  		 <form class="add_form" action="OrderMaster_add" method="post">
  		 	<input class="info_add" name="orderNo"/>
  		 	<input class="info_add" name="employeeNo"/>
  		 	<input class="info_add" name="customerNo"/>
  		 	<input class="info_add" name="orderDate"/>
  		 	<input class="info_add" name="orderSum"/>
  		 	<input class="info_add" name="invoiceNo"/>
  		 	<input class="add_btn" value="提交" type="submit"/>
  		 </form>
  		 
  </body>
</html>

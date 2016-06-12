<%@ page language="java" import="java.util.* ,java.sql.*,data.*,order.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="top.jsp"/>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="css/top.css">
    <link rel="stylesheet" type="text/css" href="css/product.css">
    <title>产品页面</title>
	
  </head>
  
  <body>
    <form class="guide"  action="Product_select" method="post">
  		productNo:<input type="text" name="productNo"/>
  		productName:<input type="text" name="productName"/>
  		productClass:<input type="text" name="productClass"/>
  		productPrice:<input type="text" name="productPrice"/>
  		inStock:<input type="text" name="inStock"/><br/>
  		<input type="submit" value="查询" class="select_product_btn">
  	</form>
  			<input value="productNo" type="text" class="search_condition"/>
  		 	<input value="productName" type="text" class="search_condition"/>
  		 	<input value="productClass" type="text" class="search_condition"/>
  		 	<input value="productPrice" type="text" class="search_condition"/>
  		 	<input value="inStock" type="text" class="search_condition"/>
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
  		 	<form class="update_form" action="Product_update" method="post">
  		 	<input value="<%=ret.getString("productNo") %>" class="search_result" readonly="readonly" name="productNo"/>
  		 	<input value="<%=ret.getString("productName") %>" class="search_result" name="productName"/>
  		 	<input value="<%=ret.getString("productClass") %>" class="search_result" name="productClass"/>
  		 	<input value="<%=ret.getString("productPrice") %>" class="search_result" name="productPrice"/>
  		 	<input value="<%=ret.getString("inStock") %>" class="search_result" name="inStock"/>
  		 	<input  
  		 	class="update_btn" value="修改" type="submit">
  		 	<a href="Product_update?product_id=<%=ret.getString("productNo") %>"
  		 	 class="delete_btn" >
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

<%@ page language="java" import="java.util.* ,java.sql.*,data.*,order.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="top.jsp"/>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="css/top.css">
    <link rel="stylesheet" type="text/css" href="css/customer.css">
    <title>顾客页面</title>
	
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
  	<table class="product_result">
  		<tr>
  			<td>productNo</td>
  			<td>productName</td>
  			<td>productClass</td>
  			<td>productPrice</td>
  			<td>inStock</td>
  			<td>操作</td>
  		</tr>
  		<%
  		try{
  		String sql = request.getAttribute("sql").toString();
  		if (sql!=null&&sql.trim()!=""){
  		ResultSet ret = product.select(sql);
		//product pro = new product();
		//ResultSet ret = pro.select(sql);
		//if (sql!=null&&sql.trim()!="")
		// pro.select(sql);

  			 if (ret!=null){
  			 while (ret.next()){
  		 %>
  		<tr>
  		 	<td><%=ret.getString("productNo") %></td>
  		 	<td><%=ret.getString("productName") %></td>
  		 	<td><%=ret.getString("productClass") %></td>
  		 	<td><%=ret.getString("productPrice") %></td>
  		 	<td><%=ret.getString("inStock") %></td>
  		 	<td>
  		 	<font size="2" color="blue">
  		 	<a href="update_ope.jsp?product_id=<%=ret.getString("productNo") %>" class="update_btn">
  		 	修改
  		 	</a>
  		 	<a href="update_ope.jsp?product_id=<%=ret.getString("productNo") %>" class="delete_btn">
  		 	删除
  		 	</a>
  		 	</font>
  		 	</td>
  		 </tr>
  		 <% 
  		 		 }}}}catch(Exception e)
		 {
		 }
  		 //}
  		 //}
  		 %>
  	</table>
  </body>
</html>

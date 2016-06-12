<%@ page language="java" import="java.util.* ,java.sql.*,data.*,order.*" pageEncoding="utf-8"%>
<jsp:include page="top.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'random.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<link rel="stylesheet" type="text/css" href="css/random.css">

  </head>
  
  <body>
    <form class="guide"  action="Random_select" method="post">
  		<input type="text" value="<%=request.getParameter("a")%>" name="a"/>:
  		<input type="text" value="<%=request.getParameter("condition_a")%>" name="condition_a"/><br/>
  		<input type="text" value="<%=request.getParameter("b")%>" name="b"/>:
  		<input type="text" value="<%=request.getParameter("condition_b")%>" name="condition_b"/><br/>
  		<input type="text" value="<%=request.getParameter("c")%>" name="c"/>:
  		<input type="text" value="<%=request.getParameter("condition_c")%>" name="condition_c"/><br/>
  		<input type="text" value="<%=request.getParameter("d")%>" name="d"/>:
  		<input type="text" value="<%=request.getParameter("condition_d")%>" name="condition_d"/>
  		<input type="submit" value="查询" class="select_ordermaster_btn"/><br/>
  		<input name="out_a" value="<%=request.getParameter("out_a")%>" type="text" class="search_condition"/>
  		<input name="out_b" value="<%=request.getParameter("out_b")%>" type="text" class="search_condition"/>
  		<input name="out_c" value="<%=request.getParameter("out_c")%>" type="text" class="search_condition"/>
  		<input name="out_d" value="<%=request.getParameter("out_d")%>" type="text" class="search_condition"/>
  		
  	</form>
  		<%
 		try
		{
		String out_a = "" + request.getParameter("out_a")+"";
		String out_b = "" + request.getParameter("out_b")+"";
		String out_c = "" + request.getParameter("out_c")+"";
		String out_d = "" + request.getParameter("out_d")+"";
		String sql = request.getAttribute("sql").toString();
  		if (sql!=null&&sql.trim()!="")
			{
  			ResultSet ret = product.select(sql);
  			if (ret!=null)
				{
  			 while (ret.next())
					{
  		%>
			 				<form class="update_form">
								<input value="<%=ret.getString(out_a)%>" class="search_result" name="orderNo"/>
  		 						<input value="<%=ret.getString(out_b)%>" class="search_result" name="employeeNo"/>
  		 						<input value="<%=ret.getString(out_c)%>" class="search_result" name="customerNo"/>
  		 						<input value="<%=ret.getString(out_d)%>" class="search_result" name="orderDate"/>
							</form>
  		<% 
					}
				}
			}
		}catch(Exception e)
		{
		}
  		%>
  		 
  </body>
</html>

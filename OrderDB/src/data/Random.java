package data;

public class Random {

	public Random()
	{
		;
	}
	
	public static String selectConnect( 
			String out_a, String out_b, String out_c, String out_d,
			String a, String condition_a,
			String b, String condition_b,
			String c, String condition_c,
			String d, String condition_d
			)
	{
		String[] str = new String[4];
		String[] con = new String[4];
		String[] out = new String[4];
		String sqlBegin = "select ";
		int i = 0;
		int k = 0;
		
		if (out_a!=null&&out_a.trim()!="")
		{
			out[k] = out_a;
			out[k] = match(out[k].trim()) + "." + out[k];
			k++;
		}
		
		if (out_b!=null&&out_b.trim()!="")
		{
			out[k] = out_b;
			out[k] = match(out[k].trim()) + "." + out[k];
			k++;
		}
		
		if (out_c!=null&&out_c.trim()!="")
		{
			out[k] = out_c;
			out[k] = match(out[k].trim()) + "." + out[k];
			k++;
		}
		
		if (out_d!=null&&out_d.trim()!="")
		{
			out[k] = out_d;
			out[k] = match(out[k].trim()) + "." + out[k];
			k++;
		}
		
		if (a!=null&&a.trim()!="")
		{
			str[i] = a;
			str[i] = match(str[i].trim()) + "." + str[i];
			if (condition_a!=null && condition_a.trim()!="")
				con[i] = condition_a;
			System.out.println(str[i]);
			System.out.println(con[i]);
			i++;
		}
		
		if (b!=null&&b.trim()!="")
		{
			str[i] = b;
			str[i] = match(str[i].trim()) + "." + str[i];
			if (condition_b!=null&& condition_b.trim()!="")
				con[i] = condition_b;
			System.out.println(str[i]);
			i++;
		}
		
		if (c!=null&&c.trim()!="")
		{
			str[i] = c;
			str[i] = match(""+str[i]+"") + "." + str[i];
			if (condition_c!=null&& condition_c.trim()!="")
				con[i] = condition_c;
			System.out.println(str[i]);
			i++;
		}
		
		if (d!=null&&d.trim()!="")
		{
			str[i] = d;
			str[i] = match(str[i].trim()) + "." + str[i];
			if (condition_d!=null&& condition_d.trim()!="")
				con[i] = condition_d;
			System.out.println(str[i]);
			i++;
		}
		int j = 0;
		String content = "";
		String condition = "";
		
		for (j=0;j<4;j++)
		{
			if(out[j]!=null)
			{
				content = content + out[j];
				//condition = condition + " and " + out[j] + " like '%" + out[j] +"%'";
			}
			if(j!=3)
			{
				if (out[j]!=null)
				{
					content = content + ",";
				}
			}
			
			if(str[j]!=null)
			{
				//content = content + str[j];
				if (con[j]==null)
					con[j] = "";
				condition = condition + " and " + str[j] + " like '%" + con[j] +"%'";
			}
			
		}
		
		String sqlEnd = " from OrderDetail, OrderMaster, Employee, Product, Customer"
						+ " where OrderMaster.orderNo = OrderDetail.orderNo and"
						+ " OrderDetail.productNo = Product.productNo and"
						+ " OrderMaster.customerNo = Customer.customerNo and"
						+ " OrderMaster.employeeNo = Employee.employeeNo";
		
		String sql = sqlBegin + content + sqlEnd + condition + ";";
		str = null;
		return sql;
	}
	
	public static void main(String args[])
	{
		
		System.out.println("adas");
		
		System.out.println(selectConnect(  "orderSum", 
				"productName",  "customerName", "employeeName",
				"orderNo","ÕÅ ", "productNo",  "Íõ", "employeeNo" ,"¼Ö","customerNo", "»Æ" ));
		
		//System.out.println(str[0]);
	}
	
	public static String match(String parammeter)
	{
		String sql = null;
		parammeter = ""+parammeter.toString().trim()+"";
		if (parammeter.equals( "orderNo")||
				parammeter.equals("orderDate") ||
					parammeter.equals("orderSum") ||
						parammeter.equals("invoiceNo"))
			sql  = "OrderMaster";
		
		if (parammeter.equals("customerNo") ||
				parammeter.equals("customerName") ||
					parammeter.equals("telephone") ||
						parammeter.equals("address") ||
							parammeter.equals("zip"))
			sql = "Customer";
		
		if (parammeter.equals("quantity") ||
				parammeter.equals("price"))
			sql = "OrderDetail";
		
		if (parammeter.equals("employeeNo") ||
				parammeter.equals("employeeName") ||
					parammeter.equals("gender") ||
						parammeter.equals("birthday")||
							parammeter.equals("address")||
								parammeter.equals("telephone")||
									parammeter.equals("hiredate")||
										parammeter.equals("department")||
											parammeter.equals("headShip")||
												parammeter.equals("salary"))
			sql = "Employee";
		
		if (parammeter.equals("productNo") ||
				parammeter.equals("productName") ||
					parammeter.equals("productClass") ||
						parammeter.equals("productPrice") ||
							parammeter.equals("inStock"))
			sql = "Product";
		
		return sql;
	}
}

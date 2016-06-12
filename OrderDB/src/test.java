import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import data.*;
public class test {

	public static void main(String args[])
	{
		String productNo = "";
		String productName = "";
		String productClass = "";
		String productPrice = "";
		int inStock = 0;	
		
		product pro = new product();
		System.out.println(Random.selectConnect(  "orderSum", 
				"productName",  "customerName", "employeeName",
				"orderNo","’≈ ", "productNo",  "Õı", "employeeNo" ,"º÷","customerNo", "ª∆" ));
//		ResultSet ret = pro.select(productNo, productName, productClass, productPrice, inStock);
//		if (ret!=null)
//		try {
//			while (ret.next())
//			{
//				System.out.print(ret.getString("productNo")+"\t");
//				System.out.print(ret.getString("productName")+"\t");
//				System.out.print(ret.getString("productClass")+"\t");
//				System.out.print(ret.getString("productPrice")+"\t");
//				System.out.println(ret.getString("inStock"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}

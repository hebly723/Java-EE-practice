package data;
import data.connect;

import java.sql.*;
public class product {
	String productNo;
	String productName;
	String productClass;
	String productPrice;
	String inStock;					//如何考虑instock没有输入的情况
	public static Connection conn;
	
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getInStock() {
		return inStock;
	}
	public void setInStock(String inStock) {
		this.inStock = inStock;
	}
	
	public product()
	{
		conn = connect.getConn();
		productName="";
		productNo="";
		productClass="";
		//productPrice="";
	}
	
	public static ResultSet select( String sql ){
		ResultSet ret = null;
		conn = data.connect.getConn();
		try {
			Statement statement = conn.createStatement();
//			String sql = sql();
//					"select * from Product "
//					+ "where productNo like '%"+productNo+"%'"
//							+ " and productName like '%"+productName+"%'"
//									+ " and productClass like '%"+productClass+"%'"
//											+ " and productPrice like '%"+productPrice+"%' "
//											+"and instock like '%"+inStock+"%';";	
			//String sql = "select * from Product;";
			//and instock like %?%;";	
			System.out.println(sql);
			ret = statement.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public String selectSql(){
		String sql = 
				"select * from Product "
				+ "where productNo like '%"+productNo+"%'"
						+ " and productName like '%"+productName+"%'"
								+ " and productClass like '%"+productClass+"%'"
										+ " and productPrice like '%"+productPrice+"%' "
										+"and instock like '%"+inStock+"%';";
		return sql;
	}
	
	public String updateSql(){
		String sql = 
				"update Product"
					+ " set productClass='"+productClass+"',"
						+ " productName='"+productName+"',"
							+ " productPrice='"+productPrice+"',"
								+ "inStock='"+inStock+"'"
									+"where productNo = '"+productNo+"';";
		return sql;
	}
	
	public static void update( String sql ){
		ResultSet ret = null;
		conn = data.connect.getConn();
		try {
			Statement statement = conn.createStatement();
//			String sql = sql();
//					"select * from Product "
//					+ "where productNo like '%"+productNo+"%'"
//							+ " and productName like '%"+productName+"%'"
//									+ " and productClass like '%"+productClass+"%'"
//											+ " and productPrice like '%"+productPrice+"%' "
//											+"and instock like '%"+inStock+"%';";	
			//String sql = "select * from Product;";
			//and instock like %?%;";	
			System.out.println(sql);
			statement.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String deleteSql()
	{
		String sql = "delete from OrderDetail "
						+"where productNo = '"+productNo+"';"
							+"delete from Product "
								+"where productNo = '"+productNo+"';";
		return sql;
	}
	
	public String insertsql()
	{
		String sql ="insert into Product "
						+"values( '"+productNo+"', '"+productName+"','"
							+productClass+"',"+productPrice+","+inStock+");";
		return sql;
	}

}

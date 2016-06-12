package data;
import java.sql.*;
public class connect {
	
	public static Connection conn;
	/*public static void main(String args[]){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("加载驱动成功");
				conn = DriverManager.getConnection
						("jdbc:sqlserver://localhost:1433;DatabaseName=OrderDB", "dick", "123");
			System.out.println("连接成功");
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static Connection getConn()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("加载驱动成功");
				conn = DriverManager.getConnection
						("jdbc:sqlserver://localhost:1433;DatabaseName=OrderDB", "dick", "123");
			System.out.println("连接成功");
			//conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static ResultSet update( String sql ){
		conn = data.connect.getConn();
		ResultSet ret = null;
		try {
			Statement statement = conn.createStatement();
			System.out.println(sql);
			ret = statement.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
}

package data;

import java.sql.Date;

public class OrderMaster {
	String orderNo;
	String customerNo;
	String employeeNo;
	String orderDate;
	String orderSum;
	String invoiceNo;
	Date ldate;
	
	public Date getLdate() {
		return ldate;
	}

	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}

	//init method 
	public OrderMaster()
	{
		orderNo = "";
		customerNo = "";
		employeeNo = "";
		orderDate = "";
		orderSum = "";
		invoiceNo = "";
	}
	
	//Generate getter and setter
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		if ( orderNo != null)
		this.orderNo = orderNo;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		if (customerNo!=null)
		this.customerNo = customerNo;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		if (employeeNo!=null)
		this.employeeNo = employeeNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		if (orderDate!=null)
		this.orderDate = orderDate;
	}
	public String getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(String orderSum) {
		if (orderSum!=null)
		this.orderSum = orderSum;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		if (invoiceNo!=null)
		this.invoiceNo = invoiceNo;
	}
	
	public String selectSql()
	{
		String sql = 
				"select * from OrderMaster "
				+ "where employeeNo like '%"+employeeNo+"%'"
						+ " and orderNo like '%"+orderNo+"%'"
							+ " and customerNo like '%"+customerNo+"%'"
								+ " and orderDate like '%"+orderDate+"%' "
									+"and orderSum like '%"+orderSum+"%'"
										+" and invoiceNo like '%"+invoiceNo+"%';";
		
		return sql;
	}
	
	public String insertSql()
	{
		String sql ="insert into OrderMaster "
				+"values( '"+orderNo+"', '"+customerNo+"','"
					+employeeNo+"','"+orderDate+"',"+orderSum+",'"+invoiceNo+"');";
		
		return sql;
	}
	
	public String deleteSql()
	{
		String sql = "delete from OrderDetail "
				+"where orderNo = '"+orderNo+"';"
					+"delete from OrderMaster "
						+"where orderNo = '"+orderNo+"';";
		return sql;
	}
	
	public String updateSql(){
		String sql = 
				"update OrderMaster"
					+ " set customerNo='"+customerNo+"',"
						+ " employeeNo='"+employeeNo+"',"
							+ " invoiceNo='"+invoiceNo+"',"
								+ "orderDate='"+orderDate+"',"
									+ "orderSum='"+orderSum+"' "
										+"where orderNo = '"+orderNo+"';";
		return sql;
	}

}

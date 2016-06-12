package data;

public class Employee {

	String employeeNo;
	String employeeName;
	String gender;
	String birthday;
	String address;
	String telephone;
	String hireDate;
	String department;
	String headShip;
	String salary;
	
	public Employee()
	{
		employeeNo = "";
		employeeName = "";
		gender = "";
		birthday = "";
		address = "";
		telephone = "";
		hireDate = "";
		department = "";
		headShip = "";
		salary = "";
	}
	
	public String selectSql(){
		String sql = 
				"select * from Employee "
				+ "where employeeNo like '%"+employeeNo+"%'"
						+ " and employeeName like '%"+employeeName+"%'"
							+ " and gender like '%"+gender+"%'"
								+ " and birthday like '%"+birthday+"%' "
									+"and address like '%"+address+"%'"
										+" and telephone like '%"+telephone+"%'"
											+" and hireDate like '%"+hireDate+"%'"
												+" and department like '%"+department+"%'"
													+" and headShip like '%"+headShip+"%'"
														+" and salary like '%"+salary+"%';";
		System.out.println(sql);
		return sql;
	}
	
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		if (employeeNo!=null)
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		if (employeeName!=null)
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if (gender!=null)
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		if (birthday!=null)
		this.birthday = birthday;
	}
	public String getAddress() {

		return address;
	}
	public void setAddress(String address) {
		if (address!=null)
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		if (telephone!=null)
		this.telephone = telephone;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		if (hireDate!=null)
		this.hireDate = hireDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		if (department!=null)
		this.department = department;
	}
	public String getHeadShip() {
		return headShip;
	}
	public void setHeadShip(String headShip) {
		if (headShip!=null)
		this.headShip = headShip;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		if (salary!=null)
		this.salary = salary;
	}
	
}

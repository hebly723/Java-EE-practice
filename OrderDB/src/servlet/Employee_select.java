package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Employee;
import data.connect;
import data.product;

public class Employee_select extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Employee_select() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		Employee emp = new Employee();
//		pro.setProductNo(request.getParameter("productNo"));;
//		pro.setProductName(request.getParameter("productName"));
//		pro.setProductClass(request.getParameter("productClass"));
//		pro.setProductPrice(request.getParameter("productPrice"));
//		pro.setInStock(request.getParameter("inStock"));
		emp.setEmployeeNo(request.getParameter("employeeNo"));
		emp.setEmployeeName(request.getParameter("employeeName"));
		emp.setGender(request.getParameter("gender"));
		emp.setBirthday(request.getParameter("birthday"));
		emp.setAddress(request.getParameter("address"));
		emp.setTelephone(request.getParameter("telephone"));
		emp.setHireDate(request.getParameter("hireDate"));
		emp.setHireDate(request.getParameter("department"));
		emp.setHeadShip(request.getParameter("headShip"));
		emp.setSalary(request.getParameter("salary"));
		System.out.println("yuangongbianhao"+emp.getEmployeeNo());
		System.out.println(emp.getAddress());
		request.setAttribute("sql", emp.selectSql());
		ResultSet ret = connect.update(emp.selectSql());
		try {
			while (ret.next())
			{
				System.out.println(ret.getString("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

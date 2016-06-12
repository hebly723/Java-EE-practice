package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.OrderMaster;
import data.product;

public class OrderMaster_update extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3542118904864539067L;

	/**
	 * Constructor of the object.
	 */
	public OrderMaster_update() {
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
		response.setCharacterEncoding("utf-8");
		OrderMaster om = new OrderMaster();
		om.setOrderNo(request.getParameter("ordermaster_id"));;
		//request.setAttribute("sql", pro.updateSql());
		product.update(om.deleteSql());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ordermaster.jsp");
		requestDispatcher.forward(request, response);
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
		OrderMaster om = new OrderMaster();
		om.setOrderNo(request.getParameter("orderNo"));
		om.setCustomerNo(request.getParameter("customerNo"));
		om.setEmployeeNo(request.getParameter("employeeNo"));
		om.setOrderDate(request.getParameter("orderDate"));
		om.setOrderSum(request.getParameter("orderSum"));
		om.setInvoiceNo(request.getParameter("invoiceNo"));
		//request.setAttribute("sql", pro.updateSql());
		product.update(om.updateSql());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ordermaster.jsp");
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

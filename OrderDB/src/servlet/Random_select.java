package servlet;
import data.Random;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.OrderMaster;
import data.connect;

public class Random_select extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Random_select() {
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
		
		Random ran = new Random();
		String out_a = "" + request.getParameter("out_a")+"";
		String out_b = "" + request.getParameter("out_b")+"";
		String out_c = "" + request.getParameter("out_c")+"";
		String out_d = "" + request.getParameter("out_d")+"";
		String a = "" + request.getParameter("a")+"";
		String b = "" + request.getParameter("b")+"";
		String c = "" + request.getParameter("c")+"";
		String d = "" + request.getParameter("d")+"";
		String condition_a = "" + request.getParameter("condition_a")+"";
		String condition_b = "" + request.getParameter("condition_b")+"";
		String condition_c = "" + request.getParameter("condition_c")+"";
		String condition_d = "" + request.getParameter("condition_d")+"";
		System.out.println("'"+out_a+"'");
		System.out.println("'"+out_b+"'");
		System.out.println("'"+out_c+"'");
		System.out.println("'"+out_d+"'");
		System.out.println("'"+a+"'");
		System.out.println("'"+b+"'");
		System.out.println("'"+c+"'");
		System.out.println("'"+d+"'");
		System.out.println("'"+condition_a+"'");
		System.out.println("'"+condition_b+"'");
		System.out.println("'"+condition_c+"'");
		System.out.println("'"+condition_d+"'");
		String sql = Random.selectConnect(out_a, out_b, out_c, out_d, a, condition_a, b, condition_b, c, condition_c, d, condition_d)
				;
//		String sql = ran.selectConnect(request.getParameter("out_a").toString(),
//				request.getParameter("out_b").toString(), request.getParameter("out_c").toString(),
//				request.getParameter("out_d").toString(), request.getParameter("a").toString(),
//				request.getParameter("condition_a").toString(),
//				request.getParameter("b").toString(),
//				request.getParameter("condition_b").toString(),
//				request.getParameter("c").toString(),
//				request.getParameter("condition_c").toString(), 
//				request.getParameter("d").toString(), 
//				request.getParameter("condition_d").toString());
		System.out.println(Random.selectConnect(  "orderSum", 
				"productName",  "customerName", "employeeName",
				"orderNo","’≈ ", "productNo",  "Õı", "employeeNo" ,"º÷","customerNo", "ª∆" ));
		System.out.println(sql);
		
		request.setAttribute("sql", sql);
		
		ResultSet ret = connect.update(sql);
		
		request.setAttribute("out_a", request.getParameter("out_a"));
		request.setAttribute("out_b", request.getParameter("out_b"));
		request.setAttribute("out_c", request.getParameter("out_c"));
		request.setAttribute("out_d", request.getParameter("out_d"));
		request.setAttribute("a", request.getParameter("a"));
		request.setAttribute("b", request.getParameter("b"));
		request.setAttribute("c", request.getParameter("c"));
		request.setAttribute("d", request.getParameter("d"));
		request.setAttribute("condition_a", request.getParameter("condition_a"));
		request.setAttribute("condition_b", request.getParameter("condition_b"));
		request.setAttribute("condition_c", request.getParameter("condition_c"));
		request.setAttribute("condition_d", request.getParameter("condition_d"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("random.jsp");
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

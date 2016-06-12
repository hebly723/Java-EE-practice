package servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import order.*;
public class Product_select extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Product_select() {
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
		product pro = new product();
		pro.setProductNo(request.getParameter("productNo"));;
		pro.setProductName(request.getParameter("productName"));
		pro.setProductClass(request.getParameter("productClass"));
		pro.setProductPrice(request.getParameter("productPrice"));
		pro.setInStock(request.getParameter("inStock"));
		request.setAttribute("sql", pro.selectSql());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
		requestDispatcher.forward(request, response);
/*		System.out.println(pro.getProductName());
		System.out.println(pro.getProductClass());
		System.out.println(pro.getInStock());
		System.out.println(pro.getProductNo());
		System.out.println(pro.getProductPrice());
		ResultSet reter = pro.select();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		List list_ProductName = null;
		List list_ProductClass = null;
		List list_InStock = null;
		List list_ProductNo = null;
		List list_ProductPrice= null;
		ResultSet ret = pro.select(pro.sql());
		request.setAttribute("fd", "sad");
		try {
			int i = 0;
			while (ret.next())
			{
				list_ProductName.add(ret.getString("productName"), i);
				list_InStock.add(ret.getString("inStock"), i);
				list_ProductClass.add(ret.getString("productClass"), i);
				list_ProductNo.add(ret.getString("productNo"), i);
				list_ProductPrice.add(ret.getString("productPrice"), i);
				System.out.print(ret.getString("productNo")+"\t");
				System.out.print(ret.getString("productName")+"\t");
				System.out.print(ret.getString("productClass")+"\t");
				System.out.print(ret.getString("productPrice")+"\t");
				System.out.println(ret.getString("inStock"));
				ret[0] = ret.getString("productNo");
				
				i++;
			}
		} catch (SQLException e) {
			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list_ProductName);
		
		out.flush();
		out.close();
*/
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
		product pro = new product();
		pro.setProductNo(request.getParameter("productNo"));;
		pro.setProductName(request.getParameter("productName"));
		pro.setProductClass(request.getParameter("productClass"));
		pro.setProductPrice(request.getParameter("productPrice"));
		pro.setInStock(request.getParameter("inStock"));
/*//		System.out.println(pro.getProductName());
		System.out.println(pro.getProductClass());
		System.out.println(pro.getInStock());
		System.out.println(pro.getProductNo());
		System.out.println(pro.getProductPrice());
		ResultSet reter = pro.select();
*/		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		request.setAttribute("sql", pro.selectSql());
    /** 
     *  List list_ProductName = null;
     *  List list_ProductClass = null;
     *	List list_InStock = null;
     *	List list_ProductNo = null;
     *	List list_ProductPrice= null;
     * 
     */
		//ResultSet ret = pro.select(pro.selectSql());
		//request.setAttribute("fd", "sad");
//		try {
//			int i = 0;
//			while (ret.next())
//			{
////				list_ProductName.add(ret.getString("productName"), i);
////				list_InStock.add(ret.getString("inStock"), i);
////				list_ProductClass.add(ret.getString("productClass"), i);
////				list_ProductNo.add(ret.getString("productNo"), i);
////				list_ProductPrice.add(ret.getString("productPrice"), i);
//				System.out.print(ret.getString("productNo")+"\t");
//				System.out.print(ret.getString("productName")+"\t");
//				System.out.print(ret.getString("productClass")+"\t");
//				System.out.print(ret.getString("productPrice")+"\t");
//				System.out.println(ret.getString("inStock"));
//				//ret[0] = ret.getString("productNo");
//				//
//				i++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//request.setAttribute("list", list_ProductName);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
		requestDispatcher.forward(request, response);
		out.flush();
		out.close();
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

package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emxcel.InventoryProduct.model.Product;
import com.emxcel.web.dao.ProductDAO;


/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session != null) {
			Product product = new Product();
			product.setProduct_name(request.getParameter("name"));
			product.setProduct_qty(Integer.parseInt(request.getParameter("quantity")));
			product.setProduct_price(new BigDecimal(request.getParameter("price")));
			ProductDAO productDao = new ProductDAO();
			if (productDao.create(product)) {
				response.sendRedirect("addProductSuccess.jsp");
			} else {
				response.sendRedirect("addProductError.jsp");
			}
		} else {
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("Please login first");

		}
	}

}
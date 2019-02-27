package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emxcel.InventoryProduct.model.Product;
import com.emxcel.web.dao.ProductDAO;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/searchproduct")
public class SearchProduct extends HttpServlet {
	/**
	 * @author Priyanka Dodiya
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();

		if (session != null) {
			if (!request.getParameter("searchid").isBlank()) {
				try {
					Long id = Long.parseLong(request.getParameter("searchid"));
					ProductDAO productDao = new ProductDAO();
					Product productDetail = productDao.getProduct(id);
					session.setAttribute("productDetail", productDetail);
					request.getRequestDispatcher("searchProduct.jsp").include(request, response);
				} catch (NumberFormatException e) {
					out.print("Enter proper Product Id to search any product.");
				}
			}

		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			out.print("Please login first");

		}

	}
}

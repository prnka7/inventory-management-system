package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emxcel.web.dao.ProductDAO;
@WebServlet("/product")
public class ProductController extends HttpServlet {

	/**
	 * @author Priyanka Dodiya
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session != null) {
				ProductDAO productDao = new ProductDAO();
				int total = 5;
				String spageid = request.getParameter("page");
				int start = Integer.parseInt(spageid);
				if (start == 1) {
				} else {
					start = start - 1;
					start = start * total + 1;
				}
			session.setAttribute("productList", productDao.getAllProducts(start, total));
			request.getRequestDispatcher("product.jsp").include(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("Please login first");

		}
	}

}

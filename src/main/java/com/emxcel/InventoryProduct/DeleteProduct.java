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

/**
 * @author Priyanka Dodiya
 */
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session != null) {
			ProductDAO productDao = new ProductDAO();
			productDao.delete(Long.parseLong(request.getParameter("id")));
			response.sendRedirect("product.jsp?page=1");
		} else {
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("Please login first");

		}

	}

}

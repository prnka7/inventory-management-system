package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emxcel.InventoryProduct.model.User;
import com.emxcel.web.dao.UserDAO;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			UserDAO userDao = new UserDAO();
			List<User> user = userDao.getAllUsers();
			session.setAttribute("user", user);
			request.getRequestDispatcher("userlist.jsp").include(request, response);

		} else {
			response.getWriter().print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}
   }

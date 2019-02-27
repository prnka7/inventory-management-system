package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emxcel.InventoryProduct.model.User;
import com.emxcel.web.dao.UserDAO;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserDAO userDao = new UserDAO();
		request.getRequestDispatcher("App.jsp").include(request, response);
		System.out.println("hello");
		try {
			String userName = request.getParameter("name");// from JSP
			String password = request.getParameter("password");// from JSP
			User user=userDao.getUserFromUserName(userName);
			
			if (userDao.checkUserPassword(user, password)) {
				// get the old session and invalidate
				HttpSession oldSession = request.getSession(false);
				if (oldSession != null) {
					oldSession.invalidate();
				}

				HttpSession newSession = request.getSession(true);
				// session.setMaxInactiveInterval(10*60);
				newSession.setAttribute("loggeduser", user);
				// newSession.setAttribute("name", userName);
				request.getRequestDispatcher("dashboard.jsp").include(request, response);

			} else {
				out.println("Username or Password Not Valid");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		} catch (NoResultException e) {
			out.print("User not registered! Contact admin!");
			request.getRequestDispatcher("login.jsp").include(request, response);

		}
		out.close();

	}
}
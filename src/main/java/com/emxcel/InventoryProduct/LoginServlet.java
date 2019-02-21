package com.emxcel.InventoryProduct;

import com.emxcel.InventoryProduct.model.*;
import java.io.IOException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Priyanka Dodiya
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InventoryManagement");
		EntityManager em = emf.createEntityManager();
		String select = "select ua FROM User ua WHERE ua.user_name=:username";
		User u1 = (User) em.createQuery(select).setParameter("username", username).getSingleResult();
		boolean matched = BCrypt.checkpw(password, u1.getUser_password());
		List<Role> rolelist = u1.getLikedrole_user();
		if (matched) {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}

			HttpSession session = request.getSession(true);
			session.setAttribute("rolelist", rolelist);
			session.setAttribute("uname", username);
			session.setAttribute("pwd", password);
			request.getRequestDispatcher("final.jsp").include(request, response);
			
			System.out.println("Login Success!");
		} else {
			System.out.println("User does not exist!");
		}
		em.close();
		
	}

}

package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emxcel.InventoryProduct.model.Role;

/**
 * Servlet implementation class GetRoleList
 */
@WebServlet("/listrole")
public class GetRoleList extends HttpServlet {
	/**
	 * @author Priyanka Dodiya
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		//  PrintWriter pwriter = response.getWriter();
		  String myName=(String)session.getAttribute("uname");
		  List<Role> roles=(List<Role>) session.getAttribute("rolelist");
	     // pwriter.print("Name: "+myName);
	      
	   //   pwriter.close();
	      session.setAttribute("rolelist", roles);
	      request.getRequestDispatcher("rolelist.jsp").include(request,response);;
		
		
	}

	

}

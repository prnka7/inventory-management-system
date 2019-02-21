package com.emxcel.InventoryProduct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emxcel.web.dao.ProductDAO;

/**
 * @author Priyanka Dodiya
 */
@WebServlet("/removeproduct")
public class RemoveProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Remove Servlet");
	long id=Long.parseLong(request.getParameter("getid"));
	ProductDAO dao=new ProductDAO();
	dao.delete(id);
	RequestDispatcher rd=request.getRequestDispatcher("/DeleteProduct.jsp");  
    rd.include(request, response);  
	
	
	}

	
}

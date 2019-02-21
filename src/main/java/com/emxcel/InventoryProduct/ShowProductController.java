package com.emxcel.InventoryProduct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.emxcel.InventoryProduct.model.Product;
import com.emxcel.web.dao.ProductDAO;

/**
 * @author Priyanka Dodiya
 */
@WebServlet("/ShowProductController")
public class ShowProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao=new ProductDAO();
		
		List<Product> listp=dao.show();
		
		for(Product p1:listp)
		{
			System.out.println(p1);
		}
		request.setAttribute("listp", listp);
		request.getRequestDispatcher("Event.jsp").include(request, response);

		System.out.println("You are in show product controller");
		
	}

}

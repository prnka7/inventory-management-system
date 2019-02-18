package com.emxcel.InventoryProduct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emxcel.InventoryProduct.model.Product;
import com.emxcel.web.dao.ProductDAO;
@WebServlet("/getProduct")
public class GetProductController extends HttpServlet {

	/**
	 * @author Priyanka Dodiya
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO p2 = new ProductDAO();
	//	Product p1 = p2.getProduct(id);
		//request.setAttribute("product",p1);
		RequestDispatcher rd=request.getRequestDispatcher("showProduct.jsp");
		rd.forward(request, response);
	}

}

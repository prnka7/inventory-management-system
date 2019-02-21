package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emxcel.InventoryProduct.model.Product;
import com.emxcel.web.dao.ProductDAO;

/**
* @author Priyanka Dodiya
*/
@WebServlet("/updateproduct")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Update Product");
			ProductDAO dao=new ProductDAO();
			Product p=new Product();
			
			
			
			dao.update(p);
	}

}

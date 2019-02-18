package com.emxcel.InventoryProduct;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.emxcel.InventoryProduct.model.Product;
import com.emxcel.web.dao.ProductDAO;

/**
 * Servlet implementation class AddProductController
 * 
 */
@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {
	
	
	/**
	 * @author Lenovo Priyanka Dodiya
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_name=request.getParameter("getname");
		BigDecimal product_price=new BigDecimal(request.getParameter("getprice"));
		int product_quantity=Integer.parseInt(request.getParameter("getquantity"));
		Product p=new Product();
		p.setProduct_name(product_name);
		p.setProduct_price(product_price);
		p.setProduct_qty(product_quantity);
		
		ProductDAO dao=new ProductDAO();
		dao.save(p);
		/*request.setAttribute("product", p);
		request.getRequestDispatcher("final.jsp").forward(request, response);*/
		RequestDispatcher rd=request.getRequestDispatcher("/AddProduct.jsp");  
        rd.include(request, response);  
		
		  
		

			
				
	}

	

}

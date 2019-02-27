package com.emxcel.InventoryProduct.model;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
@NamedQuery(name = "Product.searchByName", query = "SELECT p FROM Product p WHERE p.product_name=:productName")

public class Product implements Serializable {
	/**
	 * @author Priyanka Dodiya
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="product_id")
	private long product_id;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="product_qty")
	private int product_qty;
	
	@Column(name = "product_price")
	private BigDecimal productPrice;

	public Product(){
	}
		
	public long getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	public BigDecimal getProduct_price() {
		return this.productPrice;
	}
	public void setProduct_price(BigDecimal product_price) {
		this.productPrice = product_price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_qty=" + product_qty
				+ ", product_price=" + productPrice + "]";
	}

	
	

}

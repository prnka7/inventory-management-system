package com.emxcel.InventoryProduct.model;



import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long product_id;
	private String product_name;
	private int product_qty;
	private BigDecimal product_price;
	public long getProduct_id() {
		return product_id;
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
		return product_price;
	}
	public void setProduct_price(BigDecimal product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_qty=" + product_qty
				+ ", product_price=" + product_price + "]";
	}

	
	

}

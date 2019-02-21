package com.emxcel.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.emxcel.InventoryProduct.model.Product;

public class ProductDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("InventoryManagement");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

Product p=new Product();
	public void save(Product product) {

		transaction.begin();
		em.persist(product);
		transaction.commit();
		System.out.println("Added");
		em.close();
	}
	public void delete(long id)
	{
		transaction.begin();
		em.remove(em.find(Product.class,id));
		transaction.commit();
		System.out.println("Removed");
		em.close();
	}
	public List<Product> show() {
		@SuppressWarnings("unchecked")
		List<Product> listproduct = em.createQuery("SELECT p FROM Product p").getResultList();
		em.close();
			return listproduct;
	}
	public void update(Product product)
	{
		transaction.begin();
		em.merge(product);
		transaction.commit();
		System.out.println("Updated");
		em.close();
		
	}

}

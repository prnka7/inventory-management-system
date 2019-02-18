package com.emxcel.web.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.emxcel.InventoryProduct.model.Product;

public class ProductDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("InventoryManagement");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	public void save(Product product) {

		transaction.begin();
		em.persist(product);
		transaction.commit();
		System.out.println("Added");
		em.close();
	}
	public void delete(Product product)
	{
		transaction.begin();
		em.remove(product);
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

}

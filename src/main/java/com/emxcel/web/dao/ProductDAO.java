package com.emxcel.web.dao;
/**
 * 
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.emxcel.InventoryProduct.model.Product;

/**
 * @author Priyanka Dodiya
 *
 *
 */
public class ProductDAO {
	private final EntityManager entityManager;

	public ProductDAO() {
		entityManager = PersistenceManager.getInstance().getEntityManager();
	}

	public Product getProduct(Long id) {
		return entityManager.find(Product.class, id);
	}

	public int getProductCount() {
		Query query = entityManager.createNamedQuery("Product.findAll", Product.class);
		int totalproducts = query.getResultList().size();
		System.out.println(totalproducts);
		return totalproducts;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(int start, int total) {
		Query query = entityManager.createNamedQuery("Product.findAll", Product.class);
		query.setFirstResult(start - 1);
		query.setMaxResults(total);
		List<Product> results = query.getResultList();
		// return entityManager.createNamedQuery("Product.findAll",
		// Product.class).getResultList();
		return results;
	}


	public boolean create(Product product) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(product);
			entityManager.getTransaction().commit();
			return entityManager.contains(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}

	}

	public void update(Product product) {
		try {
			entityManager.getTransaction().begin();

			product = entityManager.merge(product);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}


	public void delete(long id) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(Product.class, id));
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public List<Product> getProductFromProductName(String productName) {
		return entityManager.createNamedQuery("Product.searchByName", Product.class)
				.setParameter("productName", productName).getResultList();
	}
}
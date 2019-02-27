
package com.emxcel.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.mindrot.jbcrypt.BCrypt;
import com.emxcel.InventoryProduct.model.User;

/**
 * 
 *@author Priyanka Dodiya
 *
 */
public class UserDAO {
	private final EntityManager entityManager;

	public UserDAO() {
		entityManager = PersistenceManager.getInstance().getEntityManager();
	}

	public List<User> getAllUsers() {
		return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
	}

	public boolean validPassword(String plaintext, String hashed) {
		return BCrypt.checkpw(plaintext, hashed);
	}

	public String hashpassword(String originalPassword) {
		return BCrypt.hashpw(originalPassword, BCrypt.gensalt(06));
	}

	public boolean checkUserPassword(User user, String plaintext) {
		String hashed = user.getUser_password();// from database
		boolean check = false;
		check = validPassword(plaintext, hashed);
		return check;
	}

	public void save(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}


	public User getUser(Long userId) {
		return entityManager.find(User.class, userId);
	}

	public User getUserFromUserName(String userName) {
		return entityManager.createNamedQuery("User.validPassword", User.class).setParameter("userName", userName)
				.getSingleResult();
	}

}
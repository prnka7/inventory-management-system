package com.emxcel.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class PersistenceManager {
	private static final String PERSISTENCE_UNIT = "InventoryManagement";

	private final EntityManagerFactory entityManagerFactory;

	public PersistenceManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	public static PersistenceManager getInstance() {
		return PersistenceManagerInstanceHolder.INSTANCE;
	}

	@PersistenceContext
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void close() {
		entityManagerFactory.close();
	}

	private static class PersistenceManagerInstanceHolder {
		private static final PersistenceManager INSTANCE = new PersistenceManager();
	}

}

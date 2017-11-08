package com.fuctura.modulo3.managedbean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("fucturaPU");
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}
}
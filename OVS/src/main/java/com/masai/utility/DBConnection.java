package com.masai.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DBConnection {
	public static EntityManager getEM() {
		return Persistence.createEntityManagerFactory("onlineVotingSystem").createEntityManager();
	}

}

package userjm2.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import userjm2.dto.User;

public class UpdateController {
	
	
	public static void main(String[] args) {
		
		User user=new User();
		user.setId(10);
		user.setName("pooji");
		user.setAddress("bangalore");
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}

}

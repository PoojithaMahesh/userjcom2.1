package userjm2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.border.EtchedBorder;

import userjm2.dto.User;

public class UserDao {

	public void saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
//	no need of ET
//	id is the very important attribute to select the data
	public void selectUser(int id) {
		EntityManagerFactory  entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user=entityManager.find(User.class,id);
		if(user!=null) {
//			id is present in the database
			System.out.println(user);
		}else {
//			id is not present in the database
			System.out.println("id is not present");
		}
	}
	
	public void deleteUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user=entityManager.find(User.class, id);
		if(user!=null) {
//			id is present that data or user is present in the database
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		}else {
//			id is not present
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
}






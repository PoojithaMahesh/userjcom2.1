package userjm2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.border.EtchedBorder;

import com.mysql.cj.Query;

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
	
	public void updateUser(int id,User user) {
//		id=10
//		user=1000 charan odissa
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, 10);
//		dbUser=10,Odissa,Charan
		if(dbUser!=null) {
//		id is present
//			merge update the data or insert the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
//			user=1000 charan odissa
			user.setId(id);
//			user=10 charan odissa
			entityManager.merge(user);
			entityTransaction.commit();	
		}else {
//		id is not present
//			i know that if we are using merge method here it will insert the data
//			inside this else block im not going to use merge method
			System.out.println("id is not present to update");
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public void findUserByName(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		javax.persistence.Query query=entityManager.createQuery("Select u from User u where u.name=?1");
		query.setParameter(1, name);
		User  user=(User) query.getSingleResult();
		System.out.println(user);
	}
	
	
	
	
	public  void findAllUser() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		javax.persistence.Query query=entityManager.createQuery("Select u from User u");
		List<User> users=query.getResultList();
	System.out.println(users);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}






package userjm2.controller;

import userjm2.dao.UserDao;
import userjm2.dto.User;

public class UserController {
public static void main(String[] args) {
//	User user=new  User();
//	user.setId(1);
//	user.setName("Poojitha");
//	user.setAddress("mysore");
//	
//	
//	
//	UserDao dao=new UserDao();
//	dao.saveUser(user);
	
//	selectUser
	UserDao dao=new UserDao();
//	dao.selectUser(100);
//	deleteUser
	dao.deleteUser(100);
	
}
}

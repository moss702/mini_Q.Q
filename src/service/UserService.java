package service;
import java.util.ArrayList;
import java.util.List;

import Domain.Admin;
import Domain.Customer;
import Domain.Menu;
import Domain.User;

public class UserService {

	private static final UserService USER_SERVICE = new UserService();
	private UserService() {	}
	public static UserService getInstance() {
		return USER_SERVICE;
	}
	
	List<User> users = new ArrayList<User>();
	{
		users.add(new Admin());
		users.add(new Customer());
	}
	// CRUD
	
	// 메뉴추가
	// 메뉴수정
	// 메뉴삭제
	
	// 메뉴조회
	
	// 
	List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		for(User user : users) {
			if(user instanceof Customer) {
				customers.add((Customer)user);
			}
		}
		return customers;
	}

	List<Admin> getAdmins() {
		List<Admin> admins = new ArrayList<>();
		for(User user : users) {
			if(user instanceof Admin) {
				admins.add((Admin)user);
			}
		}
		return admins;
	}
}

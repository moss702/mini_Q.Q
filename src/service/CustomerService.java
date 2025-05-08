package service;
import java.util.ArrayList;
import java.util.List;

import Domain.Customer;
import Domain.Menu;

public class CustomerService {

	private static final CustomerService CUSTOMER_SERVICE = new CustomerService();
	private CustomerService() {	}
	public static CustomerService getInstance() {
		return CUSTOMER_SERVICE;
	}
	
	List<Customer> customers;
	{
		customers = UserService.getInstance().getCustomers();
	}
	
	// 메뉴추가
	// 메뉴
	// 메뉴삭제
	
}

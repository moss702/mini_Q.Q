package SSS;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qq.UserAccount;
import qq.UserService;
import qq.Util;

public class Order {
	// 필드
//	Customer customer = new Customer();
	List<Cart> cart;
	Date date = new Date();
	public boolean pay; // 지불되기전 false, 지불 완료 true
	int sales;
	 
//	private static Order order = new Order();
//	public static Order getInstance() {
//		return order;
//	}
	public Order() {
	}
	
//	public Order(Customer customer, List<Cart> cart, int sales) {
//		this.customer = customer;
//		this.cart = cart;
//		this.sales = sales;
//	}
	
	//to String OverRide하기
}

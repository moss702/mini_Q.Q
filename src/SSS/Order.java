package SSS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qq.UserAccount;
import qq.UserService;
import qq.Util;

public class Order {
	// 필드
	SMenu snack = new SMenu(); //음식
	int qty; // 주문량
	int sale; // 누적금액
	 
	private static Order order = new Order();
	public static Order getInstance() {
		return order;
	}
	public Order() {
	}

	public Order(SMenu snack, int qty) {
		this.snack = snack;
		this.qty = qty;
	}
	
	public Order(SMenu snack, int qty, int sale) {
		this.snack = snack;
		this.qty = qty;
		this.sale = sale;
	}
	
}

package service;
import static utils.QqUtils.nextInt;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Menu;
import domain.User;

public class CustomerService  extends UserService{
	private static final CustomerService CUSTOMER_SERVICE = new CustomerService();
	public CustomerService () {
		
	}
	public static CustomerService getInstance() {
		return CUSTOMER_SERVICE;
	}
	
	List<Customer> customers;

	
	public  void init () {
		System.out.println("===============손님 로그인 상태"); 
		int input = nextInt("[1.메뉴보기 2. 장바구니 담기 3. 장바구니 빼기 4. 결제하기 5.내정보 6. 로그아웃]");	//메뉴보기 - 메뉴클래스 , 장바구니 담기, 장바구니 빼기, 결제하기 - order 클래스
		switch (input) {
			case 1 : 
				MenuService.getInstance().read();
				break;
			case 2: 
				OrderService.getInstance().getItem();
				break;
			case 3 : 
				OrderService.getInstance().deleteItem();
				break;
			case 4 :
				OrderService.getInstance().pay();
				break;
			case 5 :
				//UserService.getInstance().();  // 소비금액, 주문내역
				
				break;
			case 6 :
				UserService.getInstance().logout();
				break;
		}
	}
	
}

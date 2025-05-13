package service;
import static utils.QqUtils.nextInt;
import static utils.QqUtils.nextLine;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Menu;
import domain.Order;
import domain.User;

public class CustomerService {
	private static final CustomerService CUSTOMER_SERVICE = new CustomerService();
	private   CustomerService () {
		
	}
	public static CustomerService getInstance() {
		return CUSTOMER_SERVICE;
	}
	
	List<Customer> customers;
	private static Customer Customer;
	private char[] loginCustomer;

	
	public  void init () {
		System.out.println("===============손님 로그인 상태"); 
		int input = nextInt("[1.메뉴보기 2. 장바구니 담기 3. 장바구니 빼기 4. 결제하기 5.내정보 6. 로그아웃]");	
		//메뉴보기 - 메뉴클래스 , 장바구니 담기, 장바구니 빼기, 결제하기 - order 클래스
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
<<<<<<< HEAD
				CustomerService.Mypage();;
=======
				CustomerService.modify();
				
>>>>>>> branch 'master' of https://github.com/songseongjun/Q.Q.git
				break;
			case 6 :
				UserService.getInstance().logout();
				break;
		}
	}
<<<<<<< HEAD
	// 소비금액조회, 정보 수정
		static void  Mypage () {
		System.out.println("내정보보기");
		System.out.println("loginCustomer");
		System.out.println("소비금액 조회");
		//OrderService.getInstance().print(OrderService.getInstance().findByPayment(Customer ));
=======
	// 소비금액조회, 정보 수정, 수정후 저장
	public void Mypage() {
	    System.out.println("내 정보 보기");
	    System.out.println(Customer);  
	    List<Order> payment = OrderService.getInstance().findByPayment(Customer);
	  //  OrderService.getInstance().print(payment);
>>>>>>> branch 'master' of https://github.com/songseongjun/Q.Q.git
	}

		public static void modify() {
		    System.out.println("정보 수정");

		    String pw = nextLine("현재 비밀번호 > ");
		    Customer found = findBy(pw, null);

		    if (found == null) {
		        System.out.println("비밀번호가 일치하지 않습니다.");
		        return;
		    }

		    String newPw = nextLine("새 비밀번호 > ");
		    found.setPassword(newPw);
	}
		private static domain.Customer findBy(String pw, Object object) {
			// TODO Auto-generated method stub
			return null;
		}
	
	}
	
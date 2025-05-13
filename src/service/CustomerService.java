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
				CustomerService.modify();
				break;
			case 6 :
				UserService.getInstance().logout();
				break;
		}
	}
	// 소비금액조회, 정보 수정
		public static void  Mypage () {
			System.out.println("소비금액 조회");
			String ord = nextLine("소비금액 >");
		//	OrderService o = findBy(ord, null);
			
		}
	// 소비금액조회, 정보 수정, 수정 후 저장

		public static void modify() {
		    System.out.println("정보 수정");

		    String pw = nextLine("현재 비밀번호 > ");
		    Customer c = findBy(pw, null);

		    if (c == null) {
		        System.out.println("비밀번호가 일치하지 않습니다.");
		        return;
		    }

		    String newPw = nextLine("새 비밀번호 > ");
		    c.setPassword(newPw);
	}
		private static domain.Customer findBy(String pw, Object object) {
			// TODO Auto-generated method stub
			return null;
		}
		public void logout() {
		    loginCustomer = null;
		    System.out.println("=======[로그아웃 되었습니다]=======");
	}
		
}
	
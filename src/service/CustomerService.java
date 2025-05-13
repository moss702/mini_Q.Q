package service;
import static utils.QqUtils.nextConfirm;
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
	
	List<Customer> customers = new ArrayList<Customer>();
	private Object login;
//	private Customer loginCustomer = (Customer)(UserService.getInstance().getLoginUser()); 

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
				Mypage();
				break;
			case 6 :
				UserService.getInstance().logout();
				break;
		}
	}
	// 소비금액조회, 정보 수정
		public void  Mypage () {
			int input = nextInt("[1.소비금액 조회 2. 정보수정 3. 정보삭제 4. 뒤로가기]");	
			//메뉴보기 - 메뉴클래스 , 장바구니 담기, 장바구니 빼기, 결제하기 - order 클래스
			switch (input) {
				case 1 : 
					OrderService.getInstance().findByPayment(null);
					break;
				case 2: 
					modify();
					break;
				case 3 : 
					UserService.getInstance().remove();
					break;
				case 4 : 
					return;
		}
			}
		public void modify() { // 비밀번호 입력, 정보 조회,   현재 비밀번호 일치하지 않음, 새로운 비밀번호 입력 , 탈퇴하기
				System.out.println("비밀번호 입력");
				
				String pw = nextLine("비밀번호 입력");
				
				System.out.println("내정보 보기");
				
				System.out.println("loginCustomer");
			
					   
			    System.out.println("비밀번호가 일치하지 않습니다.");
			  if (pw == null) {
			  } else {
			    String newPw = nextLine("새 비밀번호 입력 하시오");
			    return;
			    }
			  }
		public void remove() {
			System.out.println("탈퇴");
			if(!nextConfirm("[정말 탈퇴하시겠습니까?]")) {
				UserService.getInstance().users.remove(login);
				System.out.println("[정상적으로 탈퇴 되었습니다.]");			
				remove();
				return;
			} else {
				System.out.println("[탈퇴 취소되었습니다.]");
				return;
			
		}			
			}
				}		    


	
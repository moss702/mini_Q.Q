package main;

import static utils.QqUtils.nextInt;


import domain.Admin;
import service.AdminService;
import service.CustomerService;
import service.MenuService;
import service.OrderService;
import service.UserService;

public class Main {
	public static void main(String[] args) {
		while(true) {
			try {	
				if(UserService.getInstance().getLoginUser() == null) { //null :비로그인 상태, 그외 : 로그인 상태
					int input = nextInt("[1.회원가입] [2.로그인]");
					switch (input) {
						case 1 : 
							UserService.getInstance().register();
							break;
						
						case 2 : 
							UserService.getInstance().login();
							break;
					}
				} else if(UserService.getInstance().getLoginUser().getClass() == Admin.class){
					System.out.println("===============관리자 로그인 상태");
					int input = nextInt("[1.회원목록 조회] [2.관리자 등급 관리] [3.회원정보삭제] [4.메뉴관리] [5.매출조회] [0.로그아웃]");	
					switch (input) {
						case 1 : 
							AdminService.getInstance().read();
							break;
						case 2 : 
							AdminService.getInstance().isSeller();
							break;
						case 3 : 
							AdminService.getInstance().userRemove();
							break;
						case 4 : 
							  while (true) {
					                int menuInput = nextInt("\n[1.메뉴등록] [2.메뉴조회] [3.메뉴수정] [4.메뉴삭제] [0.뒤로가기]");
					                switch (menuInput) {
					                    case 1: MenuService.getInstance().register(); 
					                    break;
					                    case 2: MenuService.getInstance().rank(); 
					                    break;
					                    case 3: MenuService.getInstance().modify();
					                    break;
					                    case 4: MenuService.getInstance().remove();
					                    break;
					                }
					                if (menuInput == 0) break;
					            }
					            break;
						
						case 5 : 
							System.out.println("* 임시 * 매출관리"); 
						//	OrderService.getInstance().findBySalesDate();
							break;
						case 0 :
							UserService.getInstance().logout();
							break;
					}
				} else {
					System.out.println("===============손님 로그인 상태"); 
					int input = nextInt("[0.로그아웃] [1.메뉴판]");	
					switch (input) {
						case 0 : 
							UserService.getInstance().logout();
							break;
						case 1:
							 while (true) {
					                int menuInput = nextInt("\n[1.선택한메뉴 가격 합계] [2.가격 범위로 메뉴 검색] ");
					                switch (menuInput) {
					                    case 1: MenuService.getInstance().PriceRange(); 
					                    break;
					                    case 2: MenuService.getInstance().totalMenuPrice();
					                }
					                if (menuInput == 0) break;
					            }
					            break;
					}
				}
			}
				catch (NumberFormatException e) {
				System.out.println("정확한 숫자를 입력하세요");
			}	catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		} //while(true) 닫기
	}
}

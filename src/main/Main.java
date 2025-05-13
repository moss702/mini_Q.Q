package main;

import static utils.QqUtils.nextInt;

import domain.Admin;
import service.AdminService;
import service.CustomerService;
import service.MenuService;
import service.OrderService;
import service.UserService;

public class Main {

	public static void main(String[] args) throws Exception {
		while(true) {
			try {	
				if(UserService.getInstance().getLoginUser() == null) { // 비로그인 상태
					System.out.println("===============비로그인 상태");
					int input = nextInt("[1.회원가입] [2.로그인]");
					switch (input) {
						case 1 : 
							UserService.getInstance().register();
							break;
						case 2 : 
							UserService.getInstance().login();
							break;
					}
				} else if(UserService.getInstance().getLoginUser() instanceof Admin){
					AdminService.getInstance().adminInit(); // Login Admin
				} else { 
					CustomerService.getInstance().init(); // Login Customer
				}
			}	catch (NumberFormatException e) {
				System.out.println("정확한 숫자를 입력하세요");
			}	catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} //while(true) 닫기
	}
}
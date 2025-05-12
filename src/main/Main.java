package main;

import static utils.QqUtils.nextInt;


import domain.Admin;
import service.CustomerService;
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
				} else if(UserService.getInstance().getLoginUser().getClass() == Admin.class){ //관리자 서비스에서 만든 메뉴 호출
					System.out.println("===============관리자 로그인 상태");
					int input = nextInt("[1.회원목록 조회] [2.관리자 등급 관리] [3.회원삭제] [4.메뉴관리] [0.로그아웃]");	
					switch (input) {
						case 1 : 
							System.out.println("* 임시 * 회원목록조회");
				//			UserService.getInstance().printAdmin(users);
							break;
						case 2 : 
							System.out.println("* 임시 * 관리자등급관리");
							break;
						case 3 : 
							System.out.println("* 임시 * 회원삭제");
							break;
						case 4 : 
							System.out.println("* 임시 * 메뉴관리"); 
							break;
						case 0 :
							UserService.getInstance().logout();
							break;
					}
				} else { //커스토머 서비스에서 만든 메뉴 호출
					System.out.println("===============손님 로그인 상태"); 
					CustomerService.getInstance().init();
				}
			}	catch (NumberFormatException e) {
				System.out.println("정확한 숫자를 입력하세요");
			}	catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		} //while(true) 닫기
	}
}

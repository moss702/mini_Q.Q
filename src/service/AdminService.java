package service;

import static utils.QqUtils.nextInt;

public class AdminService {

	
	public void init() {
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
		
	}
	
}

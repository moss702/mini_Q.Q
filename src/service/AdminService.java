package service;

import static utils.QqUtils.nextInt;

import java.util.List;

import domain.Customer;
import domain.User;
import service.UserService;
import static utils.QqUtils.*;

public class AdminService {
	// 싱글톤
	private static final AdminService ADMIN_SERVICE = new AdminService();
	public AdminService() {}
	public static AdminService getInstance() {
		return ADMIN_SERVICE;
	}

	public void adminInit() {
		System.out.println("===============관리자 로그인 상태");
		int input = nextInt("[1.회원목록 조회] [2.관리자 등급 관리] [3.회원삭제] [4.메뉴관리] [0.로그아웃]");	
		switch (input) {
			case 1 : 
				UserService.getInstance().printUser();
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
	
	//-----------------관리자 권한 부여
	//User customer에 있던 정보를 User Admin으로 이동시키기
	public void isSeller() {
		String id = nextLine("[관리자 권한을 부여할 ID를 입력하세요] > ");
//		if(id == findBy(id,)) { //유저 리스트에 없다면
//			System.out.println("[존재하지 않는 계정입니다.]");
//		}  // 유저 리스트에 있고, Customer에 들어있다면.
//		else if(findByID(id) == UserService.getInstance().getUsers()) {
//			
//		}
	}
	
	
} //============================ AdminService 닫기
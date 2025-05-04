package qq;

import qq.Util.*;
import qq.UserAccount.*;

public class Main {
//	private static Main main = new Main();
//	private Main() {}
//	public static Main getInstance() {
//		return main;
//	}
	public static void main(String[] args) {
		UserService userServiece = UserService.getInstance();
		UserAccount ua = userServiece.getLoginUser();
		if(ua == null) { // 
			int no = Util.nextInt("1. 회원가입 2. 로그인");
			switch(no) {
			case 1:
				userServiece.register(); break;
			case 2:
				userServiece.login(); break;
			}
		}
		else {			
			if ( ua.isSeller == false ){
				System.out.println("로그인 상태");
				int no = Util.nextInt("1.내정보수정 2. 주문 3. 내정보확인  ");
				switch(no) {
				// 로그인 한 후 나와야하는거
				// 첫번째 페이지에서 다른 두개의 페이지로 갈수 있게
//			
				case 1: userServiece.modify(); break;
				case 2: userServiece.myPage(); break;
				case 3: userServiece.read(); break;
				}
			} else {
				System.out.println("로그인 상태");
				int yes = Util.nextInt("1.사업자 2.손님");
			}
			
		}
	}	
}
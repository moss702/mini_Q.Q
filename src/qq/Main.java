package qq;

import qq.Util.*;

public class Main {
	private static Main main = new Main();
	private Main() {}
	public static Main getInstance() {
		return main;
	}
	
	public void run() {
		UserService userServiece = UserService.getInstance();
		if(userServiece.getInstance() == null) { // 
			int no = Util.nextInt("1. 회원가입 2. 로그인");
			switch(no) {
				case 1:
					userServiece.register(); break;
				case 2:
					userServiece.login(); break;
			}
		}
		else if (false){
			System.out.println("로그인 상태");
			
			
		}
	}
}
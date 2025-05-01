package qq;

//userServiece : 회원가입, 로그인, 조회

import java.util.ArrayList;
import java.util.List;

public class UserServiece {
//=============================필드======================
	private List<UserAcount> acounts = new ArrayList<UserAcount>();
	
	{ //임시 데이터
		acounts.add(new UserAcount(1, "더미사장", "Admin", "1234", true));
		acounts.add(new UserAcount(2, "더미손님", "dummy", "1234", false));
	}
	
//	public static void main(String[] args) {
//		System.out.println(acounts.toString);
//	}
	
//=============================메소드======================

	//-----------------입력제한_이름
	public String inputName() {
		String name =  Util.nextLine("[이름 입력] > ");		
		if(!name.matches("[가-힣]{1,8}")) {			
			throw new IllegalArgumentException("[이름은 한글 1~8글자로 입력하세요]");
		}
		return name;
	}
	//-----------------입력제한_ID
	public String inputId() {
		String id =  Util.nextLine("[ID 입력] > ");		
		if(!id.matches("[A-Za-z0-9_+&*-]{+}")) {			
			throw new IllegalArgumentException("[ID는 알파벳,숫자 구성으로 입력하세요]");
		}
		return id;
	}
	//-----------------서치_ID (등업, 필터(중복ID))
//		public UserAcount findBy(String id) {
//		UserAcount acounts = null;
//		for (int i = 0; i < acounts.size(); i++) {			//QQQ 이거 왜 리스트 size가 안잡힐까요..?
//			if (acounts.get(i).getId() == id) {				//초기화 블럭 안에 add 했는데
//				acounts = acounts.get(i);
//				break;
//			}
//		}	
//		return acounts;
//	}
	
//===============================도메인 메소드=====================
	public void register() {
		System.out.println("[회원가입]");
		//회원번호는 자동증가 및 기록
			
			String id;
		
			id = Util.nextLine("[활동할 ID를 입력해주세요] >");	
			
//			UserAcount s = findBy(id);
//			if(s != null) {
//				System.out.println("[중복된 아이디입니다.");
//				return;
//			}
	}
	
	
	//* 로그인 성공시 "[" + name + "님 환영합니다! ]" 같은거 띄우기
}

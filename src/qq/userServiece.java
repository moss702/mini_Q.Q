package qq;

//userServiece : 회원가입, 로그인

import java.util.ArrayList;
import java.util.List;

public class userServiece {
	
//=============================필드======================
	private List<userAcount> acounts = new ArrayList<userAcount>();
	
	{ //임시 데이터
		acounts.add(new userAcount(1, "더미사장", "Admin", "1234", true));
		acounts.add(new userAcount(2, "더미손님", "dummy", "1234", false));
	}
	
//=============================메소드======================
/*	
 * 아직 util 없어서 작동 안됩니다.
	//-----------------입력제한_이름
	public String inputName() {
		String name =  BankUtils.nextLine("이름 입력 > ");		
		if(!name.matches("[가-힣]{2,4}")) {			
			throw new IllegalArgumentException("이름은 한글 2~4글자로 입력하세요");
		}
		return name;
	}
	//-----------------입력제한_ID
	public String inputId() {
		String id =  BankUtils.nextLine("ID 입력 > ");		
		if(!id.matches("[A-Za-z0-9_+&*-]{+}")) {			
			throw new IllegalArgumentException("id는 알파벳,숫자 구성으로 입력하세요");
		}
		return id;
	}
	//-----------------서치_ID(등업용)
		public userAcount findBy(String id) {
		userAcount acounts = null;
		for (int i = 0; i < acounts.size(); i++) {
			if (acounts.get(i).getId() == id) {
				acounts = acounts.get(i);
				break;
			}
		}	
		return acounts;
	}
	
*/
	
}

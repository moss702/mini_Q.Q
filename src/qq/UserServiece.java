package qq;

//userServiece : 회원가입, 로그인, 조회

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserServiece {
//=============================필드======================
	private List<UserAcount> acounts = new ArrayList<>();
	private List<UserAcount> sortedAcounts; // 소비금액순, 회원번호순 정렬 변경을 위한 리스트입니다.
	
	{ //임시 데이터
		acounts.add(new UserAcount(1, "더미사장", "Admin", "1234", true));
		acounts.add(new UserAcount(2, "더미손님", "dummy", "1234", false));
		
		sortedAcounts = new ArrayList<>(acounts);
		
	}
	
//=============================메소드======================

	//-----------------입력제한_이름
	public String inputName() {
		String name =  Util.nextLine("[이름을 입력해주세요] > ");		
		if(!name.matches("[가-힣]{1,4}")) {			
			throw new IllegalArgumentException("[(!)이름은 한글 1~4글자로 입력하세요]");
		}
		return name;
	}
	//-----------------입력제한_ID
	public String inputId() {
		String id = Util.nextLine("[ID를 입력해주세요] > ");	
		if(!id.matches("[A-Za-z0-9_+&*-]{+}")) {			
			throw new IllegalArgumentException("[(!)ID는 알파벳, 숫자 조합으로 입력하세요]");
		}
		return id;
	}
	//-----------------중복체크_ID                                   //Q. 근데 이거 메서드 안에 메서드 써도 되나요? 실행 테스트를 못해봄
	public String duplId() {
		String id = this.inputId();
		UserAcount s = findBy(id);
		if(s != null) {
			throw new IllegalArgumentException("[(!)이미 존재하는 ID 입니다]");
		}
		return id;
	}
	//-----------------서치_ID
	public UserAcount findBy(String id) {
	UserAcount acount = null;
	for (int i = 0; i < acounts.size(); i++) {
		if (acounts.get(i).getId() == id) {
			acount = acounts.get(i);
			break;
		}
	}	
	return acount;
	}
	//-----------------출력_회원목록
	public void print(List<UserAcount> UA) {
		UA.forEach(System.out::println);
		UA.forEach(s -> System.out.println(s));
	}
		
//===============================도메인 메소드=====================
	//-----------------회원가입(Customer, Seller)
	public void register() {
		System.out.println("-----[회원가입]-----");
		//----ID
		String id = null;
		inputId();
		duplId();

		//----PW
		String pw = Util.nextLine("[비밀번호를 입력해주세요] > ");
		
		//----이름
		String name = inputName();
		
		//----회원번호(자동증가)
		int no = acounts.get(acounts.size() + 1).getNo();
		
		//----회원리스트에 저장
		///(최초가입 사업자여부 default==손님. 이후 관리자 메뉴에서 변경가능)
		UserAcount UA = new UserAcount(no, name , id, pw, false);
		acounts.add(UA);
	}
	//-----------------로그인(Customer, Seller)
	public void login() { //은행예제>커스토머서비스 참고하기
		System.out.println("(임시)로그인 메서드 호출.(임시)");
//		로그인 성공시 System.out.println("[" + acounts.get(0).getName() + "님 환영합니다! ]");
	}
	
	//-----------------회원목록 조회(only Seller)
	public void read() { //회원번호순 조회
		System.out.println("-----[회원조회]-----");
		print(acounts);
	}
		
//	!!!!!!!! 누적소비금액 계산하는 메서드 선작성 필요!!!!!!!!!
//	public void allSpend() { //누적소비금액 높은 순 조회
//		System.out.println("-----[회원조회]-----"); 
		///안내 문구가 달라야할것같은데 어떤 말이 좋을까. 나중에 고민.
//		Collections.sort(sortedAcounts, (o1, o2) -> o2.allSpend() - o1.allSpend());
//	}  
		///학생예제에서는 조회,석차순조회 별도 메뉴탭이었지만...
		/// [1. 뒤로가기] [2. 번호순(소비순)] 번갈아가며 보여주면 UX면에서 보기 좋겠다.
	
	//-----------------회원 사업자 여부 변경(only Seller)
//	public void is {  
	///메서드명 뭘로하지...... 생각안남.. 일단 자야겠음.......
	
	
}

package qq;

//userServiece : 회원가입, 로그인, 로그아웃, 내정보수정
//Customer 내정보조회
//Seller 회원정보조회, 사업자 여부 변경

import java.util.ArrayList;
import java.util.List;
import static qq.Util.*;

public class UserService {
//=============================필드======================
	private List<UserAccount> accounts = new ArrayList<>();
	private List<UserAccount> sortedAccounts; // 소비금액순, 회원번호순 정렬 변경을 위한 리스트입니다.
	
	public List<UserAccount> getAccounts() { //일단 다른 클래스에서 접근할 수 있게 만들어뒀는데
	    return accounts;					 //Customer 접근할 메서드도 따로 만들었기 때문에, 불필요시 삭제!
	}
	
	private static UserService userService = new UserService();
	
	private UserService() {}
	public static UserService getInstance() {
		return userService;
	}

	private UserAccount loginUser; //로그인 상태 저장
	public UserAccount getLoginUser() {
		return loginUser;
	}
	
	
	
	{ //임시 데이터 ***** 추가필요!! 회원가입한 Accounts의 데이터파일 생성 및 저장
		accounts.add(new UserAccount(1, "더미사장", "admin", "1234", true));
		accounts.add(new UserAccount(2, "더미고객", "dummy", "1234", false));
		accounts.add(new UserAccount(3, "고양이", "cat", "1234", false));
		
		sortedAccounts = new ArrayList<>(accounts);
	}
	
//=============================메소드======================

	//-----------------입력제한_이름
	public String inputName() {
		String name =  nextLine("[이름을 입력해주세요] > ");		
		if(!name.matches("[가-힣]{1,4}")) {			
			throw new IllegalArgumentException("[(!)이름은 한글 1~4글자로 입력하세요]");
		}
		return name;
	}
	//-----------------입력제한_ID
	public String inputId() {
		String id = nextLine("[ID를 입력해주세요] > ");	
		if(!id.matches("[A-Za-z0-9_+&*-]{+}")) {			
			throw new IllegalArgumentException("[(!)ID는 알파벳, 숫자 조합으로 입력하세요]");
		}
		return id;
	}
	//-----------------중복체크_ID                                   //Q. 근데 이거 메서드 안에 메서드 써도 되나요? 실행 테스트를 못해봄
	public String duplId() {
		String id = this.inputId();
		UserAccount s = findByID(id);
		if(s != null) {
			throw new IllegalArgumentException("[(!)이미 존재하는 ID 입니다]");
		}
		return id;
	}
	//-----------------서치_ID
	public UserAccount findByID(String id) {
	UserAccount account = null;
	for (int i = 0; i < accounts.size(); i++) {
		if (accounts.get(i).getId().equals(id)) {
			account = accounts.get(i);
			break;
		}
	}	
	return account;
	}
	
	//-----------------서치_ID (Customer) : (타 클래스에서 Customer 클래스의 누적소비금액 필드 접근을 위한 메서드)
//	public Customer findByCustomer(String id) {
//	    for (UserAccount ua : accounts) {
//	        if (ua instanceof Customer && ua.getId().equals(id)) {
//	            return (Customer) ua;
//	        }
//	    }
//	    return null;
//	}

//	타 클래스 호출 예
//	Customer c = UserService.getInstance().findByCusto(id); //이름들이 길어서 좀 길긴한데.. 이름을 더 짧게 수정해야 할까요?
//	int total = c.getTotalSpend(); //Customer 클래스의 누적소비금액 필드 접근.
// 	Customer 클래스에서 private 누적소비금액 필드 및 게터/세터 만들어주세요! * 소비금액 변수명 협의 및 확정 필요
		
	//-----------------출력_회원목록
	public void print(List<UserAccount> UA) {
		UA.forEach(System.out::println);
		UA.forEach(s -> System.out.println(s));
	}
//===============================Customer, Seller 공통=====================
	//-----------------회원가입(Customer, Seller)
	public void register() {
		System.out.println("=======[회원가입 정보 입력]=======");
		//----ID
		String id = null;
		inputId();
		duplId();

		//----PW
		String pw = nextLine("[비밀번호를 입력해주세요] > ");
		
		//----이름
		String name = inputName();
		
		//----회원번호(자동증가)
		int no = accounts.get(accounts.size() + 1).getNo();
		
		//----회원리스트에 저장 
		//최초 회원가입시 사업자여부 F (Seller 로그인후 beSeller 메소드 호출하여 특정 아이디의 사업자 여부 변경)
		UserAccount UA = new UserAccount(no, name , id, pw, false);
		accounts.add(UA);
	}
	//-----------------로그인(Customer, Seller)
	public void login() { 
		System.out.println("=======[로그인 정보 입력]=======");
		
		String id = nextLine("[아이디를 입력해주세요] > ");
		String pw = nextLine("[비밀번호를 입력해주세요] > ");
		
		boolean flag = false; 
		for(UserAccount c : accounts) {
			if(c.getId().equals(id) && c.getPw().equals(pw)) {
				flag = true;
				loginUser = c;
				System.out.println("[" + loginUser.getName() + "님 환영합니다!]");
				return;
			}
		}
		if(!flag) {
			System.out.println("[(!) 아이디 또는 비밀번호가 틀렸습니다]");
		}
	}
	
	//-----------------로그아웃(Customer, Seller)
	public void logout() {
	    loginUser = null;
	    System.out.println("[로그아웃 되었습니다]");
	}
	
	//-----------------내 정보 수정하기(Customer, Seller)
	public void modify() { //수정가능요소 : ID, PW, name
		System.out.println("=======[내 회원정보 수정]=======");
		String id = nextLine("[수정]ID > ");
		UserAccount c = findByID(id);
		if(c == null) {
			System.out.printf("[아이디 :\"%s\"가 \"%s\"로 수정됩니다.]", getLoginUser().getId(), id);
//			getLoginUser().getId() = id;
			loginUser.setId(id);
		} else {
			System.out.println("[(!)이미 존재하는 ID 입니다.]");
			return;
		}
		
		String name = nextLine("[수정]이름 입력 > ");
//		String tel = nextLine("[수정]HP 입력(010-1111-2222) > ");
//		String email = nextLine("[수정]e-mail 입력 > ");
		String pw = nextLine("[수정]PW 입력 > ");
		
		loginUser.setName(name);
//		c.setTel(tel);
//		c.setEmail(email);
		loginUser.setPw(pw);
	}
	
//===============================Customer 전용=====================
	//-----------------내 정보 보기(only Customer)
	//주문내역확인 (커스토머/오더 클래스의 누적금액(소비금액), 주문내역 가져와야할듯)
	public void myPage() {
		System.out.println("(임시) 내 정보 보기 (임시)");
	}
	
//===============================Seller 전용=====================
	
	//-----------------회원목록 조회(only Seller)
	///학생예제에서는 조회,석차순조회 별도 메뉴탭이었지만...
	/// [1. 뒤로가기] [2. 번호순(소비순)] 번갈아가며 보여주면 UX면에서 좋을것같아요! * 플머님 구현가능한가요? 일단 함 해보죠

	public void read() { //회원번호순 조회
		System.out.println("=======[회원 목록 조회]=======");
		System.out.println("[회원번호순 정렬]");
		print(accounts);
		
		switch (nextInt("[1.뒤로가기][2.누적소비순 정렬]")) {
		case 1 : return;
		case 2 : allSpend();
		}
	}
	public void allSpend() { //누적소비금액 높은 순 조회
		System.out.println("[누적소비순 정렬]"); 
//		Collections.sort(sortedAccounts, (o1, o2) -> o2.allSpend() - o1.allSpend());
		switch (nextInt("[1.뒤로가기][2.회원번호순 정렬]")) {
		case 1 : return;    //어? 이거.. read > allSpend로 접근한건데 여기서 리턴하면 read()로 돌아가나..? main으로 보내고 싶은데?    *******테스트 필요
		case 2 : read();	//이렇게 가도 되나? ^^)) 궁금하네요 메인 호출해보고 테스트 해보죠? ^^)))
		}
	}  

	
	//-----------------회원 사업자 여부 변경(only Seller)
	public void beSeller() { 
		System.out.println("=======[회원 사업자 여부 변경]=======");
		String id = nextLine("[ID를 입력해주세요] > ");	
		UserAccount s = findByID(id);
		if(s != null) {
			if(!s.isSeller) {
				System.out.printf("[\"id: %s\"가 사업자로 설정되었습니다.]", s.getId());
				s.isSeller = true;
			} else {
				System.out.printf("[\"id: %s\"는 현재 사업자 등록된 계정입니다.]\n", s.getId());
				if(nextConfirm("[위 계정의 사업자 권한을 박탈하시겠습니까?] > ")) {
					s.isSeller = false;
					System.out.printf("[\"id: %s\"의 사업자 권한이 박탈되었습니다.]", s.getId());
					return;
				}
			}
		} else {
			System.out.println("[(!) 존재하지 않는 ID입니다.]");
		}
		// ********** if문 뎁스가 조금 깊죠..? ^^;;;;;; 관련한 코드 수정 피드백 언제나 환영합니다.
	}
	
//====================================================UserService class end line
}

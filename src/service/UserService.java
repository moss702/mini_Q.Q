package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Admin;
import domain.Customer;
import domain.User;
import qq.UserAccount;

import static qq.Util.nextLine;
import static utils.QqUtils.*;

public class UserService {
	// 싱글톤
	private static final UserService USER_SERVICE = new UserService();
	private UserService() {	}
	public static UserService getInstance() {
		return USER_SERVICE;
	}
	
	// 유저리스트 생성
	List<User> users = new ArrayList<>();

	// 초기화 블럭
	{
		users.add(new Admin(1, "admin", "1234", "고양이관리자님"));
//		users.add(new Customer(2, "guest1", "1234", "새똥이"));
//		users.add(new Customer(3, "guest2", "1234", "개똥이"));
		users.add(new Admin(4, "admin2", "1234", "멍멍이관리자님"));
	}
	
	// 로그인 상태 저장
	private User loginUser;
	public User getLoginUser() {
		return loginUser;
	}
	
	
	public <T extends User> List<T> getUsers(Class<T> clazz) {
		return users.stream().filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toList());
		
//		이 부분은 for를 통한 list 탐색
//		List<T> ts = new ArrayList<>();
//		for(User user : users) {
//			if(clazz.isInstance(user)) {
//				ts.add(clazz.cast(user));
//			}
//		}
//		return ts;
	}
	
	// findBy 입력 : id, 클래스, 출력 : 해당하는 클래스 users 스트림 
	public <T extends User> T findBy(String id, Class<T> clazz) {
		return users.stream().filter(u -> clazz.isInstance(u) && u.getId().equals(id)).map(clazz::cast).findFirst().orElse(null);
	}
	
	
	// 회원가입
//	public void register(User user) {
//		users.add(user);
//	}
	public void register() {
		System.out.println("=======[회원가입 정보 입력]=======");
	}
	
	// 수정
	public void modify(User user) {
		
	}
	
	//-----------------로그인(Customer, Seller)
	public void login() { 
		System.out.println("=======[로그인 정보 입력]=======");
		
		String id = nextLine("[아이디를 입력해주세요] > ");
		String pw = nextLine("[비밀번호를 입력해주세요] > ");
		
		boolean flag = false; 
		for(User c : users) {
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
	
	
	
	
	
	// 테스트 메인
//		List<Admin> admins = getInstance().getUsers(Admin.class);
//		admins.forEach(System.out::println);
	
//		List<Customer> customers = getInstance().getUsers(Customer.class);
//		customers.forEach(System.out::println);
	public static void main(String[] args) {
		try {	
			while(true) {
				int input = nextInt("1.회원가입 2.로그인");
				switch (input) {
					case 1 : {
						UserService.getInstance().register();
						break;
					}
					case 2 : {
						UserService.getInstance().login();
						break;
					}
					
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
	}

	
}
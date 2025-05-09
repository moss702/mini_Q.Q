package domain;

public abstract class User {
	// 필드
	private int userNo; // 유저넘버
	private String id;	// 아이디
	private String pw;	// 비밀번호
	private String name; // 이름

	// 게터,세터
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 생성자
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userNo, String id, String pw, String name) {
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	// 투스트링 
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}

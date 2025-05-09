package domain;

public class Customer extends User {
	private int no;
	private String name;
	private String email;
	private String id;
	private String pw;
	
		// 문자열을 객체 생성방법에 따른 차이
		// getter 외부로 전달하는 메서드
		// setter 외부에서 메서드에 접근하여 조건에 맞을 경우 데이터 값을 변경할 수 있는 메서드
		// to string 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드

	public Customer() {}
		
	
	public Customer (int no, String name, String email, String id, String pw) {
		
	}

	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	

@Override
public String toString() {
	return "Customer [no=" + no + ", name=" + name + ", email=" + email + ", id=" + id + ", pw=" + pw + "]";
}
}

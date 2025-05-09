package domain;

public class Customer extends User {
	private int no;
	private String name;
	private String email;
	private String id;
	private String pw;
	
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

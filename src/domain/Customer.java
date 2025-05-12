package domain;

public class Customer extends User {

	public Customer(int userNo, String id, String pw, String name) {
		super(userNo, id, pw, name);
	}

	@Override
	public String toString() {
		return "Customer [getUserNo()=" + getUserNo() + ", getName()=" + getName() + ", getId()=" + getId()
				+ ", getPw()=" + getPw() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	public void setPassword(String newPw) {
		// TODO Auto-generated method stub
		
	}

	
	
}

package qq;

import Membership.Coupon;
import Membership.MembershipGr;

//UserAcount : Customer, Seller가 동시에 가져야 하는 필드
public class UserAccount{	
//=============================필드======================
	private int no;		 //회원번호
	private String name; //회원이름
	private String id;	 //회원ID
	private String pw;	 //회원PW

	public boolean isSeller = false; //사업자 여부
	
//=============================생성자======================
	public UserAccount() { }

	public UserAccount(int no, String name, String id, String pw, boolean isSeller) {
		this.no = no;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.isSeller = isSeller;
	}
//=============================toString======================
	@Override
	public String toString() {
		return "[회원번호 : " + no + ", 회원이름 : " + name + ", 회원 I D : " + id + ", 회원 P W : " + pw + ", 사업자 여부 : " + isSeller + "]";
	}	
//=============================getter / setter======================
	
	
	
	
	
	public UserAccount get(int i) {
		// TODO Auto-generated method stub
		return null;
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

	public MembershipGr getGrade() {
		return null;
	}	//( 이메서드 필요함 쿠폰만들때

	public void addCoupon(Coupon coupon) {
	}    //이메서드도필요

	public int getTotalSpent() {
		return 0;
		//이메서드도쿠폰필요
	}
}


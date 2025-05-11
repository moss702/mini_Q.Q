package qq;

public class Seller extends UserAccount {
	
	private static String id;
	private static int no;
	private static String name;

	public Seller(boolean isSeller) {
		// TODO Auto-generated constructor stub
		super(no, id, name, id, isSeller);
	}

	public Seller(int no, String name, String id, String pw, boolean isSeller) {
		super(no, name, id, pw, isSeller);
		// TODO Auto-generated constructor stub
	}
	
	
}

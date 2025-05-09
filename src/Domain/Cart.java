package domain;

public class Cart extends Menu{
	private int amount;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Menu menu, int amount) {
		super(menu.getNo(), menu.getName(), menu.getCategory(), menu.getPrice());
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}

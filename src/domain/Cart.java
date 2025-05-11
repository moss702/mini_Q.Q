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

	@Override
	public String toString() {
		return " [메뉴=" + getName() + "]" + " [가격 = " + getPrice() + "]" + " [수량=" + amount + "]" + " [소계=" + getPrice() * amount + "]" ;
	}

	
}

package Domain;

public class Cart extends Menu{
	int amount;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Menu menu, int amount) {
		super(menu.no, menu.name, menu.category, menu.price);
		this.amount = amount;
	}

	
}

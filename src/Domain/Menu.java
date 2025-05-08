package Domain;

public class Menu {
	public int no;
	String name;
	int category; // 0 메인메뉴, 1 사이드,  2 주류
	int price;
	boolean sale = true;
	
	public Menu() {	}
	public Menu(int no, String name, int category, int price) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [no=" + no + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
}

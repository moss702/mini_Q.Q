package Domain;

public class Menu {
	public int no;
	public String name;
	public int category; // 0 메인메뉴, 1 사이드,  2 주류
	public int price;
	boolean sale = true;
	
	public Menu() {	}
	public Menu(int no, String name, int category, int price) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		
	}
		// Getter/Setter 사용할수있게 만들어놈
		public int getNo() { return no; }
		public void setNo(int no) { this.no = no; }
		
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }

		public int getCategory() { return category; }
		public void setCategory(int category) { this.category = category; }

		public int getPrice() { return price; }
		public void setPrice(int price) { this.price = price; }
		
		public boolean isSale() { return sale; }
		public void setSale(boolean sale) { this.sale = sale; }

	@Override
	public String toString() {
		return "Menu [no=" + no + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
}

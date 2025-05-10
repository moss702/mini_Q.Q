package domain;
import java.util.Date;
import java.util.List;

public class Order {
	private Customer customer;
	private List<Cart> cart;
	private Date date = new Date();
	private boolean pay; // false 주문만 true 결제완료 상태
	private int sales;
	
	public Order() {
	}

	public Order(Customer customer, List<Cart> cart, int sales) {
		this.customer = customer;
		this.cart = cart;
		this.sales = sales;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
		
	@Override
	public String toString() {
		return "주문내역 [손님 정보 : " + customer + ", 주문내역 : " + cart + ", 결제 시간 : " + date + ", 결제 금액 : " + sales
				+ "]";
	}
}

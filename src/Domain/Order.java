package Domain;
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

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", cart=" + cart + ", date=" + date + ", pay=" + pay + ", sales=" + sales
				+ "]";
	}
	

}

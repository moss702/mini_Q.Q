package Domain;
import java.util.Date;
import java.util.List;

public class Order {
	Customer customer;
	List<Cart> cart;
	Date date = new Date();
	public boolean pay; // false 주문만 true 결제완료 상태
	
	public Order() {
	}

	public Order(Customer customer, List<Cart> cart) {
		this.customer = customer;
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", cart=" + cart + ", date=" + date + ", pay=" + pay + "]";
	}

}

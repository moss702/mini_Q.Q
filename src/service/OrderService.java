package service;
import java.util.ArrayList;
import java.util.List;

import domain.Cart;
import domain.Customer;
import domain.Menu;
import domain.Order;
public class OrderService {
	private static final OrderService ORDER_SERVICE = new OrderService();
	private OrderService() {	}
	public static OrderService getInstance() {
		return ORDER_SERVICE;
	}
	
	List<Order> orders = new ArrayList<Order>();
	{
		
	}
	// CRUD
	
	// 주문하기 (장바구니 담기+주문하기)
	public void makeOrder() {
		List<Cart> carts = new ArrayList<>();
		MenuService.getInstance().read();
		// 상품 번호를 입력받고
		Menu m = MenuService.getInstance().findBy(0);
		// 수량 입력
		int amount = 2;
		Cart cart = new Cart(m, amount);
		carts.add(cart);
		
		Order order = new Order(null, carts);
		orders.add(order);
		
		// 결제 프로세스 진행
		order.pay = true;
	}
	
	
	// 결제취소
	
	// 결제 조회
}

package service;
import java.util.ArrayList;
import java.util.List;


import domain.Cart;
import domain.Customer;
import domain.Menu;
import domain.Order;
import qq.Util;

public class OrderService {
	
	
	private static final OrderService ORDER_SERVICE = new OrderService();
	private CustomerService cu = CustomerService.getInstance();
	private OrderService() {	}
	public static OrderService getInstance() {
		return ORDER_SERVICE;
	}
	List<Order> orders = new ArrayList<Order>(); // 영수증 정보
	{
		
	}
	// CRUD
	
	// 주문하기 (장바구니 담기+주문하기)
	public void makeOrder() {
		while(true) {
			List<Cart> carts = new ArrayList<>();
//			MenuService.getInstance().read();
			// 상품 번호를 입력받고
			int no = Util.nextInt("주문하실 메뉴 번호를 입력하세요 > ");
			Menu m = MenuService.getInstance().findBy(no);
			// 수량 입력
			int amount = Util.nextInt("담을 수량을 입력하세요 > ");
			Cart cart = new Cart(m, amount);
			carts.add(cart);
			if(Util.nextConfirm("메뉴판으로 돌아가시겠습니까?(y/n) > ")) {
				break;
			}
			int sales = 0;
			for(Cart c : carts) {
				sales += c.getAmount() * c.getPrice();
			}
//			결제 프로세스 진행
			System.out.println("결제하실 금액은 " + sales + "원 입니다."); 
			Util.nextInt(sales + "원을 입력하여주세요. > ");
			System.out.println("결제가 완료되었습니다.");
			Order order = new Order(null, carts, sales); // null에는 login된 customer를 가져와야 함
			orders.add(order);
			order.pay = true;
			return;
		}
	}
	
	
	// 결제취소
	
	// 결제 조회
}

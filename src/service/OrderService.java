package service;
import java.util.ArrayList;
import java.util.List;

import domain.Cart;
import domain.Customer;
import domain.Menu;
import domain.Order;
import domain.User;
import utils.QqUtils;

public class OrderService {
	
	private static final OrderService ORDER_SERVICE = new OrderService();
	private CustomerService cu = CustomerService.getInstance();
	private OrderService() {	}
	public static OrderService getInstance() {
		return ORDER_SERVICE;
	}
	private List<Order> orders = new ArrayList<Order>(); // 영수증 정보
	{
		
	}
	// CRUD
	
	// 주문하기 (장바구니 담기+주문하기)
	public void makeOrder() {
		while(true) {
			List<Cart> carts = new ArrayList<>();
			MenuService.getInstance().read();
			// 상품 번호를 입력받고
			int no = QqUtils.nextInt("주문하실 메뉴 번호를 입력하세요 > ");
			Menu m = MenuService.getInstance().findBy(no); // 숫자 번호는 1번부터
			// 수량 입력
			int amount = QqUtils.nextInt("담을 수량을 입력하세요 > ");
			Cart cart = new Cart(m, amount);
			carts.add(cart);
			if(QqUtils.nextConfirm("메뉴판으로 돌아가시겠습니까?(y/n) > ")) {
				break;
			}
			int sales = 0;
			for(Cart c : carts) {
				sales += c.getAmount() * c.getPrice();
			}
//			결제 프로세스 진행
			System.out.println("결제하실 금액은 " + sales + "원 입니다."); 
			QqUtils.nextInt(sales + "원을 입력하여주세요. > ");
			System.out.println("결제가 완료되었습니다.");
//			private Customer lc = cu.loginCustomer;
			Order order = new Order(null, carts, sales); // null에는 login된 customer 즉 lc를 가져와야 함
			orders.add(order);
			order.setPay(true);
			return;
		}
	}
	// 결제 취소
	public void cancle() {
		int no = QqUtils.nextInt("결제를 취소하실 메뉴 번호를 선택하여 주십시오. > ");
		
		int amount = QqUtils.nextInt("결제를 취소하실 수량을 선택하여 주십시오. > ");
		
	}
	
	// 결제 조회, 관리자/손님 페이지에서 조회 관리자 -> 매출 조회, 손님 -> 누적 소비금액 및 쿠폰 관련
	public Order findByPayment(User u) { 
		for (Order o : orders) {
			if(u == o.getCustomer()) {
				return o;
			}
		}
		return null; 
	}
	
	public static void main(String[] args) {// 구동 연습 메서드
		OrderService order = ORDER_SERVICE.getInstance();
		while(true) {
			int no = QqUtils.nextInt(" 1. 주문하기, 2. 결제 취소하기 3. findBy점검 4. 종료");
			switch (no) {
			case 1 :  order.makeOrder();
			break;
			
			case 2 : order.cancle();
			break;
			
			case 3 : order.findByPayment(new Customer());
			break;
			}
		}
	}
}

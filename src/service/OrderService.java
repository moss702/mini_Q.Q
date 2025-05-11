package service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Cart;
import domain.Customer;
import domain.Menu;
import domain.Order;
import domain.User;
import utils.QqUtils;

public class OrderService {
	
	private static final OrderService ORDER_SERVICE = new OrderService();
	private CustomerService cu = CustomerService.getInstance(); // 이후에 getloginCustmoer 메서드를 통해 호출하여야 한다.
	private OrderService() {	}
	public static OrderService getInstance() {
		return ORDER_SERVICE;
	}
	private List<Order> orders = new ArrayList<Order>(); // 주문 내역 집합
	private List<Cart> carts = new ArrayList<>(); // 장바구니
	static Customer kim = new Customer(1, "김찬", "kim@123", "kim", "1234" ); // 로그인 커스토머 담기 전 임시
	int num ;
	{
		
		
	}
	// CRUD
	
	// 주문하기 (장바구니 담기)
	public void getItem() {
		while(true) {
			MenuService.getInstance().read();
			// 상품 번호를 입력받고
			int no = QqUtils.nextInt("주문하실 메뉴 번호를 입력하세요 > ");
			Menu m = MenuService.getInstance().findBy(no); // 숫자 번호는 1번부터
			// 수량 입력
			int amount = QqUtils.nextInt("담을 수량을 입력하세요 > ");
			Cart cart = new Cart(m, amount);
			carts.add(cart);
			if(QqUtils.nextConfirm("메뉴판으로 돌아가시겠습니까?(y/n) > ")) {
				continue;
			} 
			System.out.println("주문화면으로 돌아갑니다.");
			break;	
		}
	}
	
	public void deleteItem() {
		
	}
	
	//결제하기 
	public void pay() {
		System.out.println("주문하신 메뉴는 " + carts + " 입니다.");
		int sales = 0;
		for(Cart c : carts) {
			sales += c.getPrice() * c.getAmount();
		}
		System.out.println("결제하실 금액은 " + sales + "원 입니다."); 
		if(sales != QqUtils.nextInt(sales + "원을 입력하여주세요. > ")) {
			System.out.println("올바른 값을 입력하여 주십시오.");
			System.out.println("주문화면으로 돌아갑니다.");
			carts.clear();
			return;
		}
		List<Cart> tmp = new ArrayList<>();
		tmp.addAll(carts);
		
		Order order = new Order(++num, kim, tmp, sales, new Date()); // kim 대신 로그인한 손님을 대입해야 함
		orders.add(order);
		order.setPay(true);
		System.out.println("결제가 완료되었습니다.");
		System.out.println(orders);  
		carts.clear();
		return;
	}
	// 결제 취소
	public void cancle() { // 취소 했을 때의 시간도 반영되어야 한다.
		List<Order> tmp = findByPayment(kim);// loginCustomer를 집어넣어야 한다.
		int no = QqUtils.nextInt("결제를 취소하실 주문번호를 선택하여 주십시오. > ");
		Order order = new Order();
		boolean res = false;
		for(Order o : tmp) {
			if(o.getNum() == no) {
				order = o;
				res = true;
				break;
			}
		}
		if(!res) {
			System.out.println("올바른 주문번호를 입력하세요.");
			return;			
		}
		int menu = QqUtils.nextInt("결제를 취소하실 메뉴 번호를 선택하여 주십시오. > ");
		Cart car = new Cart();
		res = false;
		for(Cart c : order.getCart()) {
			if(c.getNo() == menu) {
				car = c;
				res = true;
				break;
			}
		}	
		if(!res) {
			System.out.println("올바른 메뉴번호를 입력하세요.");
			return;			
		}
		
		int amount = QqUtils.nextInt("결제를 취소하실 수량을 선택하여 주십시오. > ");
		res = false;
		if(car.getAmount() >= amount) {	
			res = true;
			order.setSales(order.getSales() - car.getPrice() * amount);
			car.setAmount(car.getAmount() - amount);
			order.setDate(new Date());
			if(car.getAmount() == 0) {
				order.getCart().remove(car);
			}
			System.out.println(findByPayment(kim));
			return;
		}
		if(!res) {
			System.out.println("올바른 수량을 입력하여주세요.");
			return;
		}
	}
	
	// 결제 조회, 관리자/손님 페이지에서 조회 관리자 -> 매출 조회, 손님 -> 누적 소비금액 및 쿠폰 관련
	public List<Order> findByPayment(Customer c) { //loginCustomer를 집어 넣는다 개인의 주문금액 조회, 쿠폰도 여기서 호출?/ 관리자페이지에서 손님 리스트에 손님객체 대입
		//손님 한 명당 가지고 있는 주문 수는 여러개 일 수 있으므로 리스트 타입으로 반환
		List<Order> tmp = new ArrayList<Order>();
		for (Order o : orders) {
			if(c == o.getCustomer()) {
				tmp.add(o);
			}
		}
		return tmp;
	}
	
	public void findBySales () { // 매출 조회 날짜/메뉴/수량/금액 날짜별로 금액 위주..
		System.out.println(orders);;
	}
	
	
	public static void main(String[] args) {// 구동 연습 메서드
		System.out.println(new Date());
		OrderService order = ORDER_SERVICE.getInstance();
		while(true) {
			int no = QqUtils.nextInt(" 1. 장바구니담기,  2. 장바구니 빼기 3. 결제하기 4. 결제 취소하기 5. 매출점검  6. 주문내역 점검(손님기준) 7. 종료");
			switch (no) {
			case 1 :  order.getItem();
			break;
			
			case 2 : order.deleteItem();
			break;
			
			case 3 : order.pay();;
			break;
			
			case 4 : order.cancle(); 
			break;
			
			case 5 : order.findBySales();
			break;
			
			case 6 : System.out.println(order.findByPayment(kim));
			break;
			}
		}
	}
}

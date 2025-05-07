package SSS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qq.UserAccount;
import qq.UserService;
import qq.Util;

public class OrderService {
//	// 필드
//	private UserService us = UserService.getInstance();
//	UserAccount loginAccount = us.getLoginUser();
////	us = cusotmerService.getLoginCustomer(); //로그인한 손님의 주문정보를 변경 추가 등을 하기 위한 객체 호출
//	
//	private static OrderService osv = new OrderService();
//	public static OrderService getInstance() {
//		return osv;
//	}
//	List<Order> items = new ArrayList<>();// 장바구니
//	
//	public void addItem(SMenu selected, int qty) { //장바구니 담기
//		Order or = Order.getInstance();
//		if(selected.getAmount() == 0) {
//			System.out.println( selected.getName() + "은/는 현재 재고가 없습니다.");
//			return;
//		}
//		or.snack = selected;
//		or.qty = qty;
//		items.add(or);
//		selected.decreaseAmount(qty);
//		printBasket();
//	}
//	
//	public void deleteItem(SMenu selected, int qty) { // 장바구니에 빼기
//		printBasket();
//		for(Order o : items) {
//			if(o.qty < qty) {
//				System.out.println("올바른 수량을 입력하세요.");
//				return;
//			}			
//		}
//		int tmp = items.get(selected);
//		selected.addStock(qty);
//		items.put(selected, tmp - qty);
//		if(items.get(selected) == qty ) {
//			items.remove(selected);
//		}
//		printBasket();
//	}
//
//	public void printBasket() {// 장바구니 보기
//		for(SMenu s : items.keySet()) {
//			System.out.println("현재 장바구니에는 " + s.name + " " + items.get(s) + "개가 있습니다. " + "금액 : " + s.price * items.get(s) + "원");
//		}
//	}
//	public void payment(){
//		//음식에다가 영향을 주는것, 음식 갯수 .count ++;(매출관리)
//		//음식종류.count ++;(팔린갯수?)
//		//결제화면
//		for(SMenu s : items.keySet()) {
//			sale += s.price * items.get(s);
//		}
//		System.out.println("결제하실 금액은 " + sale + "원 입니다.");	
//		int spend = Util.nextInt("결제하실 금액인 " + sale + "원을 숫자로 입력하여주세요. >");
//		if(spend != sale) {
//			System.out.println("결제하실 금액을 바르게 입력하여주십시오.");
//			System.out.println("메뉴화면으로 돌아갑니다.");
//			return;
//		}
//		System.out.println("카드결제중 입니다.");
////			c.allSpend += spend;
////			snacksPayment.addAll(snacksBasket);
//		cart = items;
//		Order or = new Order(items, sale);
//		bills.add(or);
//		items.clear();
//		System.out.println("주문이 완료되었습니다.");
//		
//	}
//	
//	
//	public void printBill() {// 영수증(결제내역)보기
////			for(int i = 0; i < bills.size(); i++) {
////				for(int j = 0; j < bills.get(i).) {				
////					bills.get(i).
////				}
////			}
//		for(Order o : bills) {
//			System.out.println(o.sale + "");
//			System.out.println(o.cart.keySet());
//		}
//	}
//	public void cancle() {
//		printBill();
//		int idx = Util.nextInt("결제를 취소하실 메뉴 번호를 작성하세요. >"); // 결제를 담은 리스트에서 주문번호 1번 : "소주" 이런식으로 나오게 설정..?
////			int amount = snacksPayment.get(idx-1).price;
////			System.out.println("취소하실 금액은" + amount + "원 입니다.");
////			int spend = Util.nextInt("취소하실 금액인 " + amount + "원을 숫자로 입력하여주세요. >");
////			if(spend != amount) {
//			System.out.println("취소하실 금액을 바르게 입력하여주십시오.");
//			System.out.println("메뉴화면으로 돌아갑니다.");
//			return;
//		}
////			loginAccount.allSpend -= amount; //총 소비 금액에서 취소한 금액 차감
////			snacksPayment.remove(idx-1); // payment list에서 음식 삭제
////			System.out.println("주문이 취소되었습니다.");
//		
}

package SSS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qq.Util;

public class Order {
	// 주문과 관련된 필드 작성, 메뉴 담기가 필요하다고 봄.
//	private Order order = new Order();
	
	
	
	 

//	    public void addItem1(SMenu menu, int qty) {
//	        if (menu.getAmount() < qty) {
//	            System.out.println("재고 부족: " + menu.getName());
//	            return;
//	        }
//
//	        // 재고 차감
//	        menu.reduceAmount(qty);
//
//	        // 주문 목록에 추가
//	        items.put(menu, items.getOrDefault(menu, 0) + qty);
//	    }
//
//	    public void printOrder1() {
//	        System.out.println("\n===== 주문 내역 =====");
//	        int total = 0;
//	        for (Map.Entry<SMenu, Integer> entry : items.entrySet()) {
//	            SMenu m = entry.getKey();
//	            int qty = entry.getValue();
//	            int price = m.getPrice() * qty;
//	            System.out.printf("%s x %d = %,d원\n", m.getName(), qty, price);
//	            total += price;
//	        }
//	        System.out.println("총 합계: " + total + "원");
//} 
	
	
//	customer에서 음식 타입의 필드가 필요함. 손님별로 주문한 정보를 보는 것이 맞는건가..?
//	List<Customer> customers = new ArrayList<>(); 손님 리스트는 필요 없고 로그인한 손님에 한해서 정보를 추가하면 될 듯 관리자페이지에서 손님리스트 필요?
//	UserService us = UserService.getInstance();
//	us = cusotmerService.getLoginCustomer(); //로그인한 손님의 주문정보를 변경 추가 등을 하기 위한 객체 호출
	private List<SMenu> snacksBasket = new ArrayList<>(); //주문한 음식을 담을 리스트 (장바구니)
	private List<SMenu> snacksPayment = new ArrayList<>(); // 결제를 완료한 음식을 담은 리스트 
//	private List<SMenu> snackMenu = new ArrayList<>(); //메뉴판
	 
	
	//snackMenu.getInfo(); // SMenu를 통해 상속받은 자손 클래스들 no, name. price, amount 가져오는 메서드 SMenu에서 만들어줘야 할 듯!	
	//음식객체
	public Order() {
	}
//    public boolean decreaseAmount(int cnt) {
//        if (amount >= cnt) {
//            amount -= cnt;
//            return true;
//        }
//        return false;
//    }
//    
//    public void addStock(int qty) {
//        if (qty > 0) {
//            stock += qty;
//        }
//    }
//    public boolean isSoldOut() {
//        return amount <= 0;
//    }
//	public Order getInstance() {
//		return order;
//
	private Map<SMenu, Integer> items = new HashMap<>(); // 장바구니 등장
	public void addItem(SMenu selected, int qty) { //장바구니 담기
		items.put(selected, qty);
		if(selected.getAmount() == 0) {
			System.out.println( selected.getName() + "은/는 현재 재고가 없습니다.");
			return;
		}
//		snacksBasket.add(selected);
		selected.decreaseAmount(qty);
	}
	
	public void deleteItem(SMenu selected, int qty) { // 장바구니에 빼기
		System.out.println(items);
		if(qty > items.get(selected)) {
			System.out.println("올바른 수량을 입력하세요.");
			return;
		}
		int tmp = items.get(selected);
		selected.addStock(qty);
		items.put(selected, tmp - qty);
		if(items.get(selected) == qty ) {
			snacksBasket.remove(selected);
		}
	}

	public void printBasket() {// 장바구니 보기
		System.out.println(items);
	}
	
	public void printBill() {// 영수증(결제내역)보기
		System.out.println(snacksPayment);
	}
	
	public void payment(){
		//Snack snack = Snack.getInstance();
		//음식에다가 영향을 주는것, 음식 갯수 .count ++;(매출관리)
		//음식종류.count ++;(팔린갯수?)
		//결제화면
		int amount = 0;
		for(SMenu s : snacksBasket) {
			amount += s.price;
		}
		System.out.println("결제하실 금액은 " + amount + "원 입니다.");	
		int spend = Util.nextInt("결제하실 금액인 " + amount + "원을 숫자로 입력하여주세요. >");
		if(spend != amount) {
			System.out.println("결제하실 금액을 바르게 입력하여주십시오.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			return;
		}
		System.out.println("카드결제중 입니다.");
//		c.allSpend += spend;
		snacksPayment.addAll(snacksBasket);
		snacksBasket.clear();
		System.out.println("주문이 완료되었습니다.");
		
	}
	
	public void cancle() {
		printBill();
		int idx = Util.nextInt("결제를 취소하실 메뉴 번호를 작성하세요. >"); // 결제를 담은 리스트에서 주문번호 1번 : "소주" 이런식으로 나오게 설정..?
		int amount = snacksPayment.get(idx-1).price;
		System.out.println("취소하실 금액은" + amount + "원 입니다.");
		int spend = Util.nextInt("취소하실 금액인 " + amount + "원을 숫자로 입력하여주세요. >");
		if(spend != amount) {
			System.out.println("취소하실 금액을 바르게 입력하여주십시오.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			return;
		}
//		c.allSpend -= amount; 총 소비 금액에서 취소한 금액 차감
		snacksPayment.remove(idx-1); // payment list에서 음식 삭제
		System.out.println("주문이 취소되었습니다.");
	}
	
	
//	public void selectMenu(List<SMenu> l) {
//		for(SMenu s : l) {
//			System.out.println(s.no + "번" + " " + s.name + " " + s.price + "원"); 
//		}
//		int no = Util.nextInt("주문하실 번호를 입력하여주세요. >");
////		if(no != findby(no)) { 메뉴에 없는 번호가 나오면 메서드 종료
////			return;
////		}
//		snacksBasket.add(l.get(no - 1));  
//	}
//	public Snack findBy(int number) {// 입력 받은 음식번호를 토대로 음식 객체 소환! 얘는 음식 클래스에서 필요한건가?
//		Snack snack = Snack.getInstance();

	

	public void printOrder() {
	//이친구도 메뉴판호출에필요
		
	}

			
//		for(Snack s : snacks){
//			if() {			
//				return s;
//		}
//		}
//		return snack = null;
//	}
}

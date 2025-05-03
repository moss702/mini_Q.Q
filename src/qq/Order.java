package qq;

import java.util.ArrayList;
import java.util.List;

public class Order {
	// 주문과 관련된 필드 작성, 메뉴 담기가 필요하다고 봄.
	
	private Order order = new Order(); 
//	customer에서 음식 타입의 필드가 필요함. 손님별로 주문한 정보를 보는 것이 맞는건가..?
//	List<Customer> customers = new ArrayList<>(); 손님 리스트는 필요 없고 로그인한 손님에 한해서 정보를 추가하면 될 듯 관리자페이지에서 손님리스트 필요?
//	CusotmerService cs = CusotmerService.getInstance();
//	cs = cusotmerService.getLoginCustomer(); //로그인한 손님의 주문정보를 변경 추가 등을 하기 위한 객체 호출
	private List<Snack> snacksBasket = new ArrayList<>(); //주문한 음식을 담을 리스트 (장바구니)
	private List<Snack> snacksPayment = new ArrayList<>(); // 결제를 완료한 음식을 담은 리스트
	//음식객체
	public Order() {}
	
	public Order getInstance() {
		return order;
	} 
	
	public void display() {//주문 화면//
		while(true) {
			int no = Util.nextInt("1. 메인메뉴, 2. 사이드, 3. 주류 4. 장바구니 보기 5. 결제하기 6. 결제취소하기 7. 뒤로가기");
			switch (no) {
			case 1: 
		//		Snack snack = Snack.getInstance();
				System.out.println("메인메뉴를 선택하셨습니다.");
				no = Util.nextInt("1. 메뉴 1, 2. 메뉴 2, 3. 메뉴 3, 4. 메뉴 4, 5. 메뉴 5, 6. 메뉴 6"); // snack 클래스에서 메뉴번호를 부여하면 주문에서 씀
				
//				snacksBasket.add(snack.findBy(no)) // 장바구니 담을 용도 Snack class 에서 번호에 따른 findBy구현 필요
				break;
				
			case 2: 
//				Side side = Side.getInstance();
				System.out.println("사이드를 선택하셨습니다.");
				no = Util.nextInt("1. 메뉴 1, 2. 메뉴 2, 3. 메뉴 3, 4. 메뉴 4, 5. 메뉴 5, 6. 메뉴 6"); // snack 클래스에서 메뉴번호를 부여하면 주문에서 씀
//				snacksBasket.add(side.findBy(no)) // 장바구니 담을 용도 Snack class 에서 번호에 따른 findBy구현 필요
				break;
				
			case 3: 
//				Soju soju = Soju.getInstance();
				System.out.println("주류를 선택하셨습니다.");
				no = Util.nextInt("1. 메뉴 1, 2. 메뉴 2, 3. 메뉴 3, 4. 메뉴 4, 5. 메뉴 5, 6. 메뉴 6"); // snack 클래스에서 메뉴번호를 부여하면 주문에서 씀
//				snacksBasket.add(soju.findBy(no)) // 장바구니 담을 용도 Snack class 에서 번호에 따른 findBy구현 필요
				break;
			case 4: 
				System.out.println("==========장바구니==========");
				print(snacksBasket);
				if(Util.nextConfirm("주문화면으로 돌아가시려면 아무 버튼이나 눌러주세요 >")) {
					System.out.println("메뉴 화면으로 돌아갑니다."); 
					return;
				}
				break;
			case 5: 
				if(!Util.nextConfirm("주문을 확정하시겠습니까? > y/n")) {
					System.out.println("주문화면으로 돌아갑니다."); 
					break;
				}
				payment();
				break; // 로그인 후 화면으로 
			case 6: cancle(); break;
			case 7: System.out.println("메인화면으로 돌아갑니다."); return;
			default : System.out.println("올바른 번호를 눌러주세요.");
			}
		}
	}
	
	public void payment(){
		//Snack snack = Snack.getInstance();
		//음식에다가 영향을 주는것, 음식 갯수 .count ++;(매출관리)
		//음식종류.count ++;(팔린갯수?)
		//결제화면
		int amount = 0;
		for(Snack s : snacksBasket) {
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
		print(snacksPayment);
		int no = Util.nextInt("결제를 취소하실 메뉴 번호를 작성하세요. >"); // 결제를 담은 리스트에서 주문번호 1번 : "소주" 이런식으로 나오게 설정..?
		int amount = snacksPayment.get(no-1).price;
		System.out.println("취소하실 금액은" + amount + "원 입니다.");
		int spend = Util.nextInt("취소하실 금액인 " + amount + "원을 숫자로 입력하여주세요. >");
		if(spend != amount) {
			System.out.println("취소하실 금액을 바르게 입력하여주십시오.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			return;
		}
//		c.allSpend -= amount; 총 소비 금액에서 취소한 금액 차감
		snacksPayment.remove(no-1); // payment list에서 음식 삭제
		System.out.println("주문이 취소되었습니다.");
	}
	
	public void print(List<Snack> sn) {
		sn.forEach(s -> System.out.println(s));
	}

//	public Snack findBy(int no) {// 입력 받은 음식번호를 토대로 음식 객체 소환! 얘는 음식 클래스에서 필요한건가?
//		Snack snack = Snack.getInstance();
	
//		for(Snack s : snacks){
//			if() {			
//				return s;
//		}
//		}
//		return null;
//	}

}

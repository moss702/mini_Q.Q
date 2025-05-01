package qq;

import java.util.ArrayList;

public class Order {
	// 주문과 관련된 필드 작성

	Customer cu = new Customer();
//	List<Snack> snack = ArrayList<Snack>;
	//음식객체
	public Order() {}
	
	void order() { //여기에 음식 종류를 선택하게? 아니면 입력한 값을 여기에? 
		//음식에다가 영향을 주는것, 음식 갯수 .count ++;(매출관리)
		//음식종류.count ++;(팔린갯수?)
		//결제화면
		System.out.println("주문이 완료되었습니다.");
	}
	
	void cancle() {
		checkOrder();
		String basket = Util.nextLine("취소하실 음식을 선택하세요. >");
//		snack.remove(i);
		// 음식갯수 빼기
		// 
		// 결제 금액 차감
		System.out.println("주문이 취소되었습니다.");
	}
	
	void payment(){
//		int amount = 0;
//		for(int i = 0; i < snack.sizeof(); i++) {
//			amount = snack.get(i).price
//		}
//		System.out.println("결제하실 금액은" + amount + "원 입니다.");
//		
//		int spend = Util.nextInt("결제하실 금액을 숫자로 입력하여주세요. >");
//		if(spend != amount) {
//			System.out.println("결제하실 금액을 바르게 입력하여주십시오.");
//			return;
//		}
//		cu.allSpend += spend;
	}
	
	void checkOrder() {
//		System.out.println(snack);
	}
	
	
	
}

package SSS;

public class Cart extends SMenu{
	int amount; // 카트에 담을 수량
	
	public Cart() {
	}
	
	public Cart(SMenu s, int amount) {
//		Super(S) 메뉴에 들어간 필드를 포함한 것을 SUPER로 포함.
		this.amount = amount;
	}
}

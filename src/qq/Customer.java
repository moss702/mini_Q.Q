package qq;



public class Customer extends UserAccount {

    // 생성자

    public Customer(int no, String name, String id, String pw) {

        super(no, name, id, pw, false);  // false -> 고객 (일반 사용자)

    }



    // 내 정보 수정

    public void updateMyInfo(String name, String id, String pw) {

        setName(name);

        setId(id);

        setPw(pw);

        System.out.println("내 정보가 수정되었습니다.");

    }



    // 주문

    public void placeOrder(String order) {

        System.out.println("주문이 완료되었습니다: " + order);

    }



    // 결제

    public void makePayment(double amount) {

        System.out.println("결제가 완료되었습니다. 금액: " + amount + "원");

    }



    // 내 정보 확인

    public void isSeller() {

        System.out.println("내 정보:");

        System.out.println(this);  // toString()을 통해 사용자 정보 출력

    }

}


		


	
	
	

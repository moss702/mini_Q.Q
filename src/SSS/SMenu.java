package SSS;

public class SMenu {
	    int no;          // 메뉴 번호
	    String name;     // 메뉴 이름
	    int price;       // 가격
	    int amount;      // 재고 수량
	    String category; // 카테고리 (예: MainDish, Alcohol, SideDish)

	    // 기본 생성자
	    public SMenu() {}

	    // 전체 정보 생성자
	    public SMenu(int no, String name, int price, int amount, String category) {
	        this.no = no;
	        this.name = name;
	        this.price = price;
	        this.amount = amount;
	        this.category = category;
	    }

	    public int getNo() { return no; }
	    public String getName() { return name; }
	    public int getPrice() { return price; }
	    public int getAmount() { return amount; }
	    public String getCategory() { return category; }


	    public void reduceAmount(int qty) {
	        this.amount -= qty;
	    }
	    public void printMenu() {
	        System.out.printf("%d. [%s] %s - %,d원 (재고: %d개)\n", no, category, name, price, amount);
	    }
	    // 재고가 다 떨어졌는지 확인하는 메서드
	    public boolean isSoldOut() {
	        return amount <= 0;
	    }


// HashMap<SMenu, Integer> 같은 구조에서 SMenu 객체를 Key로 사용하려면 꼭 필요한 메서드들
//메뉴 번호(no)가 같으면 동일한 메뉴로 간주하게함
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof SMenu)) return false;
	        SMenu other = (SMenu) obj;
	        return this.no == other.no;
	    }

	    @Override
	    public int hashCode() {
	        return Integer.hashCode(no);
	    }

	    //재고를 1개 줄이는 메서드 (구매 후 호출)
	    public boolean decreaseAmount(int cnt) {
	        if (amount >= cnt) {
	            amount -= cnt;
	            return true;
	        }
	        return false;
	    }
	    public String getCategString() {
	        return category;
	    }

	    //재고를 추가하는 메서드 관리자 모드에서 재입고 아직 관리자 클래스 만들지않아서 구현가능할지>?..
	    public void addStock(int qty) {
	        if (qty > 0) {
	            amount += qty;
	        }
	    }

	    // 보기 좋게 출력하는 메서드 (카테고리 포함)
	    @Override
	    public String toString() {
	        return String.format("[번호 %d] (%s) %s - %,d원 [재고: %d개]", 
	                no, category, name, price, amount);
	    }

	
	}



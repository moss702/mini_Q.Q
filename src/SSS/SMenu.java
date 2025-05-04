package SSS;

public class SMenu {
	  private int no;          // 메뉴 번호
	  private String name;     // 메뉴 이름
	  private  int price;       // 가격
	  private  int amount;      // 재고 수량
	  private  String category; // 카테고리 메뉴분류하기 위해서 생성함
	  
	    // 기본 생성자
	    public SMenu() {}

	    // 전체 정보 생성자 new SMenu(1, "김치찌개", 7000, 5, "메인")처럼 객체 생성 가능.
	    public SMenu(int no, String name, int price, int amount, String category ) {
	        this.no = no;
	        this.name = name;
	        this.price = price;
	        this.amount = amount;
	        this.category = category;
	      
	    }
	    //Getter 메서드 객체의 필드 값을 읽어오는 메서드
	    public int getNo() { return no; }
	    public String getName() { return name; }
	    public int getPrice() { return price; }
	    public int getAmount() { return amount; }
	    public String getCategory() { return category; }
     
//	    private Map<SMenu, Integer> items = new HashMap<>(); // 재고차감하기위해서 해쉬맵끌어다만들어줬음
 
	    
	    //재고 차감 메서드
	    public void reduceAmount(int qty) {
	        this.amount -= qty;
	    }

	   // 메뉴 정보를 예쁘게 출력하는 메서드임
	    public void printMenu() {
	        System.out.printf("%d. [%s] %s - %,d원 (재고: %d개)\n", no, category, name, price, amount);
	    }
	    
	    // 재고가 다 떨어졌는지 확인하는 메서드 재고가 0개 이하인지 확인하는것!
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
//	    reduceAmount와 비슷한데, 조건 검사하고있음
//	    수량이 충분할 때만 재고 차감합니다 실패하면 false 반환
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

	    // 메뉴 정보를 예쁘게 출력하는 메서드임
	    public String toString() {
	        return String.format("[번호 %d] (%s) %s - %,d원 [재고: %d개]", 
	                no, category, name, price, amount);
	    }

	
	}



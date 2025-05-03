package qq;

import java.util.*;

public class SMainmenuTest {
	    public static void main(String[] args) {
	        List<SMenu> menuList = new ArrayList<>();

	        // 메뉴 객체들 추가
	        menuList.add(new SMenu(1, "김치찌개", 7000, 5, "메인"));
	        menuList.add(new SMenu(2, "제육볶음", 8000, 5, "메인"));
	        menuList.add(new SMenu(3, "감자튀김", 3000, 10, "사이드"));
	        menuList.add(new SMenu(4, "소주", 4000, 8, "주류"));

	        Scanner sc = new Scanner(System.in);
	        Order order = new Order();

	        while (true) {
	            System.out.println("\n===== 메뉴판 =====");
	            for (SMenu menu : menuList) {
	                menu.printMenu();
	            }

	            System.out.print("\n주문할 메뉴 번호 입력 (종료: 0): ");
	            int no = sc.nextInt();
	            if (no == 0) break;

	            SMenu selected = null;
	            for (SMenu m : menuList) {
	                if (m.getNo() == no) {
	                    selected = m;
	                    break;
	                }
	            }

	            if (selected == null) {
	                System.out.println("존재하지 않는 메뉴입니다.");
	                continue;
	            }

	            System.out.print("수량 입력: ");
	            int qty = sc.nextInt();
	            order.addItem(selected, qty);
	        }

	        order.printOrder();
	        sc.close();
	    
	    }
}


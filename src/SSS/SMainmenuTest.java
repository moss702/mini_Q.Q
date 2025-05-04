package SSS;

import java.util.*;

public class SMainmenuTest {
	    public static void main(String[] args) {
	    	        //메뉴 객체들을 저장하는 리스트
	    	        List<SMenu> menuList = new ArrayList<>();

	    	        menuList.add(new SMenu(1, "김치찌개", 7000, 5, "메인"));
	    	        menuList.add(new SMenu(2, "제육볶음", 8000, 5, "메인"));
	    	        menuList.add(new SMenu(3, "감자튀김", 3000, 10, "사이드"));
	    	        menuList.add(new SMenu(4, "소주", 4000, 8, "주류"));

	    	        Scanner sc = new Scanner(System.in);
//	    	        Order order = new Order(); // 주문 관리할 오더 객체

	    	        while (true) {
	    	            System.out.println("\n===== 메뉴판 =====");
	    	            for (SMenu menu : menuList) {
	    	                menu.printMenu();
	    	            }

	    	            System.out.print("\n주문할 메뉴 번호 입력 (종료: 0): ");
	    	            int no = sc.nextInt();
	    	            if (no == 0) break;
                      //해당 메뉴에 입력받는 객체가 없으면 null으로처리
	    	            SMenu selected = null;
	    	            for (SMenu m : menuList) {
	    	                if (m.getNo() == no) {
	    	                    selected = m;
	    	                    break;
	    	                }
	    	            }
	    	            //입력한 번호에 해당하는 메뉴가 없으면 다시 루프
	    	            if (selected == null) {
	    	                System.out.println("존재하지 않는 메뉴입니다.");
	    	                continue;
	    	            }
//	    	            사용자에게 수량 입력을 받고
//	    	            order.addItem() 메서드를 호출해 주문 목록에 추가 + 재고 차감합니다.
	    	            System.out.print("수량 입력: ");
	    	            int qty = sc.nextInt();

//	    	            order.addItem(selected, qty);
	    	        }

//	    	        order.printOrder();
	    	        sc.close();
	    	    }
	    	}




package SSS;

import java.util.*;

public class SMainmenuTest {
	    public static void main(String[] args) {
	    	        //메뉴 객체들을 저장하는 리스트
	    	        List<SMenu> menuList = new ArrayList<>();

	    	        menuList.add(new SMenu(1, "김치찌개", 7000, 5, "메인"));
	    	        menuList.add(new SMenu(2, "제육볶음", 8000, 5, "메인"));
	    	        menuList.add(new SMenu(3, "숙주볶음", 10000, 5, "메인"));
	    	        menuList.add(new SMenu(4, "조개찜", 12000, 5, "메인"));
	    	        menuList.add(new SMenu(5, "술찜", 10000, 5, "메인"));
	    	        menuList.add(new SMenu(6, "도가니수육", 55000, 5, "메인"));
	    	        menuList.add(new SMenu(7, "두부조림", 13000, 5, "메인"));
	    	        menuList.add(new SMenu(8, "감자전", 9000, 5, "메인"));
	    	        menuList.add(new SMenu(9, "골뱅이무침", 18000, 5, "메인"));
	    	        menuList.add(new SMenu(10, "감자튀김", 3000, 10, "사이드"));
	    	        menuList.add(new SMenu(11, "우유튀김", 3000, 10, "사이드"));
	    	        menuList.add(new SMenu(12, "타코야끼", 5000, 10, "사이드"));
	    	        menuList.add(new SMenu(13, "큐브수박", 6000, 10, "사이드"));
	    	        menuList.add(new SMenu(14, "타코와사비", 5000, 10, "사이드"));
	    	        menuList.add(new SMenu(15, "떡볶이", 3000, 10, "사이드"));
	    	        menuList.add(new SMenu(16, "소주", 4000, 8, "주류"));
	    	        menuList.add(new SMenu(17, "맥주", 5000, 8, "주류"));
	    	        menuList.add(new SMenu(18, "청하", 6000, 8, "주류"));
	    	        menuList.add(new SMenu(19, "고량주", 10000, 8, "주류"));
	    	        menuList.add(new SMenu(20, "생맥주", 4000, 8, "주류"));
	    	        menuList.add(new SMenu(21, "복분자", 10000, 8, "주류"));
	    	        menuList.add(new SMenu(22, "하이볼", 7000, 8, "주류"));

	    	        Scanner sc = new Scanner(System.in);
	    	        Order order = new Order(); // 주문 관리할 오더 객체

	    	        while (true) {
	    	           try { System.out.println("\n===== 메뉴판 =====");
	    	            for (SMenu menu : menuList) {
	    	                menu.printMenu();
	    	            }

	    	            System.out.print("\n주문할 메뉴 번호 입력 (종료: 0): ");
	    	            int no = sc.nextInt();
	    	            sc.nextLine();
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
	    	                return;
	    	            }
//	    	            사용자에게 수량 입력을 받고
//	    	            order.addItem() 메서드를 호출해 주문 목록에 추가 + 재고 차감합니다.
	    	            System.out.print("수량 입력: ");
	    	            int qty = sc.nextInt();
	    	            
	    	            sc.nextLine();
	    	            
	    	            if(qty<=0) {
	    	            	System.out.println("수량은 1 이상 입력해야 합니다.");
	    	            	return;
	    	            }
	    	            order.addItem(selected, qty);
	    	            System.out.print("취소할 수량을 입력하세요.: ");
	    	            int del = sc.nextInt();
	    	            order.deleteItem(selected, del);
	    	            order.payment();	    	            
	    	            order.printBasket();
	    	            
	    	        } catch (InputMismatchException e) {
	                    System.out.println("숫자만 입력하세요.");
	                    sc.nextLine(); // 버퍼비우는것
	                    
	                } catch (Exception e) {
	                    System.out.println("오류가 발생했습니다: " + e.getMessage());
	                    sc.nextLine(); // 버퍼비우는것
	    	           
	    	           
	    	        sc.close();
	    	    }
	    	}
	    }
}




package service;
import java.util.ArrayList;
import java.util.List;

import domain.Menu;

import java.util.*;

public class MenuService {
	private static final MenuService MENU_SERVICE = new MenuService();
	private Scanner sc = new Scanner(System.in);
	
	private MenuService() {	}
	public static MenuService getInstance() {
		return MENU_SERVICE;
		 
	}
	
	List<Menu> menus = new ArrayList<Menu>();
	{
		menus.add(new Menu(1, "차돌볶음", 0, 20_000));
		menus.add(new Menu(2, "두부조림", 0, 12_000));
		menus.add(new Menu(3, "술찜", 0, 18_000));
		menus.add(new Menu(4, "도가니수육", 0, 50_000));
		menus.add(new Menu(5, "탕수육", 0, 15_000));
		menus.add(new Menu(6, "감자전", 0, 10_000));
		menus.add(new Menu(7, "김치전", 0, 10_000));
		menus.add(new Menu(8, "타코와사비", 1, 8_000));
		menus.add(new Menu(9, "파인샤베트", 1, 8_000));
		menus.add(new Menu(10, "타코야끼", 1, 8_000));
		menus.add(new Menu(11, "소주", 2, 5_000));
		menus.add(new Menu(12, "맥주", 2, 6_000));
		menus.add(new Menu(13, "청하", 2, 7_000));
		menus.add(new Menu(14, "하이볼", 2, 8_000));
		menus.add(new Menu(15, "고량주", 2, 10_000));
	}
	// CRUD
	
	// 메뉴 등록
	
		public void register() {
			System.out.println(" 메뉴 등록");

			System.out.print("메뉴 번호 > ");
		
			int no = Integer.parseInt(sc.nextLine());
           
			Menu m = findBy(no);
			if (m != null) {
				System.out.println("중복된 메뉴 번호가 존재합니다.");
				return;
			}
			System.out.print("메뉴 이름 > ");
			String name = sc.nextLine();

			System.out.print("카테고리 (0:메인, 1:사이드, 2:주류) > ");
			int category = Integer.parseInt(sc.nextLine());
			
			System.out.print("가격 >");
			int price = Integer.parseInt(sc.nextLine());
			Menu newMenu = new Menu(no, name, category, price);
			menus.add(newMenu);
			System.out.println("메뉴가 등록되었습니다.");
		}
	// 메뉴수정
		public void modify() {
			System.out.println("메뉴 수정");

			System.out.print("수정할 메뉴 번호 > ");
			int no = Integer.parseInt(sc.nextLine());

			Menu m = findBy(no);
			if (m == null) {
				System.out.println("해당 번호의 메뉴가 존재하지 않습니다.");
				return;
			}

			System.out.print("새 이름 > ");
			m.setName(sc.nextLine());

			System.out.print("새 카테고리 (0:메인, 1:사이드, 2:주류) > ");
			m.setCategory(Integer.parseInt(sc.nextLine()));

			System.out.print("새 가격 > ");
			m.setPrice(Integer.parseInt(sc.nextLine()));
			
			System.out.println("메뉴가 수정되었습니다.");
		}


//	// 메뉴삭제
//		public void remove() {
//			System.out.println("삭제 기능");
//			int no = StudentUtils.nextInt("삭제할 학생의 학번 > ");
//			Student s = findBy(no);
//			if(s == null) {
//				System.out.println("입력된 학번이 존재하지 않습니다");
//				return;
//			}
//			students.remove(s);
//			sortedStudents.remove(s);
//			save();
//		}
//		
//		public void allAvg() {
//			// 국어, 영어, 수학, 전체평균
////			students.stream().map(s->s.getKor());
//			
//			double avgKor = 0;
//			double avgEng = 0;
//			double avgMat = 0;
//			double avgAll = 0;
//			
//			// count
//			int size = students.size();
//			for(int i = 0 ; i < size ; i++) {
//				avgKor += students.get(i).getKor(); 
//				avgEng += students.get(i).getEng(); 
//				avgMat += students.get(i).getMat(); 
//			}
//			avgKor /= (double)size;
//			avgEng /= (double)size;
//			avgMat /= (double)size;
//			
//			avgAll = (avgKor + avgEng + avgMat) / 3; 
//			
//			System.out.println(size + "명의 학생 평균");
//			System.out.println("국어 평균 " + avgKor);
//			System.out.println("영어 평균 " + avgEng);
//			System.out.println("수학 평균 " + avgMat);
//			System.out.println("전체 평균" + avgAll);
//			
//		}
//	
//	// 메뉴조회
	public void read() {
		menus.forEach(System.out::println);
	}
	
	public Menu findBy(int no) {
		for(Menu m : menus) {
			if(no == m.no) {
				return m;
			}
		}
		return null;
	}
	public void rad() {
		System.out.println("조회가능");
		print(menus);
	}
	private void print(List<Menu> menus2) {
	}
}

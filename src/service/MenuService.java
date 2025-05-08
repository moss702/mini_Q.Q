package service;
import java.util.ArrayList;
import java.util.List;

import Domain.Menu;

public class MenuService {
	private static final MenuService MENU_SERVICE = new MenuService();
	private MenuService() {	}
	public static MenuService getInstance() {
		return MENU_SERVICE;
	}
	
	List<Menu> menus = new ArrayList<Menu>();
	{
		menus.add(new Menu(1, "차돌볶음", 0, 20_000));
		menus.add(new Menu(2, "타코와사비", 1, 8_000));
	}
	// CRUD
	
	// 메뉴추가
	// 메뉴수정
	// 메뉴삭제
	
	// 메뉴조회
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
}

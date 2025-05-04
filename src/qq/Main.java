package qq;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) {
		System.out.println("================== 손님 관리 프로그램 ==================");
		for(;;) {
			try {
				switch (Util.nextInt("1.예약 2.등록 3.조회 4.삭제 5.마이페이지 6.쿠폰발급 7. 종료" )) {
				case 1:
					
					break;
				case 2:
		
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					System.out.println("bye~!");
					break;
				
				default:
					System.out.println("지정된 범위의 숫자만 입력하시오.");
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("정확한 숫자를 입력하시오.");
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}


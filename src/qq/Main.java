package qq;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) {
		System.out.println("================== 학생 점수 관리 프로그램 ==================");
		for(;;) {
			try {
				switch (Util.nextInt("1. 로그인 2.회원가입" )) {
				case 1:
					
					break;
				case 2:
		
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


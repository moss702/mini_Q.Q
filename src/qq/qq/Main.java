package qq.qq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Main instance = new Main();
    private List<UserAccount> accounts = new ArrayList<>();
    private UserAccount loginUser = null;
    private Scanner scanner = new Scanner(System.in);

    private Main() {}

    public static Main getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Main app = Main.getInstance();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("\n1. 회원가입 | 2. 로그인 | 3. 내 정보 보기 | 0. 종료");
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    read();
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    public void register() {
        System.out.print("ID 입력: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 입력: ");
        String password = scanner.nextLine();
        System.out.print("판매자입니까? (y/n): ");
        boolean isSeller = scanner.nextLine().equalsIgnoreCase("y");

        UserAccount ua = new UserAccount(id, password, isSeller);
        accounts.add(ua);
        System.out.println("회원가입 완료!");
    }

    public void login() {
        System.out.print("ID 입력: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 입력: ");
        String pw = scanner.nextLine();

        for (UserAccount ua : accounts) {
            if (ua.id.equals(id) && ua.pw.equals(pw)) {
                loginUser = ua;
                System.out.println("로그인 성공!");
                return;
            }
        }

        System.out.println("로그인 실패. 다시 시도해주세요.");
    }

    public void read() {
        if (loginUser != null) {
            System.out.println("ID: " + loginUser.id);
            System.out.println("판매자 여부: " + loginUser.isSeller);
        } else {
            System.out.println("로그인된 사용자가 없습니다.");
        }
    }
}

class UserAccounts {
    public String id;
    public String pw;
    public boolean isSeller;

    public void UserAccount(String id, String pw, boolean isSeller) {
        this.id = id;
        this.pw = pw;
        this.isSeller = isSeller;
    }
}

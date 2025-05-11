//package membership;
//
//import qq.UserAccount;
//
//public class MembershipService {
//	  public static void updateGrade(UserAccount user) {
//	        int total = user.getTotalSpent();
//	        MembershipGr newGrade;
//
//	        if (total >= 500000) {
//	            newGrade = MembershipGr.DIAMOND;
//	        } else if (total >= 300000) {
//	            newGrade = MembershipGr.PLATINUM;
//	        } else if (total >= 100000) {
//	            newGrade = MembershipGr.GOLD;
//	        } else {
//	            newGrade = MembershipGr.SILVER;
//	        }
//
//	        if (user.getGrade() != newGrade) {
//	            System.out.println(user.getName() + "님의 등급이 " + newGrade + "(으)로 상승했습니다!");
//	            user.setNo(total);
//	            CouponService.issueCoupon(user); // 등급 업그레이드 시 쿠폰 발급
//	        }
//	    }
//}

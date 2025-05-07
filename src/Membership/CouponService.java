package Membership;

import qq.UserAccount;

public class CouponService {
//CouponService.issueCoupon(user)를 호출하면, UserAccount에서회원의 등급을 얻고, 
//	그등급에 맞는 쿠폰을 만들어서 user.addCoupon(coupon)을 통해 해당 사용자에게 발급할수있지않을까?
	 public static void issueCoupon(UserAccount user) {
	        MembershipGr grade = user.getGrade(); // 회원의 등급을 가져옴 저 getname을 UserAccount에서가져와야함
	        Coupon coupon = null; //애네가 쿠폰만들어서 활용됨
	        switch (grade) {
	            case SILVER :
	                coupon = new Coupon(1000);
	                break;
	            case GOLD :
	                coupon = new Coupon(3000);
	                break;
	            case PLATINUM :
	                coupon = new Coupon(5000);
	                break;
	            case DIAMOND :
	                coupon = new Coupon(10000);
	                break;
	        } 
          // 발급된 쿠폰을 사용자에게 추가
	        if (coupon != null) {
	            user.addCoupon(coupon); //아직 UserAccount에 메서드없어서 호출불가능
	        }
	        
	        
	        
}
}

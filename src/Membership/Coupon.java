package Membership;

public class Coupon {
	//CouponService에서 등급에따라 쿠폰 객체를 생성하고,그 쿠폰을 UserAccount에 추가하면되지않을까?..
	//쿠폰 객체를 만들어서 UserAccount에 추가할려고만들었는데user.addCoupon()//이런식으로 사용하면될거같은데
	  private int discountAmount;

	    public Coupon(int discountAmount) { //생성자애를통해 쿠폰을 만들면
	        this.discountAmount = discountAmount;
	    }
	    public int getDiscountAmount() {
	        return discountAmount;
	    }
	    @Override
	    public String toString() {
	        return discountAmount + "원 할인 쿠폰";
	    }
	}


package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private  int discountPercent = 10 ;
    @Override
    public int disCount(Member member, int price) {
        if ( member.getGrade() == Grade.VIP){ // enmun은 ==으로 함
            return price * discountPercent/100 ;
        }else {
            return 0;

        }
    }
}

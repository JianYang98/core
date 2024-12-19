package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDisCountPolicy  implements  DiscountPolicy{
    private int disCountFixAmount = 1000 ;

    @Override
    public int disCount(Member member, int price) {
        if ( member.getGrade() == Grade.VIP){ // enmun은 ==으로 함
            return disCountFixAmount;
        }else {
            return 0;

        }

    }
}

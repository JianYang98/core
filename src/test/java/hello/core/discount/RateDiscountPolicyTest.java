package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy() ;
    @Test
    @DisplayName("VIP는 10% 할일이 되어야한다.")
    void vip_o(){
        //given
        Member member = new Member(1L , "memberVip" , Grade.VIP) ;
        //when
        int discount = discountPolicy.disCount(member , 10000);
        //then
        assertThat(discount).isEqualTo(1000) ;

    }
    //fail Test또 꼭 해야한다.
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){

        //given
        Member member = new Member(2L , "memberVip" , Grade.BASIC) ;
        //when
        int discount = discountPolicy.disCount(member , 10000);
        //then
        assertThat(discount).isEqualTo(0) ;
    }

}
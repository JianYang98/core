package hello.core.order;

import hello.core.discount.FixDisCountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderSerivceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L , "name" , Grade.VIP));

        OrderSerivceImpl orderSerivce = new OrderSerivceImpl(memoryMemberRepository , new FixDisCountPolicy()) ;
        Order order = orderSerivce.createOrder(1L ,"itemA", 10000 );
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000) ;
    }

}
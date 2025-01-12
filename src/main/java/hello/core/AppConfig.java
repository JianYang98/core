package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisCountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderSerivceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Appconfig 설정에 Configuration을 추가한다.
@Configuration
public class AppConfig {
    //@Bean memberService -> new MemoryMemberRepository();
    // @Bean orderSerivce -> new MemoryMemberRepository();

    @Bean
    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository()) ;// 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderSerivce orderSerivce(){
        return new OrderSerivceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){

//        return new FixDisCountPolicy() ;
        return new RateDiscountPolicy() ;
    }

}

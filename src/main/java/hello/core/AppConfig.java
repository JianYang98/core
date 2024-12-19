package hello.core;

import hello.core.discount.FixDisCountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderSerivceImpl;

public class AppConfig {

    public MemberService memberService(){
        return  new MemberServiceImpl(new MemoryMemberRepository()) ;// 생성자 주입
    }

    public OrderSerivce orderSerivce(){
        return new OrderSerivceImpl(new MemoryMemberRepository(), new FixDisCountPolicy());
    }

}

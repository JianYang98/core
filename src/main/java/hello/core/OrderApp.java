package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderSerivceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig(); // AppConfig에서 주입해주기 때문에 인터페이스에만 의존함
//        MemberService memberService = appConfig.memberService() ;
//        OrderSerivce orderSerivce = appConfig.orderSerivce() ;
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderSerivce orderSerivce = applicationContext.getBean("orderSerivce", OrderSerivce.class);



        Long memberId = 1L ; 
        Member member = new Member(memberId , "memberA" , Grade.VIP) ;
        memberService.join(member);

        Order order = orderSerivce.createOrder(memberId , "itemA" , 20000 );

        System.out.println("order = " + order);
        //System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}

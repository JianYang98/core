package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingloetonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void  pureContainer(){
        AppConfig appConfig = new AppConfig() ;

        // 1.조회 호출할때마다 객체 새성
        MemberService memberService1= appConfig.memberService();
        // 2.조회 호출할때마다 객체 새성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1); // 필요할때마다 객체를 계속 생성
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2) ;
    }

    @Test
    @DisplayName("싱글톤 패턴은 적용한 객체 사용")
    void singletonSerivceTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        // 같은 서비스 객체 출력
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2) ;
        // same == 인스턴스 비교
        // equlas == 값 같아?
    }
    
    @Test
    @DisplayName(" ㅅ프링 컨테이너와 싱글톤")
    void springContainer(){
        //AppConfig appConfig = new AppConfig() ;
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1.조회 호출할때마다 객체 새성
        MemberService memberService1= ac.getBean("memberService" , MemberService.class);
        // 2.조회 호출할때마다 객체 새성
        MemberService memberService2 =ac.getBean("memberService" , MemberService.class);

        System.out.println("memberService1 = " + memberService1); // 필요할때마다 객체를 계속 생성
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2) ;
    }
}

package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContectBaseFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class) ;
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class) ;  //  memberService 가 MemberService의 인스턴스면

    }

    @Test
    @DisplayName("이름없이 타음으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class) ;
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class) ;  //  memberService 가 MemberService의 인스턴스면
    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2(){
        // 안되면 구체적으로도 해봐도 좋아
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class) ;
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class) ;  //  memberService 가 MemberService의 인스턴스면

    }

    //실패 test
    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX(){
       // MemberService XXXX = ac.getBean("XXXXX", MemberServiceImpl.class) ;
        assertThrows(NoSuchBeanDefinitionException.class ,
                () ->ac.getBean("XXXXX", MemberServiceImpl.class));   /// ac~~ 로직 실행했을때 에려가 터져야한다. () -> 람다

    }
}

package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;


public class AplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class) ;

    @Test
    @DisplayName("빈이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService" , MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class) ;
    }

    @Test
    @DisplayName("이름없이 타음으로  조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(  MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class) ;
    }

    @Test
    @DisplayName("구첵타입으로타음으로  조회")
    void findBeanByType2(){
        MemberService memberService = ac.getBean("memberService" , MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class) ;
    }

//    @Test
//    @DisplayName("빈 이름으로 조회 x" )
//    void findBeanByBeanX(){
//        // 람다를 사용했으며 , 옆에 에러가 터져야 통과임
//        MemberService xxxxx = ac.getBean("xxxxx" , MemberService.class);
//        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class ,
//                () -> ac.getBean("xxxxx" , MemberService.class)) ;
//
//    }

}


// 컨트롤 E 전 파일로
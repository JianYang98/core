package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicaionContextBasicContext {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 , 중복오류 발생한다.")
    void findBeanByTypeDuplicate(){
      //  MemberRepository  memberRepository =  ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class ,
                () -> ac.getBean(MemberRepository.class)) ;

    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 , 빈 이름으로 저장하면 가능")
    void findBeanByNmae(){
        MemberRepository memberRepository = ac.getBean("memberRepository1" , MemberRepository.class) ;
        assertThat(memberRepository).isInstanceOf(MemberRepository.class) ;
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key= " + key+" value : " + beansOfType.get(key));
        }
        System.out.println(" beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2) ;

    }

    // Test로 config 만듦만듦
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }

    }
}

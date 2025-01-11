package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisCountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppplicationContectExtendTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타임으로 조회 시 , 자식이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeandByPartentTypeDuplicate(){
       // DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class ,
                ()-> ac.getBean(DiscountPolicy.class)) ;
    }
    @Test
    @DisplayName("부모타임으로 조회 시 , 자식이 둘 이상 있으면,빈 이름으로 지정하면됨")
    void findBeandByPartentTypeName(){
       DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy" , DiscountPolicy.class);
       assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class) ;
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class) ;
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class) ;

    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String , DiscountPolicy> bendOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(bendOfType.size()).isEqualTo(2) ;
        for (String key : bendOfType.keySet()) {
            System.out.println("key  = " + key +" value = "+ bendOfType.get(key));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")  // Object로 함ㄴ 스프링 객체에 등록된 모든 bean들 다 출출출!!
    void findAllBeandByObjectType(){
        Map<String , Object> bendOfType = ac.getBeansOfType(Object.class);
        for (String key : bendOfType.keySet()) {
            System.out.println("key  = " + key +" value = "+ bendOfType.get(key));
        }
    }

    @Configuration
    static class  TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fiDiscountPolicy(){
            return new FixDisCountPolicy();
        }

    }
}

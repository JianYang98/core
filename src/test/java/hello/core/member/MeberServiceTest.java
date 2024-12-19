package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MeberServiceTest {

    MemberService memberService ;
    @BeforeEach
    public void  beforeEach(){// before로  주입
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L) ;

        //then
        Assertions.assertThat(member).isEqualTo(findMember) ;  // 찾은거랑 생성한 거랑 같아?

    }
}

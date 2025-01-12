package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderSerivceImpl implements OrderSerivce{
    private final  MemberRepository memberRepository  ;
//    private final DiscountPolicy discountPolicy = new FixDisCountPolicy() ; // 책임이  많아!
    private final DiscountPolicy discountPolicy ;

    public OrderSerivceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId) ; // 회원 정보
        int discountPrice = discountPolicy.disCount(member,itemPrice); // 정책에서 위임합니다

        return new Order(memberId , itemName,itemPrice,discountPrice);
    }

    // Test 용도
    public MemberRepository getMemberRepository(){
        return memberRepository ;
    }
}

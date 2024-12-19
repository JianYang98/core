package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // memberRepository가 구현체를 직접 의존함으로 DIP ㅇ위뱌

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

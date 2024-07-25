package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository; //추상화에 대해서만 의존

    public MemberServiceImpl(MemberRepository memberRepository) {
        //생성자를 통해 사용하려는 Repository의 종류를 결정
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

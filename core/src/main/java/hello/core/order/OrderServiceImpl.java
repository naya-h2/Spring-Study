package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //사용하는 2개의 필드(Member, Discount) 모두 인터페이스에만 의존하도록
    private final MemberRepository memberRepository; //final: 생성자를 통해 무조건 할당
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //멤버 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인에 관한 건 discountPolicy가 전담, order에서는 할인 관련 디테일에 대해 몰라도 되니까 설계 잘한 거임!

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

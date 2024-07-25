package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //구현하는 어플리케이션에 대한 모든 환경 설정(구현체 지정 등)은 여기서만 한다.
    public MemberService memberService(){ //return type과 method명을 보면 역할과 구현 클래스를 한눈에 파악 가능
        return new MemberServiceImpl(memberRepository());
    }

    //중복으로 new를 했던 부분 수정
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy(); //Fix에서 Rate로 바꾸려면 이 부분만 바꾸면 됨! -> 클라이언트 코드를 건드릴 필요가 사라짐
    }
}

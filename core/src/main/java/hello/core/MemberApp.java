package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig(); //AppConfig 무조건 생성
//        MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService(); //구현체는 AppConfig에서 꺼내서 쓴다
        Member member = new Member(1L, "heewon", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + member1.getName());
    }
}

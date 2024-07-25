package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*; //static import하는 게 좋다.
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given
        //임의의 멤버 생성
        Member member = new Member(1L, "권호시", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        //임의의 멤버 생성
        Member member = new Member(2L, "그냥사람", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}
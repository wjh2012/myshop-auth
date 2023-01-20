package ggomg.myshopauth.serviceTest;

import ggomg.myshopauth.member.entity.Member;
import ggomg.myshopauth.member.repository.MemberRepository;
import ggomg.myshopauth.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원가입")
    public void test1() {
        Long result = memberService.signIn("회원1", "비밀번호1");
        Assertions.assertThat(result).isEqualTo(1L);
    }
}

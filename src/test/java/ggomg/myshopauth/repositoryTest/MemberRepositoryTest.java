package ggomg.myshopauth.repositoryTest;

import ggomg.myshopauth.member.entity.Member;
import ggomg.myshopauth.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입")
    public void test1() {
        Member member = memberRepository.findByName("회원1").get(0);
        Assertions.assertThat(member.getName()).isEqualTo("회원1");
    }

}

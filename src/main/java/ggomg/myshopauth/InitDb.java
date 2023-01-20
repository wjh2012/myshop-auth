package ggomg.myshopauth;

import ggomg.myshopauth.member.service.MemberService;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {

        private final MemberService memberService;

        private void dbInit1() {
            memberService.signUp("회원1", "비밀번호1");
            memberService.signUp("회원2", "비밀번호2");
            memberService.signUp("회원3", "비밀번호3");
        }
    }
}

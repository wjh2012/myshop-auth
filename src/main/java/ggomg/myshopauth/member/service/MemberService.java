package ggomg.myshopauth.member.service;

import ggomg.myshopauth.member.entity.Member;
import ggomg.myshopauth.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean signUp(String name, String rawPassword) {
        if (!isExistName(name)) {
            memberRepository.save(
                    Member.createMember(name, passwordEncoder.encode(rawPassword))
            );
            return true;
        }
        return false;
    }

    public Long signIn(String name, String password) {
        if (isExistName(name)) {
            Member member = memberRepository.findByName(name).get(0);
            if (passwordEncoder.matches(password, member.getEncodedPassword())){
                return member.getId();
            }
            return 0L;
        }
        return 0L;
    }

    private boolean isExistName(String name) {
        if (memberRepository.findByName(name).isEmpty()){
            System.out.println("없음");
            return false;
        }
        return true;
    }
}

package ggomg.myshopauth.member.service;

import ggomg.myshopauth.member.entity.Member;
import ggomg.myshopauth.member.repository.MemberRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(String name, String rawPassword) {
        if (!isExistName(name)) {
            Member member = Member.createMember(name, encodePassword(rawPassword));
            memberRepository.save(member);
        }
        System.out.println("중복된 이름이 존재합니다");
    }

    public boolean signIn(String name, String password) {
        Member member = findMember(name);
        try {
            return passwordEncoder.matches(password, member.getEncodedPassword());
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private boolean isExistName(String name) {
        if (memberRepository.findByName(name).isEmpty()){
            return false;
        }
        return true;
    }

    private Member findMember(String name) {
        if (!isExistName(name)) {
            return memberRepository.findByName(name).get(0);
        }
        throw new NoSuchElementException();
    }
}

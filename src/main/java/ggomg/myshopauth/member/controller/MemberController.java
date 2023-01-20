package ggomg.myshopauth.member.controller;

import ggomg.myshopauth.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public String saveMember(@RequestBody SignDto request) {
        if (memberService.signUp(request.getName(), request.getPassword())){
            return "성공";
        }
        return "실패";
    }

    @PostMapping("/signin")
    public Long signIn(@RequestBody SignDto request) {
        return memberService.signIn(request.getName(), request.getPassword());
    }

}

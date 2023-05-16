package knu.soft.safespace.controller;

import knu.soft.safespace.dto.LoginDto;
import knu.soft.safespace.entity.Board;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/safe/")
@Slf4j
public class MemberController {
    private MemberService memberService;

    @GetMapping("/register")
    public void register(@RequestBody Member member) {
        log.info("[start] 회원가입 요청");
        memberService.register(member);
        log.info("[end] 회원가입 요청");
    }

    @PostMapping("/writing")
    public void writing(@RequestBody Board board) {
        log.info("[start] 글 작성");
        memberService.writing(board);
        log.info("[end] 글 작성");
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto) {
        log.info("[start] 로그인");
        memberService.login(loginDto);
        log.info("[end] 로그인");
    }
}

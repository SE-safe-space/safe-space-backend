package knu.soft.safespace.service;

import knu.soft.safespace.dto.MemberResponseDto;
import knu.soft.safespace.dto.PasswordDto;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public MemberResponseDto findMemberInfoById(Long memberId) {
        return memberRepository.findById(memberId)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    public MemberResponseDto findMemberInfoByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    public String changePassword(PasswordDto passwordDto){
        Member member = memberRepository.findById(passwordDto.getUserId())
                .orElseThrow(() -> new RuntimeException("멤버가 없습니다."));

        if(!passwordEncoder.matches(passwordDto.getOriginalPassword(), member.getPassword())){
            throw new RuntimeException("password가 맞지 않습니다.");
        }

        member.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
        return "비밀번호 변경이 완료되었습니다.";

    }

}
package knu.soft.safespace.controller;

import knu.soft.safespace.dto.MemberResponseDto;
import knu.soft.safespace.jwt.SecurityUtil;
import knu.soft.safespace.service.FileUploadService;
import knu.soft.safespace.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
@RequestMapping("/safe/member")
public class MemberController {
    private final MemberService memberService;
    private final FileUploadService fileUploadService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> findMemberInfoById() {
        return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberResponseDto> findMemberInfoByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findMemberInfoByEmail(email));
    }

    // 프로필 이미지 변경
    @PatchMapping("/image")
    public ResponseEntity<String> modifyProfileImage(@RequestParam Long id, @RequestPart MultipartFile file) {
        return ResponseEntity.ok(fileUploadService.uploadFile(id, file));
    }
}
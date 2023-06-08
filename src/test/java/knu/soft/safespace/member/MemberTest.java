package knu.soft.safespace.member;


import knu.soft.safespace.domain.MemberType;
import knu.soft.safespace.dto.MemberRequestDto;
import knu.soft.safespace.dto.TokenDto;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.jwt.SecurityUtil;
import knu.soft.safespace.repository.MemberRepository;
import knu.soft.safespace.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AuthService authService;

    @DisplayName("회원가입 테스트")
    @Test
    void 회원가입_테스트() {

        authService.signup(MemberRequestDto.builder()
                .type(MemberType.MEMBER)
                .email("junitTester")
                .password("12345678")
                .name("Junit테스터")
                .introduction("테스팅")
                .phoneNumber("010-1111-2222")
                .build());

        Member junitTester = memberRepository.findByEmail("junitTester").orElseThrow(() -> new RuntimeException("멤버가 없습니다."));
        assertThat(junitTester.getName()).isEqualTo("Junit테스터");
    }

    @DisplayName("로그인 테스트")
    @Test
    void 로그인_테스트() {


        authService.signup(MemberRequestDto.builder()
                .type(MemberType.MEMBER)
                .email("junitTester")
                .password("12345678")
                .name("Junit테스터")
                .introduction("테스팅")
                .phoneNumber("010-1111-2222")
                .build());

        MemberRequestDto memberRequestDto = MemberRequestDto.builder()
                        .email("junitTester")
                        .password("12345678")
                        .build();


        assertThat(authService.login(memberRequestDto)).isNotNull();

    }
}

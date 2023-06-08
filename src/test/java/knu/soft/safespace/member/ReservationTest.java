package knu.soft.safespace.member;

import knu.soft.safespace.domain.MemberType;
import knu.soft.safespace.domain.ReservationState;
import knu.soft.safespace.dto.MemberRequestDto;
import knu.soft.safespace.dto.ReservationDto;
import knu.soft.safespace.entity.Reservation;
import knu.soft.safespace.repository.MemberRepository;
import knu.soft.safespace.repository.ReservationRepository;
import knu.soft.safespace.service.AuthService;
import knu.soft.safespace.service.ConsultingService;
import knu.soft.safespace.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
public class ReservationTest {

    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public MemberService memberService;
    @Autowired
    public ReservationRepository reservationRepository;
    @Autowired
    public ConsultingService consultingService;
    @Autowired
    private AuthService authService;


    @DisplayName("예약 테스트")
    @Test
    void 예약_테스트() {
        authService.signup(MemberRequestDto.builder()
                .type(MemberType.MEMBER)
                .email("memberEmail")
                .password("12345678")
                .name("멤버1")
                .introduction("테스팅")
                .phoneNumber("010-1111-2222")
                .build());

        authService.signup(MemberRequestDto.builder()
                .type(MemberType.COUNSELOR)
                .email("counselorEmail")
                .password("12345678")
                .name("상담자1")
                .introduction("테스팅")
                .phoneNumber("010-1111-2222")
                .build());

        consultingService.reserve(ReservationDto.builder()
                .memberId(1L)
                .counselorId(2L)
                .text("예약입니당")
                .type("진로 고민")
                .build());

        Reservation reservation = reservationRepository.findByMemberIdAndCounselorId(1L,2L);
        assertThat(reservation.getAccept()).isEqualTo(ReservationState.WAIT);
    }
}

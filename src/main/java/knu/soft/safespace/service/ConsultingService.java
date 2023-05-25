package knu.soft.safespace.service;

import knu.soft.safespace.domain.MemberType;
import knu.soft.safespace.domain.ReservationState;
import knu.soft.safespace.dto.MemberResponseDto;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.entity.Reservation;
import knu.soft.safespace.repository.MemberRepository;
import knu.soft.safespace.repository.ReservationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import knu.soft.safespace.domain.ReservationState;
import java.util.ArrayList;
import java.util.List;

import static knu.soft.safespace.domain.ReservationState.*;
import static knu.soft.safespace.domain.MemberType.*;

@Getter
@Service
@RequiredArgsConstructor
public class ConsultingService {

    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;

    public ArrayList<MemberResponseDto> getCounselor(){

        List<Member> byType = memberRepository.findByType(COUNSELOR);

        ArrayList<MemberResponseDto> counselors = new ArrayList<>();
        for (Member member : byType) {
            counselors.add(MemberResponseDto.toCounselor(member));
        }
        return counselors;
    }

    public String reserve(Reservation reservation){
        reservationRepository.save(Reservation.builder()
                .memberId(reservation.getMemberId())
                .counselorId(reservation.getCounselorId())
                .type(reservation.getType())
                .accept(WAIT)
                .build());
        return "예약 완료";
    }

    public List<Reservation> getReservation(Long id){
        return reservationRepository.findByMemberIdOrCounselorId(id, id);
    }

    public String acceptReservation(Reservation reservation) {
        Reservation findReservation = reservationRepository.
                findByMemberIdAndCounselorId(reservation.getMemberId(), reservation.getCounselorId());

        // 승인됨으로 바꿔줌
        if (findReservation.getAccept() == WAIT){
            findReservation.setAccept(ACCEPTED);
        }

        // 채팅방도 만들어줘야함.

        return "예약 승인 완료";
    }

}

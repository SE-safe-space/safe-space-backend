package knu.soft.safespace.service;

import knu.soft.safespace.dto.MemberResponseDto;
import knu.soft.safespace.dto.ReservationDto;
import knu.soft.safespace.entity.ChatRoom;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.entity.Reservation;
import knu.soft.safespace.repository.ChatRoomRepository;
import knu.soft.safespace.repository.MemberRepository;
import knu.soft.safespace.repository.ReservationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static knu.soft.safespace.domain.ReservationState.*;
import static knu.soft.safespace.domain.MemberType.*;

@Getter
@Service
@RequiredArgsConstructor
public class ConsultingService {

    private final ChatRoomRepository chatRoomRepository;

    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;

    public ArrayList<MemberResponseDto> getCounselorList(){

        List<Member> byType = memberRepository.findByType(COUNSELOR);

        ArrayList<MemberResponseDto> counselors = new ArrayList<>();
        for (Member member : byType) {
            counselors.add(MemberResponseDto.toCounselor(member));
        }
        return counselors;
    }

    public MemberResponseDto getCounselor(Long id){
        Member counselor = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("멤버가 없습니다."));

        return MemberResponseDto.toCounselor(counselor);
    }

    public String reserve(ReservationDto reservationDto){
        reservationRepository.save(Reservation.builder()
                .memberId(reservationDto.getMemberId())
                .counselorId(reservationDto.getCounselorId())
                .type(reservationDto.getType())
                .text(reservationDto.getText())
                .accept(WAIT)
                .build());
        return "예약 완료";
    }

    public List<Reservation> getReservation(Long id){
        return reservationRepository.findByMemberIdOrCounselorId(id, id);
    }

    public String acceptReservation(ReservationDto reservationDto) {
        Reservation findReservation = reservationRepository.
                findByMemberIdAndCounselorId(reservationDto.getMemberId(), reservationDto.getCounselorId());

        // 승인됨으로 바꿔줌
        if (findReservation.getAccept() == WAIT){
            findReservation.setAccept(ACCEPTED);
        }

        // 채팅방도 만들어줘야함.
        chatRoomRepository.save(ChatRoom.builder()
                .member(memberRepository.findById(reservationDto.getMemberId())
                        .orElseThrow(() -> new RuntimeException("멤버가 없습니다.")))
                .counselor(memberRepository.findById(reservationDto.getCounselorId())
                        .orElseThrow((() -> new RuntimeException("멤버가 없습니다."))))
                .build());
        return "예약 승인 완료";
    }

    public String rejectReservation(ReservationDto reservationDto) {
        reservationRepository.deleteByMemberIdAndCounselorId(reservationDto.getMemberId(), reservationDto.getCounselorId());
        return "예약 거절 완료";
    }
}

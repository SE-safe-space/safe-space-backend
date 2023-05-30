package knu.soft.safespace.controller;

import knu.soft.safespace.dto.MemberResponseDto;
import knu.soft.safespace.dto.ReservationDto;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.entity.Reservation;
import knu.soft.safespace.repository.MemberRepository;
import knu.soft.safespace.service.ConsultingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/safe/consult")
public class ConsultingController {
    private final ConsultingService consultingService;

    // 상담사 조회
    @GetMapping("/counselor")
    public ResponseEntity<ArrayList<MemberResponseDto>> getCounselor (){
        return ResponseEntity.ok(consultingService.getCounselor());
    }

    // 예약 하기
    @PostMapping("/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReservationDto reservationDto){
        return ResponseEntity.ok(consultingService.reserve(reservationDto));
    }

    // 예약 조회 (상태로 판단)
    @GetMapping("{id}")
    public ResponseEntity<List<Reservation>> getReservation(@PathVariable Long id){
        return ResponseEntity.ok(consultingService.getReservation(id));
    }

    // 예약 승인
    @PostMapping("/accept")
    public ResponseEntity<String> acceptReservation(@RequestBody ReservationDto reservationDto){
        return ResponseEntity.ok(consultingService.acceptReservation(reservationDto));
    }

    // 예약 거절
    @PostMapping("/reject")
    public ResponseEntity<String> rejectReservation(@RequestBody ReservationDto reservationDto){
        return ResponseEntity.ok(consultingService.rejectReservation(reservationDto));
    }

}

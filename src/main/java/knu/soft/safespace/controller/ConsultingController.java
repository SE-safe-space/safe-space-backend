package knu.soft.safespace.controller;

import knu.soft.safespace.dto.MemberResponseDto;
import knu.soft.safespace.dto.ReservationDto;
import knu.soft.safespace.entity.Reservation;
import knu.soft.safespace.service.ConsultingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/safe/consult")
@CrossOrigin
public class ConsultingController {
    private final ConsultingService consultingService;

    // 상담사 조회
    @GetMapping("/counselor")
    public ResponseEntity<ArrayList<MemberResponseDto>> getCounselorList (){
        return ResponseEntity.ok(consultingService.getCounselorList());
    }

    @GetMapping("/counselor/{id}")
    public ResponseEntity<MemberResponseDto> getCounselor(@PathVariable Long id){
        return ResponseEntity.ok(consultingService.getCounselor(id));
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

    // 예약 승인 -> 채팅방까지 만들어준다.
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

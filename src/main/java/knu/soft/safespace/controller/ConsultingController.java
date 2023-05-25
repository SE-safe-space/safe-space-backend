package knu.soft.safespace.controller;

import knu.soft.safespace.dto.MemberResponseDto;
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
    public ResponseEntity<String> reserve(@RequestBody Reservation reservation){
        return ResponseEntity.ok(consultingService.reserve(reservation));
    }

    // 예약 조회 (상태로 판단)
    @GetMapping("{id}")
    public ResponseEntity<List<Reservation>> getReservation(@PathVariable Long id){
        return ResponseEntity.ok(consultingService.getReservation(id));
    }

    // 예약 승인
    @PostMapping
    public ResponseEntity<String> acceptReservation(@RequestBody Reservation reservation){
        return ResponseEntity.ok(consultingService.acceptReservation(reservation));
    }

    // 예약 거절
}

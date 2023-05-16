package knu.soft.safespace.service;

import knu.soft.safespace.dto.LoginDto;
import knu.soft.safespace.dto.ReservationDto;
import knu.soft.safespace.entity.Board;
import knu.soft.safespace.entity.Member;
import knu.soft.safespace.entity.Reservation;
import knu.soft.safespace.repository.BoardRepository;
import knu.soft.safespace.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {

    private MemberRepository memberRepository;
    private BoardRepository boardRepository;

    public void register(Member member) {
        memberRepository.save(member);
    }

    public void writing(Board board) {
        boardRepository.save(board);
    }

    public void login(LoginDto loginDto) {
        memberRepository.findByLoginIdAndPassword(loginDto.getLoginId(), loginDto.getPassword())
                .orElseThrow(RuntimeException::new);
    }

    public void reserve(ReservationDto reservationDto) {

    }



}

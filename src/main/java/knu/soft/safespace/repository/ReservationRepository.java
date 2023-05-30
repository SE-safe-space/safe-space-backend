package knu.soft.safespace.repository;

import knu.soft.safespace.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByMemberIdOrCounselorId(Long memberId, Long counselorId);
    Reservation findByMemberIdAndCounselorId(Long memberId, Long counselorId);

    @Modifying
    long deleteByMemberIdAndCounselorId(Long memberId, Long counselorId);

}

package knu.soft.safespace.repository;

import knu.soft.safespace.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByMemberIdOrCounselorId(Long memberId, Long counselorId);
    Reservation findByMemberIdAndCounselorId(Long memberId, Long counselorId);


}

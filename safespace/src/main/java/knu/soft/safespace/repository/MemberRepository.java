package knu.soft.safespace.repository;

import knu.soft.safespace.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginIdAndPassword(String loginId, String password);


}

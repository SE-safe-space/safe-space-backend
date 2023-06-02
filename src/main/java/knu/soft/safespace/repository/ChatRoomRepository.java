package knu.soft.safespace.repository;

import knu.soft.safespace.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findByMember_Id(Long id);
    List<ChatRoom> findByCounselor_Id(Long id);

}

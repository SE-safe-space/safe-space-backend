package knu.soft.safespace.repository;

import knu.soft.safespace.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}

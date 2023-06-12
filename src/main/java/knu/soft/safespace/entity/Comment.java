package knu.soft.safespace.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long boardId;
    private Long userId;
    private String name;
    private String profileImage;
    private LocalDateTime createdAt;
    @Column(length = 1000)
    private String text;

}

package knu.soft.safespace.entity;

import knu.soft.safespace.dto.BoardResponseDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String title;
    private Integer hide;
    @Column(length = 1000)
    private String text;
    private String type;
    private LocalDateTime createdAt;


    public BoardResponseDto of() {
        return BoardResponseDto.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .hide(hide)
                .type(type)
                .createdAt(createdAt)
                .build();
    }
}

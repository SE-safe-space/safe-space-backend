package knu.soft.safespace.entity;

import knu.soft.safespace.dto.BoardResponseDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

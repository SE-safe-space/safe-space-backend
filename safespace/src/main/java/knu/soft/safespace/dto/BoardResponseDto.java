package knu.soft.safespace.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {

    private Long id;
    private String writer;
    private String title;
    private Integer hide;
    private String type;
    private LocalDateTime createdAt;


}

package knu.soft.safespace.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDto {
    private Long memberId;
    private Long counselorId;
    private String type;
    private String text;
}

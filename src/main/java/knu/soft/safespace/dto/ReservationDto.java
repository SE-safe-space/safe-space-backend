package knu.soft.safespace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long memberId;
    private Long counselorId;
    private String type;
    private String text;
}

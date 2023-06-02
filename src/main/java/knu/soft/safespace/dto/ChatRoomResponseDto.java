package knu.soft.safespace.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoomResponseDto {
    private Long chatRoomId;
    private String name;
    private String profileImage;
}

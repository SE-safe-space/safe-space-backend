package knu.soft.safespace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PasswordDto {
    private String originalPassword;
    private String newPassword;
    private Long userId;

}

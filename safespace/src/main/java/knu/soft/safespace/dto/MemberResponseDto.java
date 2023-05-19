package knu.soft.safespace.dto;

import knu.soft.safespace.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String email;
    private String password;
    private String name;
    private Integer sex;
    private String phoneNumber;
    private String profileImage;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .sex(member.getSex())
                .phoneNumber(member.getPhoneNumber())
                .profileImage(member.getProfileImage())
                .build();
    }
}

package knu.soft.safespace.dto;

import knu.soft.safespace.domain.CounselingType;
import knu.soft.safespace.domain.MemberType;
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
    private Long id;
    private String email;
    private String password;
    private String name;
    private Integer sex;
    private String phoneNumber;
    private String profileImage;
    private MemberType type;
    private CounselingType counselingType;
    private String introduction;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .type(member.getType())
                .counselingType(member.getCounselingType())
                .name(member.getName())
                .sex(member.getSex())
                .phoneNumber(member.getPhoneNumber())
                .profileImage(member.getProfileImage())
                .introduction(member.getIntroduction())
                .build();
    }

    public static MemberResponseDto toCounselor(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .sex(member.getSex())
                .counselingType(member.getCounselingType())
                .phoneNumber(member.getPhoneNumber())
                .profileImage(member.getProfileImage())
                .introduction(member.getIntroduction())
                .build();
    }
}

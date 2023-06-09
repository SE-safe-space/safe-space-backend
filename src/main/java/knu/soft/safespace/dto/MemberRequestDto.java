package knu.soft.safespace.dto;

import knu.soft.safespace.domain.Authority;
import knu.soft.safespace.domain.CounselingType;
import knu.soft.safespace.domain.MemberType;
import knu.soft.safespace.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {

    private String email;
    private String password;

    private MemberType type;
    private CounselingType counselingType;

    private String name;
    private Integer sex;
    private String phoneNumber;
    private String profileImage;
    private String introduction;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .type(type)
                .counselingType(counselingType)
                .name(name)
                .sex(sex)
                .introduction(introduction)
                .profileImage(profileImage)
                .phoneNumber(phoneNumber)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}

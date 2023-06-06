package knu.soft.safespace.entity;

import knu.soft.safespace.domain.Authority;
import knu.soft.safespace.domain.CounselingType;
import knu.soft.safespace.domain.MemberType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MemberType type;
    private CounselingType counselingType;

    private String email;
    private String password;
    private String name;
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    private Integer sex;
    private String phoneNumber;
    private String profileImage;
}

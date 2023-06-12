package knu.soft.safespace.entity;

import knu.soft.safespace.domain.ReservationState;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private Long counselorId;
    private String type;
    @Column(columnDefinition = "TEXT")
    private String text;
    private ReservationState accept;
}

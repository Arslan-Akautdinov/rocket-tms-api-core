package org.rocket.tms.api.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.rocket.tms.api.core.entities.base.EntityWithId;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "steps")
public class Step implements EntityWithId {
    @Id
    @Column(name = "step_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "case_id", insertable = false, updatable = false)
    private long caseId;

    @Column(name = "turn")
    private int order;

    private String content;
    private String expected;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private Case stepCase;
}

package org.rocket.tms.api.core.entities;

import jakarta.persistence.*;
import lombok.*;
import org.rocket.tms.api.core.entities.base.EntityWithId;

import java.util.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Project implements EntityWithId {
    @Id @GeneratedValue
    private long id;

    private String title;
    private String description;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Case> caseList = new ArrayList<>();
}

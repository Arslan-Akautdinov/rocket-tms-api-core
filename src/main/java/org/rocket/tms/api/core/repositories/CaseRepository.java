package org.rocket.tms.api.core.repositories;

import org.rocket.tms.api.core.entities.Case;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface CaseRepository extends CrudRepository<Case, Long> {
    List<Case> findByProjectId(long projectId, Pageable pageable);
}

package org.rocket.tms.api.core.services;

import lombok.extern.slf4j.Slf4j;
import org.rocket.tms.api.core.entities.Case;
import org.rocket.tms.api.core.repositories.CaseRepository;
import org.rocket.tms.api.core.services.base.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CaseService extends BaseCrudService<Case, CaseRepository> {
    @Autowired
    public CaseService(CaseRepository caseRepository) {
        super(caseRepository);
    }

    public List<Case> getCasesByProjectId(long projectId, int page, int size) {
        return repository.findByProjectId(projectId, PageRequest.of(page, size));
    }
}

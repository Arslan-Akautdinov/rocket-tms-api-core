package org.rocket.tms.api.core.services;

import org.rocket.tms.api.core.entities.Step;
import org.rocket.tms.api.core.repositories.StepRepository;
import org.rocket.tms.api.core.services.base.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService extends BaseCrudService<Step, StepRepository> {

    @Autowired
    public StepService(StepRepository repository) {
        super(repository);
    }
}

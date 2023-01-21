package org.rocket.tms.api.core.services;

import org.rocket.tms.api.core.entities.Case;
import org.rocket.tms.api.core.entities.Project;
import org.rocket.tms.api.core.repositories.ProjectRepository;
import org.rocket.tms.api.core.services.base.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService extends BaseCrudService<Project, ProjectRepository> {
    @Autowired
    public ProjectService(ProjectRepository repository) {
        super(repository);
    }
}

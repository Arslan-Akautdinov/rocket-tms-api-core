package org.rocket.tms.api.core.controllers;

import org.rocket.tms.api.core.controllers.base.CrudController;
import org.rocket.tms.api.core.entities.Project;
import org.rocket.tms.api.core.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController extends CrudController<Project, ProjectService> {
    @Autowired
    public ProjectController(ProjectService service) {
        super(service);
    }
}

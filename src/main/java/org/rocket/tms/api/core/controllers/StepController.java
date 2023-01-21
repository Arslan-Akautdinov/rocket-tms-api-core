package org.rocket.tms.api.core.controllers;


import org.rocket.tms.api.core.controllers.base.CrudController;
import org.rocket.tms.api.core.entities.Step;
import org.rocket.tms.api.core.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("step")
public class StepController extends CrudController<Step, StepService> {
    @Autowired
    public StepController(StepService service) {
        super(service);
    }
}

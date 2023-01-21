package org.rocket.tms.api.core.controllers;

import org.rocket.tms.api.core.controllers.base.CrudController;
import org.rocket.tms.api.core.entities.Case;
import org.rocket.tms.api.core.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("case")
public class CaseController extends CrudController<Case, CaseService> {
    @Autowired
    public CaseController(CaseService caseService) {
        super(caseService);
    }

    @GetMapping("select")
    public ResponseEntity<List<Case>> getCasesByProjectId(
            @RequestParam long projectId,
            @RequestParam int page,
            @RequestParam int size
    ) {
        return ResponseEntity.ok(service.getCasesByProjectId(projectId, page, size));
    }
}

package org.rocket.tms.api.core;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.rocket.tms.api.core.entities.Case;
import org.rocket.tms.api.core.entities.Project;
import org.rocket.tms.api.core.entities.Step;
import org.rocket.tms.api.core.repositories.CaseRepository;
import org.rocket.tms.api.core.repositories.ProjectRepository;
import org.rocket.tms.api.core.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Component
public class DataGenerator {

    private final EntityManager entityManager;
    private final ProjectRepository projectRepository;
    private final CaseRepository caseRepository;
    private final StepRepository stepRepository;

    @Autowired
    public DataGenerator(
            ProjectRepository projectRepository,
            CaseRepository caseRepository,
            StepRepository stepRepository,
            EntityManager entityManager) {
        this.entityManager = entityManager;
        this.projectRepository = projectRepository;
        this.caseRepository = caseRepository;
        this.stepRepository = stepRepository;
    }

    @PostConstruct
    public void onPostConstruct() {
        createProjects();
        createCases();
        createSteps();
    }

    private void createProjects() {
        List<Project> projectList = new ArrayList<>();
        for(int i = 1; i < 10; i ++) {
            var project = new Project();
            project.setTitle("Project with id " + i);
            project.setDescription("Description for project with id " + i);
            projectList.add(project);
        }
        projectRepository.saveAll(projectList);
    }

    private void createCases() {
        projectRepository.findAll().forEach(project -> {
            List<Case> caseList = new ArrayList<>();
            for(int i = 1; i < 10; i ++) {
                var caseItem = new Case();
                caseItem.setTitle("Title for case with id " + i + " for project " + project.getId());
                caseItem.setSummary("Summary for case with id " + i + " for project " + project.getId());
                caseItem.setCreatedAt(LocalDateTime.now());
                caseItem.setUpdatedAt(LocalDateTime.now());
                caseItem.setCreatedBy(1);
                caseItem.setUpdatedBy(1);
                caseItem.setProjectId(project.getId());
                caseList.add(caseItem);
            }
            caseRepository.saveAll(caseList);
        });
    }

    private void createSteps() {
        caseRepository.findAll().forEach(caseItem -> {
            List<Step> stepList = new ArrayList<>();
            for(int i = 1; i < 10; i ++) {
                var step = new Step();
                step.setContent("Content");
                step.setExpected("Expected");
                step.setStepCase(caseItem);
                step.setOrder(1);
            }
            stepRepository.saveAll(stepList);
        });
    }
}

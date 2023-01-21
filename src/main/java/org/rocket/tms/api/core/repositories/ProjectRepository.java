package org.rocket.tms.api.core.repositories;

import org.rocket.tms.api.core.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}

package com.cristianortega.portfolio.domain.repository;

import com.cristianortega.portfolio.domain.ProjectDomain;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProjectDomainRepository {

    Optional<ProjectDomain> findById(Long id);

    List<ProjectDomain> getAll();

    ProjectDomain save(ProjectDomain projectDomain);

    void delete(Long id);

    Optional<List<ProjectDomain>> findImportantTechnologies(boolean important);

    Optional<List<ProjectDomain>> findByPage(Pageable page);

    Optional<List<ProjectDomain>> findAllByLaboratoryTechnologiesName(Pageable page, String name);

    Long count();

}

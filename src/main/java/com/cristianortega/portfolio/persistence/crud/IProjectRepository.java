package com.cristianortega.portfolio.persistence.crud;

import com.cristianortega.portfolio.persistence.entity.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {

    Optional<List<Project>> findProjectByImportantOrderByProjectId(boolean important);

    Optional<List<Project>> findAllByProjectTechnologiesName(Pageable page, String name);

    Optional<List<Project>> findAllBy(Pageable page);

}

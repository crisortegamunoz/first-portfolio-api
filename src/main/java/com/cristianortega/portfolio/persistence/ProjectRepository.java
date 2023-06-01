package com.cristianortega.portfolio.persistence;

import com.cristianortega.portfolio.domain.ProjectDomain;
import com.cristianortega.portfolio.domain.repository.IProjectDomainRepository;
import com.cristianortega.portfolio.persistence.crud.IProjectRepository;
import com.cristianortega.portfolio.persistence.entity.Project;
import com.cristianortega.portfolio.persistence.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository implements IProjectDomainRepository {

    @Autowired
    private IProjectRepository projectRepository;
    @Autowired
    private ProjectMapper mapper;

    @Override
    public Optional<ProjectDomain> findById(Long id) {
        return projectRepository.findById(id).map(project -> mapper.toProjectDomain(project));
    }

    @Override
    public List<ProjectDomain> getAll() {
        List<Project> projects = (List<Project>) projectRepository.findAll();
        return mapper.toProjectsDomain(projects);
    }

    @Override
    public ProjectDomain save(ProjectDomain projectDomain) {
        return mapper.toProjectDomain(projectRepository.save(mapper.toProject(projectDomain)));
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<List<ProjectDomain>> findImportantTechnologies(boolean important) {
        Optional<List<Project>> projects = projectRepository.findProjectByImportantOrderByProjectId(important);
        return projects.map(projs -> mapper.toProjectsDomain(projs));
    }

    @Override
    public Optional<List<ProjectDomain>> findByPage(Pageable page) {
        Optional<List<Project>> projects = projectRepository.findAllBy(page);
        return projects.map(projs -> mapper.toProjectsDomain(projs));
    }

    @Override
    public Optional<List<ProjectDomain>> findAllByLaboratoryTechnologiesName(Pageable page, String name) {
        Optional<List<Project>> projects = projectRepository.findAllByProjectTechnologiesName(page, name);
        return projects.map(pro -> mapper.toProjectsDomain(pro));
    }

    @Override
    public Long count() {
        return projectRepository.count();
    }

}

package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.ProjectDomain;
import com.cristianortega.portfolio.domain.repository.IProjectDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private IProjectDomainRepository projectDomainRepository;

    public Optional<ProjectDomain> findById(Long id) {
        return projectDomainRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<ProjectDomain> getAll() {
        return projectDomainRepository.getAll();
    }

    public ProjectDomain save(ProjectDomain projectDomain) {
        return projectDomainRepository.save(projectDomain);
    }

    public ProjectDomain update(Long id, ProjectDomain projectDomain) {
        return findById(id).map(project -> {
            project.setName(projectDomain.getName());
            project.setAboutProjectOne(projectDomain.getAboutProjectOne());
            project.setAboutProjectTwo(projectDomain.getAboutProjectTwo());
            project.setCategory(projectDomain.getCategory());
            project.setPosition(projectDomain.getPosition());
            project.setPriority(projectDomain.getPriority());
            project.setImage(projectDomain.getImage());
            project.setFileRef(projectDomain.getFileRef());
            project.setTechnologyList(projectDomain.getTechnologyList());
            return projectDomainRepository.save(project);
        }).orElseThrow();
    }

    public boolean delete(Long id) {
        return findById(id).map(project -> {
            projectDomainRepository.delete(id);
            return true;
        }).orElse(false);
    }

    @Transactional(readOnly = true)
    public Optional<List<ProjectDomain>> findImportantProjects(boolean important) {
        return projectDomainRepository.findImportantTechnologies(important);
    }

    @Transactional(readOnly = true)
    public Optional<List<ProjectDomain>> findByPage(Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("projectId").descending());
        return projectDomainRepository.findByPage(page);
    }

    @Transactional(readOnly = true)
    public Optional<List<ProjectDomain>> findByTechnologyName(Integer pageNumber, Integer size, String name) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("projectId").descending());
        return projectDomainRepository.findAllByLaboratoryTechnologiesName(page, name);
    }

    public Long count() {
        return projectDomainRepository.count();
    }

}

package com.cristianortega.portfolio.persistence.mapper;

import com.cristianortega.portfolio.domain.ProjectDomain;
import com.cristianortega.portfolio.persistence.entity.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TechnologyMapper.class})
public interface ProjectMapper {

    @Mappings({
            @Mapping(source = "projectId", target = "id"),
            @Mapping(source = "projectName", target = "name"),
            @Mapping(source = "businessCategory", target = "category"),
            @Mapping(source = "role", target = "position"),
            @Mapping(source = "firstDescription", target = "aboutProjectOne"),
            @Mapping(source = "secondDescription", target = "aboutProjectTwo"),
            @Mapping(source = "important", target = "priority"),
            @Mapping(source = "imagePath", target = "image"),
            @Mapping(source = "fileReference", target = "fileRef"),
            @Mapping(source = "creationDate", target = "creation"),
            @Mapping(source = "projectTechnologies", target = "technologyList")
    })
    ProjectDomain toProjectDomain(Project project);

    List<ProjectDomain> toProjectsDomain(List<Project> project);

    @InheritInverseConfiguration
    Project toProject(ProjectDomain projectDomain);

}

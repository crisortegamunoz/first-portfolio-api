package com.cristianortega.portfolio.persistence.mapper;

import com.cristianortega.portfolio.domain.LaboratoryDomain;
import com.cristianortega.portfolio.persistence.entity.Laboratory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TechnologyMapper.class})
public interface LaboratoryMapper {

    @Mappings({
            @Mapping(source = "laboratoryId", target = "id"),
            @Mapping(source = "laboratoryName", target = "name"),
            @Mapping(source = "description", target = "laboratoryDescription"),
            @Mapping(source = "demoUrl", target = "urlDemo"),
            @Mapping(source = "repositoryUrl", target = "urlRepo"),
            @Mapping(source = "imagePath", target = "image"),
            @Mapping(source = "fileReference", target = "fileRef"),
            @Mapping(source = "creationDate", target = "creation"),
            @Mapping(source = "laboratoryTechnologies", target = "technologyList")
    })
    LaboratoryDomain toLaboratoryDomain(Laboratory laboratory);

    List<LaboratoryDomain> toLaboratoriesDomain(List<Laboratory> laboratories);

    @InheritInverseConfiguration
    Laboratory toLaboratory(LaboratoryDomain laboratoryDomain);

}

package com.cristianortega.portfolio.persistence.mapper;

import com.cristianortega.portfolio.domain.TechnologyDomain;
import com.cristianortega.portfolio.persistence.entity.Technology;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    @Mappings({
            @Mapping(source = "technologyId", target = "id"),
            @Mapping(source = "name", target = "technologyName"),
            @Mapping(source = "categoryName", target = "category"),
            @Mapping(source = "important", target = "priority"),
            @Mapping(source = "imagePath", target = "image"),
            @Mapping(source = "fileReference", target = "fileRef")
    })
    TechnologyDomain toTechnologyDomain(Technology technology);

    List<TechnologyDomain> toTechnologiesDomain(List<Technology> technologies);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "laboratories", ignore = true),
            @Mapping(target = "projects", ignore = true)
    })
    Technology toTechnology(TechnologyDomain technologyDomain);

}

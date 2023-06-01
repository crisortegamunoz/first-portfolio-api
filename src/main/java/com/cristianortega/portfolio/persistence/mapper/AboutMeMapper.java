package com.cristianortega.portfolio.persistence.mapper;

import com.cristianortega.portfolio.domain.AboutMeDomain;
import com.cristianortega.portfolio.persistence.entity.AboutMe;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AboutMeMapper {

    @Mappings({
            @Mapping(source = "aboutMeId", target = "id"),
            @Mapping(source = "title", target = "descriptionTitle"),
            @Mapping(source = "firstDescription", target = "descriptionOne"),
            @Mapping(source = "secondDescription", target = "descriptionTwo"),
            @Mapping(source = "thirdDescription", target = "descriptionThree"),
    })
    AboutMeDomain toAboutMeDomain(AboutMe aboutMe);

    List<AboutMeDomain> toAboutMes(List<AboutMe> aboutMeList);

    @InheritInverseConfiguration
    AboutMe toAboutMe(AboutMeDomain aboutMeDomain);
}

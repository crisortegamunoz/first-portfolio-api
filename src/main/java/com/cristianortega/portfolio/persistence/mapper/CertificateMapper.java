package com.cristianortega.portfolio.persistence.mapper;

import com.cristianortega.portfolio.domain.CertificateDomain;
import com.cristianortega.portfolio.persistence.entity.Certificate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

    @Mappings({
            @Mapping(source = "certificateId", target = "id"),
            @Mapping(source = "courseName", target = "course"),
            @Mapping(source = "certificateCode", target = "code"),
            @Mapping(source = "categoryName", target = "category"),
            @Mapping(source = "educationalEntity", target = "learningPlatform"),
            @Mapping(source = "approvedDate", target = "approved"),
            @Mapping(source = "imagePath", target = "image"),
            @Mapping(source = "fileReference", target = "fileRef")
    })
    CertificateDomain toCertificateDomain(Certificate certificate);

    List<CertificateDomain> toCertificatesDomain(List<Certificate> certificates);

    @InheritInverseConfiguration
    Certificate toCertificate(CertificateDomain certificateDomain);

}

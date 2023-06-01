package com.cristianortega.portfolio.domain.repository;

import com.cristianortega.portfolio.domain.LaboratoryDomain;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ILaboratoryDomainRepository {

    Optional<LaboratoryDomain> findById(Long id);

    List<LaboratoryDomain> getAll();

    LaboratoryDomain save(LaboratoryDomain laboratoryDomain);

    void delete(Long id);

    Optional<List<LaboratoryDomain>> findByPage(Pageable page);

    Optional<List<LaboratoryDomain>> findAllByLaboratoryTechnologiesName(Pageable page, String name);

    Long count();

}

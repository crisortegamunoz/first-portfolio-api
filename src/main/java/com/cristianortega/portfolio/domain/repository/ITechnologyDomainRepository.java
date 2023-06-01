package com.cristianortega.portfolio.domain.repository;

import com.cristianortega.portfolio.domain.TechnologyDomain;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITechnologyDomainRepository {

    Optional<TechnologyDomain> findById(Long id);

    List<TechnologyDomain> getAll();

    TechnologyDomain save(TechnologyDomain technologyDomain);

    void delete(Long id);

    Optional<List<TechnologyDomain>> findImportantTechnologies(boolean important);

    Optional<List<TechnologyDomain>> findByPage(Pageable page);

    Long count();

}

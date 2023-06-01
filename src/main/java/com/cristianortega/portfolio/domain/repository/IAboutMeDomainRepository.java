package com.cristianortega.portfolio.domain.repository;

import com.cristianortega.portfolio.domain.AboutMeDomain;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAboutMeDomainRepository {

    Optional<AboutMeDomain> findById(Long id);

    List<AboutMeDomain> getAll();

    AboutMeDomain save(AboutMeDomain aboutMeDomain);

    void delete(Long id);

    Optional<List<AboutMeDomain>> findByPage(Pageable page);

    Long count();

}

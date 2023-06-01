package com.cristianortega.portfolio.domain.repository;

import com.cristianortega.portfolio.domain.CertificateDomain;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICertificateDomainRepository {

    Optional<CertificateDomain> findById(Long id);

    List<CertificateDomain> getAll();

    CertificateDomain save(CertificateDomain certificateDomain);

    void delete(Long id);

    Optional<List<CertificateDomain>> findByPage(Pageable page);

    Long count();

}

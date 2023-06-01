package com.cristianortega.portfolio.persistence.crud;

import com.cristianortega.portfolio.persistence.entity.Certificate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ICertificateRepository extends PagingAndSortingRepository<Certificate, Long> {

    Optional<List<Certificate>> findAllBy(Pageable page);

}

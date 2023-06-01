package com.cristianortega.portfolio.persistence.crud;

import com.cristianortega.portfolio.persistence.entity.Laboratory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ILaboratoryRepository extends PagingAndSortingRepository<Laboratory, Long> {

    Optional<List<Laboratory>> findAllBy(Pageable page);

    Optional<List<Laboratory>> findAllByLaboratoryTechnologiesName(Pageable page, String name);

}

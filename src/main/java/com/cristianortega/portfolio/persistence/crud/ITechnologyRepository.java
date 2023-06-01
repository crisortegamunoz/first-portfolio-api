package com.cristianortega.portfolio.persistence.crud;

import com.cristianortega.portfolio.persistence.entity.Technology;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ITechnologyRepository extends PagingAndSortingRepository<Technology, Long> {

    Optional<List<Technology>> findTechnologiesByImportantOrderByTechnologyIdAsc(boolean important);

    Optional<List<Technology>> findAllBy(Pageable page);

}

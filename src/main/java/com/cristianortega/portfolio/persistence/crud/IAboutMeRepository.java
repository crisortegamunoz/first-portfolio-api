package com.cristianortega.portfolio.persistence.crud;

import com.cristianortega.portfolio.persistence.entity.AboutMe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IAboutMeRepository extends PagingAndSortingRepository<AboutMe, Long> {

    Optional<List<AboutMe>> findAllBy(Pageable page);

}

package com.cristianortega.portfolio.persistence;

import com.cristianortega.portfolio.domain.TechnologyDomain;
import com.cristianortega.portfolio.domain.repository.ITechnologyDomainRepository;
import com.cristianortega.portfolio.persistence.crud.ITechnologyRepository;
import com.cristianortega.portfolio.persistence.entity.Technology;
import com.cristianortega.portfolio.persistence.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TechnologyRepository implements ITechnologyDomainRepository {

    @Autowired
    private ITechnologyRepository technologyRepository;
    @Autowired
    private TechnologyMapper mapper;

    @Override
    public Optional<TechnologyDomain> findById(Long id) {
        return technologyRepository.findById(id).map(technology -> mapper.toTechnologyDomain(technology));
    }

    @Override
    public List<TechnologyDomain> getAll() {
        List<Technology> technologies = (List<Technology>) technologyRepository.findAll();
        return mapper.toTechnologiesDomain(technologies);
    }

    @Override
    public TechnologyDomain save(TechnologyDomain technologyDomain) {
        return mapper.toTechnologyDomain(technologyRepository.save(mapper.toTechnology(technologyDomain)));
    }

    @Override
    public void delete(Long id) {
        technologyRepository.deleteById(id);
    }

    @Override
    public Optional<List<TechnologyDomain>> findImportantTechnologies(boolean important) {
        Optional<List<Technology>> technologies = technologyRepository.findTechnologiesByImportantOrderByTechnologyIdAsc(important);
        return technologies.map(techs -> mapper.toTechnologiesDomain(techs));
    }

    @Override
    public Optional<List<TechnologyDomain>> findByPage(Pageable page) {
        Optional<List<Technology>> technologies = technologyRepository.findAllBy(page);
        return technologies.map(techs -> mapper.toTechnologiesDomain(techs));
    }

    @Override
    public Long count() {
        return technologyRepository.count();
    }


}

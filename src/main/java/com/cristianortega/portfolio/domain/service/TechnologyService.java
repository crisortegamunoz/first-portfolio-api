package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.TechnologyDomain;
import com.cristianortega.portfolio.domain.repository.ITechnologyDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {

    @Autowired
    private ITechnologyDomainRepository technologyDomainRepository;

    public Optional<TechnologyDomain> findById(Long id) {
        return technologyDomainRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<TechnologyDomain> getAll() {
        return technologyDomainRepository.getAll();
    }

    public TechnologyDomain save(TechnologyDomain technologyDomain) {
        return technologyDomainRepository.save(technologyDomain);
    }

    public TechnologyDomain update(Long id, TechnologyDomain technologyDomain) {
        return findById(id).map(technology -> {
            technology.setTechnologyName(technologyDomain.getTechnologyName());
            technology.setCategory(technologyDomain.getCategory());
            technology.setPriority(technologyDomain.getPriority());
            technology.setImage(technologyDomain.getImage());
            technology.setFileRef(technologyDomain.getFileRef());
            return technologyDomainRepository.save(technology);
        }).orElseThrow();
    }

    public boolean delete(Long id) {
        return findById(id).map(technology -> {
            technologyDomainRepository.delete(id);
            return true;
        }).orElse(false);
    }

    @Transactional(readOnly = true)
    public Optional<List<TechnologyDomain>> findImportantTechnologies(boolean important) {
        return technologyDomainRepository.findImportantTechnologies(important);
    }

    @Transactional(readOnly = true)
    public Optional<List<TechnologyDomain>> findByPage(Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("technologyId").descending());
        return technologyDomainRepository.findByPage(page);
    }

    public Long count() {
        return technologyDomainRepository.count();
    }

}

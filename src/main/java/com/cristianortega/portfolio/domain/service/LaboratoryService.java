package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.LaboratoryDomain;
import com.cristianortega.portfolio.domain.repository.ILaboratoryDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryService {

    @Autowired
    private ILaboratoryDomainRepository laboratoryDomainRepository;

    public Optional<LaboratoryDomain> findById(Long id) {
        return laboratoryDomainRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<LaboratoryDomain> getAll() {
        return laboratoryDomainRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Optional<List<LaboratoryDomain>> findByTechnologyName(Integer pageNumber, Integer size, String name) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("laboratoryId").descending());
        return laboratoryDomainRepository.findAllByLaboratoryTechnologiesName(page, name);
    }

    @Transactional(readOnly = true)
    public Optional<List<LaboratoryDomain>> findByPage(Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("laboratoryId").descending());
        return laboratoryDomainRepository.findByPage(page);
    }

    public LaboratoryDomain save(LaboratoryDomain laboratoryDomain) {
        return laboratoryDomainRepository.save(laboratoryDomain);
    }

    public LaboratoryDomain update(Long id, LaboratoryDomain laboratoryDomain) {
        return findById(id).map(laboratory -> {
            laboratory.setName(laboratoryDomain.getName());
            laboratory.setLaboratoryDescription(laboratoryDomain.getLaboratoryDescription());
            laboratory.setTechnologyList(laboratoryDomain.getTechnologyList());
            laboratory.setUrlRepo(laboratoryDomain.getUrlRepo());
            laboratory.setUrlDemo(laboratoryDomain.getUrlDemo());
            laboratory.setImage(laboratoryDomain.getImage());
            laboratory.setFileRef(laboratoryDomain.getFileRef());
            return laboratoryDomainRepository.save(laboratory);
        }).orElseThrow();
    }

    public boolean delete(Long id) {
        return findById(id).map(laboratory -> {
            laboratoryDomainRepository.delete(id);
            return true;
        }).orElse(false);
    }

    public Long count() {
        return laboratoryDomainRepository.count();
    }

}

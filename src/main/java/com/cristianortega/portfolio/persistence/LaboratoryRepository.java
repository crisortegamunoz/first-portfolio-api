package com.cristianortega.portfolio.persistence;

import com.cristianortega.portfolio.domain.LaboratoryDomain;
import com.cristianortega.portfolio.domain.repository.ILaboratoryDomainRepository;
import com.cristianortega.portfolio.persistence.crud.ILaboratoryRepository;
import com.cristianortega.portfolio.persistence.entity.Laboratory;
import com.cristianortega.portfolio.persistence.mapper.LaboratoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LaboratoryRepository implements ILaboratoryDomainRepository {

    @Autowired
    private ILaboratoryRepository laboratoryRepository;
    @Autowired
    private LaboratoryMapper mapper;

    @Override
    public Optional<LaboratoryDomain> findById(Long id) {
        return laboratoryRepository.findById(id).map(laboratory -> mapper.toLaboratoryDomain(laboratory));
    }

    @Override
    public List<LaboratoryDomain> getAll() {
        List<Laboratory> laboratories = (List<Laboratory>) laboratoryRepository.findAll();
        return mapper.toLaboratoriesDomain(laboratories);
    }

    @Override
    public LaboratoryDomain save(LaboratoryDomain laboratoryDomain) {
        return mapper.toLaboratoryDomain(laboratoryRepository.save(mapper.toLaboratory(laboratoryDomain)));
    }

    @Override
    public void delete(Long id) {
        laboratoryRepository.deleteById(id);
    }

    @Override
    public Optional<List<LaboratoryDomain>> findByPage(Pageable page) {
        Optional<List<Laboratory>> laboratories = laboratoryRepository.findAllBy(page);
        return laboratories.map(labs -> mapper.toLaboratoriesDomain(labs));
    }

    @Override
    public Optional<List<LaboratoryDomain>> findAllByLaboratoryTechnologiesName(Pageable page, String name) {
        Optional<List<Laboratory>> laboratories = laboratoryRepository.findAllByLaboratoryTechnologiesName(page, name);
        return laboratories.map(labs -> mapper.toLaboratoriesDomain(labs));
    }

    @Override
    public Long count() {
        return laboratoryRepository.count();
    }


}

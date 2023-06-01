package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.AboutMeDomain;
import com.cristianortega.portfolio.domain.repository.IAboutMeDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AboutMeService {

    @Autowired
    private IAboutMeDomainRepository aboutMeDomainRepository;

    public Optional<AboutMeDomain> findById(Long id) {
        return aboutMeDomainRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<AboutMeDomain> getAll() {
        return aboutMeDomainRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Optional<List<AboutMeDomain>> findByPage(Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("aboutMeId").ascending());
        return aboutMeDomainRepository.findByPage(page);
    }

    public AboutMeDomain save(AboutMeDomain aboutMeDomain) {
        return aboutMeDomainRepository.save(aboutMeDomain);
    }

    public AboutMeDomain update(Long id, AboutMeDomain aboutMeDomain) {
        return findById(id).map(aboutMe -> {
            aboutMe.setDescriptionTitle(aboutMeDomain.getDescriptionTitle());
            aboutMe.setDescriptionOne(aboutMeDomain.getDescriptionOne());
            aboutMe.setDescriptionTwo(aboutMeDomain.getDescriptionTwo());
            aboutMe.setDescriptionThree(aboutMeDomain.getDescriptionThree());
            return aboutMeDomainRepository.save(aboutMe);
        }).orElseThrow();
    }

    public boolean delete(Long id) {
        return findById(id).map(aboutMe -> {
            aboutMeDomainRepository.delete(id);
            return true;
        }).orElse(false);
    }

    public Long count() {
        return aboutMeDomainRepository.count();
    }

}

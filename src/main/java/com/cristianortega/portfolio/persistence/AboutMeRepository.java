package com.cristianortega.portfolio.persistence;

import com.cristianortega.portfolio.domain.AboutMeDomain;
import com.cristianortega.portfolio.domain.repository.IAboutMeDomainRepository;
import com.cristianortega.portfolio.persistence.crud.IAboutMeRepository;
import com.cristianortega.portfolio.persistence.entity.AboutMe;
import com.cristianortega.portfolio.persistence.mapper.AboutMeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AboutMeRepository implements IAboutMeDomainRepository {

    @Autowired
    private IAboutMeRepository aboutMeRepository;
    @Autowired
    private AboutMeMapper mapper;

    @Override
    public Optional<AboutMeDomain> findById(Long id) {
        return aboutMeRepository.findById(id).map(about -> mapper.toAboutMeDomain(about));
    }

    @Override
    public List<AboutMeDomain> getAll() {
        List<AboutMe> aboutMes = (List<AboutMe>) aboutMeRepository.findAll();
        return mapper.toAboutMes(aboutMes);
    }

    @Override
    public AboutMeDomain save(AboutMeDomain aboutMeDomain) {
        return mapper.toAboutMeDomain(aboutMeRepository.save(mapper.toAboutMe(aboutMeDomain)));
    }

    @Override
    public void delete(Long id) {
        aboutMeRepository.deleteById(id);
    }

    @Override
    public Optional<List<AboutMeDomain>> findByPage(Pageable page) {
        Optional<List<AboutMe>> aboutMeList = aboutMeRepository.findAllBy(page);
        return aboutMeList.map(aboutMes -> mapper.toAboutMes(aboutMes));
    }

    @Override
    public Long count() {
        return aboutMeRepository.count();
    }

}

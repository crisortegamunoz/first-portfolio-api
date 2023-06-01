package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.CertificateDomain;
import com.cristianortega.portfolio.domain.repository.ICertificateDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private ICertificateDomainRepository certificateDomainRepository;

    public Optional<CertificateDomain> findById(Long id) {
        return certificateDomainRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<CertificateDomain> getAll() {
        return certificateDomainRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Optional<List<CertificateDomain>> findByPage(Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("certificateId").descending());
        return certificateDomainRepository.findByPage(page);
    }

    public CertificateDomain save(CertificateDomain certificateDomain) {
        return certificateDomainRepository.save(certificateDomain);
    }

    public CertificateDomain update(Long id, CertificateDomain certificateDomain) {
        return findById(id).map(certificate -> {
            certificate.setCourse(certificateDomain.getCourse());
            certificate.setCode(certificateDomain.getCode());
            certificate.setCategory(certificateDomain.getCategory());
            certificate.setApproved(certificateDomain.getApproved());
            certificate.setLearningPlatform(certificateDomain.getLearningPlatform());
            certificate.setImage(certificateDomain.getImage());
            certificate.setFileRef(certificateDomain.getFileRef());
            return certificateDomainRepository.save(certificate);
        }).orElseThrow();
    }

    public boolean delete(Long id) {
        return findById(id).map(certificate -> {
            certificateDomainRepository.delete(id);
            return true;
        }).orElse(false);
    }

    public Long count() {
        return certificateDomainRepository.count();
    }

}

package com.cristianortega.portfolio.persistence;

import com.cristianortega.portfolio.domain.CertificateDomain;
import com.cristianortega.portfolio.domain.repository.ICertificateDomainRepository;
import com.cristianortega.portfolio.persistence.crud.ICertificateRepository;
import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.persistence.mapper.CertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CertificateRepository implements ICertificateDomainRepository {

    @Autowired
    private ICertificateRepository certificateRepository;
    @Autowired
    private CertificateMapper mapper;

    @Override
    public Optional<CertificateDomain> findById(Long id) {
        return certificateRepository.findById(id).map(certificate -> mapper.toCertificateDomain(certificate));
    }

    @Override
    public List<CertificateDomain> getAll() {
        List<Certificate> certificates = (List<Certificate>) certificateRepository.findAll();
        return mapper.toCertificatesDomain(certificates);
    }

    @Override
    public CertificateDomain save(CertificateDomain certificateDomain) {
        return mapper.toCertificateDomain(certificateRepository.save(mapper.toCertificate(certificateDomain)));
    }

    @Override
    public void delete(Long id) {
        certificateRepository.deleteById(id);
    }

    @Override
    public Optional<List<CertificateDomain>> findByPage(Pageable page) {
        Optional<List<Certificate>> certificates = certificateRepository.findAllBy(page);
        return certificates.map(certs -> mapper.toCertificatesDomain(certs));
    }

    public Long count() {
        return certificateRepository.count();
    }

}

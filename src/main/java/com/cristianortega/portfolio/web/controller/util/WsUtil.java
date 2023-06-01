package com.cristianortega.portfolio.web.controller.util;

import com.cristianortega.portfolio.domain.*;
import com.cristianortega.portfolio.domain.dto.exception.ExceptionResponse;
import com.cristianortega.portfolio.domain.dto.search.Pagination;
import com.cristianortega.portfolio.domain.dto.search.SearchResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class WsUtil {

    private final String PAGE_NUMBER_IS_NULL = "Page number cannot be null";
    private final String PAGE_NUMBER_LESS_THAN_ZERO = "Page number value cannot be 0 or less";
    private final String PAGE_SIZE_IS_NULL = "Page size cannot be null";
    private final String PAGE_SIZE_LESS_THAN_ZERO = "Page size value cannot be 0 or less";

    public Pagination loadPagination(Long pageNumber, Long pageSize, Long totalRecords) {
        Pagination pagination = new Pagination();
        pagination.setPageNumber(pageNumber);
        pagination.setPageSize(pageSize);
        pagination.setTotalRecords(totalRecords);
        return pagination;
    }

    public ResponseEntity<ExceptionResponse> createIllegalArgumentResponse(IllegalArgumentException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void validatePaginationParameters(Long pageNumber, Long pageSize) throws IllegalArgumentException {

        if (pageNumber == null) {
            throw new IllegalArgumentException(PAGE_NUMBER_IS_NULL);
        }

        if (pageSize == null) {
            throw new IllegalArgumentException(PAGE_SIZE_IS_NULL);
        }

        if (pageNumber <= 0) {
            throw new IllegalArgumentException(PAGE_NUMBER_LESS_THAN_ZERO);
        }

        if (pageSize <= 0) {
            throw new IllegalArgumentException(PAGE_SIZE_LESS_THAN_ZERO);
        }

    }

    protected SearchResults<AboutMeDomain> loadResultMe(List<AboutMeDomain> aboutmeList, Long pageNumber, Long pageSize, Long totalRecords) {
        SearchResults<AboutMeDomain> results = new SearchResults<>();
        results.setPagination(loadPagination(pageNumber, pageSize, totalRecords));
        results.setSearchResults(aboutmeList);
        return results;
    }

    protected SearchResults<ProjectDomain> loadResultPro(List<ProjectDomain> projects, Long pageNumber, Long pageSize, Long totalRecords) {
        SearchResults<ProjectDomain> results = new SearchResults<>();
        results.setPagination(loadPagination(pageNumber, pageSize, totalRecords));
        results.setSearchResults(projects);
        return results;
    }

    protected SearchResults<TechnologyDomain> loadResultTech(List<TechnologyDomain> technologies, Long pageNumber, Long pageSize, Long totalRecords) {
        SearchResults<TechnologyDomain> results = new SearchResults<>();
        results.setPagination(loadPagination(pageNumber, pageSize, totalRecords));
        results.setSearchResults(technologies);
        return results;
    }

    protected SearchResults<CertificateDomain> loadResultCer(List<CertificateDomain> certificates, Long pageNumber, Long pageSize, Long totalRecords) {
        SearchResults<CertificateDomain> results = new SearchResults<>();
        results.setPagination(loadPagination(pageNumber, pageSize, totalRecords));
        results.setSearchResults(certificates);
        return results;
    }

    protected SearchResults<LaboratoryDomain> loadResultLab(List<LaboratoryDomain> laboratories, Long pageNumber, Long pageSize, Long totalRecords) {
        SearchResults<LaboratoryDomain> results = new SearchResults<>();
        results.setPagination(loadPagination(pageNumber, pageSize, totalRecords));
        results.setSearchResults(laboratories);
        return results;
    }

}

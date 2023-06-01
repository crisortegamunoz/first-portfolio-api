package com.cristianortega.portfolio.domain.dto.search;

public class Pagination {

    private Long pageSize;
    private Long totalRecords;
    private Long pageNumber;
    private Long lastPageNumber;

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getLastPageNumber() {
        return lastPageNumber;
    }

    public void setLastPageNumber(Long lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }
}

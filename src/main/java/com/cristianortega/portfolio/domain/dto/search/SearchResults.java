package com.cristianortega.portfolio.domain.dto.search;

import java.util.List;

public class SearchResults<T> {

    private List<T> searchResults;
    private Pagination pagination;
    private PageLink pageLink;

    public List<T> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<T> searchResultList) {
        this.searchResults = searchResultList;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public PageLink getPageLink() {
        return pageLink;
    }

    public void setPageLink(PageLink pageLink) {
        this.pageLink = pageLink;
    }
}

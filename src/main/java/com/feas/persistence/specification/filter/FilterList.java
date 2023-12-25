package com.feas.persistence.specification.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class FilterList {

    private List<Filter> filtersList;
    @JsonIgnore
    private  boolean applyAndOperation = false;

    public FilterList() {
    }

    public void setFiltersListCriteria(List<Filter> filtersList , boolean applyAndOperation) {
        this.filtersList = filtersList;
        this.applyAndOperation = applyAndOperation ;
    }

    public void setFiltersList(List<Filter> filtersList) {
        this.filtersList = filtersList;
    }

    public List<Filter> getNonNullFilters() {
        if (filtersList != null)
            return filtersList;
        filtersList = new ArrayList<>();
        return filtersList;
    }

    public List<Filter> getFiltersList() {
        return filtersList;
    }

    public boolean applyAndOperation() {
        return applyAndOperation;
    }

    public void setApplyAndOperation(boolean applyAndOperation) {
        this.applyAndOperation = applyAndOperation;
    }

}

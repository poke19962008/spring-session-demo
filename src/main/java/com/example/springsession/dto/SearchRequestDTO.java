package com.example.springsession.dto;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
public class SearchRequestDTO {

    private String searchTerm;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "SearchRequestDTO{" + "searchTerm='" + searchTerm + '\'' + '}';
    }
}

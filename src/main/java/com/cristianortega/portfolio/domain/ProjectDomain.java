package com.cristianortega.portfolio.domain;

import java.time.LocalDateTime;
import java.util.Set;

public class ProjectDomain {

    private Long id;
    private String name;
    private String category;
    private String position;
    private String aboutProjectOne;
    private String aboutProjectTwo;
    private Boolean priority;
    private String fileRef;
    private String image;
    private LocalDateTime creation;
    private Set<TechnologyDomain> technologyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAboutProjectOne() {
        return aboutProjectOne;
    }

    public void setAboutProjectOne(String aboutProjectOne) {
        this.aboutProjectOne = aboutProjectOne;
    }

    public String getAboutProjectTwo() {
        return aboutProjectTwo;
    }

    public void setAboutProjectTwo(String aboutProjectTwo) {
        this.aboutProjectTwo = aboutProjectTwo;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public String getFileRef() {
        return fileRef;
    }

    public void setFileRef(String fileRef) {
        this.fileRef = fileRef;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public Set<TechnologyDomain> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(Set<TechnologyDomain> technologyList) {
        this.technologyList = technologyList;
    }
}

package com.cristianortega.portfolio.domain;

import java.time.LocalDateTime;
import java.util.Set;


public class LaboratoryDomain {

    private Long id;
    private String name;
    private String laboratoryDescription;
    private String urlDemo;
    private String urlRepo;
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

    public String getLaboratoryDescription() {
        return laboratoryDescription;
    }

    public void setLaboratoryDescription(String laboratoryDescription) {
        this.laboratoryDescription = laboratoryDescription;
    }

    public String getUrlDemo() {
        return urlDemo;
    }

    public void setUrlDemo(String urlDemo) {
        this.urlDemo = urlDemo;
    }

    public String getUrlRepo() {
        return urlRepo;
    }

    public void setUrlRepo(String urlRepo) {
        this.urlRepo = urlRepo;
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

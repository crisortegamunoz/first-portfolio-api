package com.cristianortega.portfolio.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laboratory_id")
    private Long laboratoryId;

    @Column(name = "laboratory_name")
    private String laboratoryName;

    private String description;

    @Column(name = "demo_url")
    private String demoUrl;

    @Column(name = "repository_url")
    private String repositoryUrl;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "file_reference")
    private String fileReference;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToMany
    @JoinTable(
            name = "laboratory_technology",
            joinColumns = @JoinColumn(name = "laboratory_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private Set<Technology> laboratoryTechnologies;

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFileReference() {
        return fileReference;
    }

    public void setFileReference(String fileReference) {
        this.fileReference = fileReference;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Technology> getLaboratoryTechnologies() {
        return laboratoryTechnologies;
    }

    public void setLaboratoryTechnologies(Set<Technology> laboratoryTechnologies) {
        this.laboratoryTechnologies = laboratoryTechnologies;
    }
}

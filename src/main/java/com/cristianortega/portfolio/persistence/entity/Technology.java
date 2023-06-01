package com.cristianortega.portfolio.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "technology")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private Long technologyId;

    private String name;

    @Column(name = "category_name")
    private String categoryName;

    private Boolean important;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "file_reference")
    private String fileReference;

    @ManyToMany(mappedBy = "laboratoryTechnologies")
    private Set<Laboratory> laboratories;

    @ManyToMany(mappedBy = "projectTechnologies")
    private Set<Project> projects;

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
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

    public Set<Laboratory> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(Set<Laboratory> laboratories) {
        this.laboratories = laboratories;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}

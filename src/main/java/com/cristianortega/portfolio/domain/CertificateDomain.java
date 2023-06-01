package com.cristianortega.portfolio.domain;

import java.time.LocalDateTime;

public class CertificateDomain {

    private Long id;
    private String course;
    private String code;
    private String category;
    private String learningPlatform;
    private LocalDateTime approved;
    private String fileRef;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLearningPlatform() {
        return learningPlatform;
    }

    public void setLearningPlatform(String learningPlatform) {
        this.learningPlatform = learningPlatform;
    }

    public LocalDateTime getApproved() {
        return approved;
    }

    public void setApproved(LocalDateTime approved) {
        this.approved = approved;
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
}

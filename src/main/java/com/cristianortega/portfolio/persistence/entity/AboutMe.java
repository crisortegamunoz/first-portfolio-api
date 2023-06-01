package com.cristianortega.portfolio.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "aboutme")
public class AboutMe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "about_id")
    private Long aboutMeId;

    private String title;

    @Column(name = "first_description")
    private String firstDescription;

    @Column(name = "second_description")
    private String secondDescription;

    @Column(name = "third_description")
    private String thirdDescription;

    public Long getAboutMeId() {
        return aboutMeId;
    }

    public void setAboutMeId(Long aboutMeId) {
        this.aboutMeId = aboutMeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstDescription() {
        return firstDescription;
    }

    public void setFirstDescription(String firstDescription) {
        this.firstDescription = firstDescription;
    }

    public String getSecondDescription() {
        return secondDescription;
    }

    public void setSecondDescription(String secondDescription) {
        this.secondDescription = secondDescription;
    }

    public String getThirdDescription() {
        return thirdDescription;
    }

    public void setThirdDescription(String thirdDescription) {
        this.thirdDescription = thirdDescription;
    }
}

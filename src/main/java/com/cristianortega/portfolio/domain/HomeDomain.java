package com.cristianortega.portfolio.domain;

import java.util.Set;

public class HomeDomain {

    private Set<AboutMeDomain> aboutMeList;
    private Set<ProjectDomain> projects;
    private Set<TechnologyDomain> technologies;
    private Set<LaboratoryDomain> laboratories;

    public HomeDomain() {
        super();
    }

    public Set<AboutMeDomain> getAboutMeList() {
        return aboutMeList;
    }

    public void setAboutMeList(Set<AboutMeDomain> aboutMeList) {
        this.aboutMeList = aboutMeList;
    }

    public Set<ProjectDomain> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDomain> projects) {
        this.projects = projects;
    }

    public Set<TechnologyDomain> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<TechnologyDomain> technologies) {
        this.technologies = technologies;
    }

    public Set<LaboratoryDomain> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(Set<LaboratoryDomain> laboratories) {
        this.laboratories = laboratories;
    }

}

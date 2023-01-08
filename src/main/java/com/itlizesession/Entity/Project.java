
package com.itlizesession.Entity;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = User.class)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JoinColumn(name = "id", referencedColumnName = "id")
    //@JsonBackReference
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "project", orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    @JsonManagedReference
    @JsonIgnore
    private Set<ProjectProduct> projectList = new HashSet<ProjectProduct>(){};

    public Project(){

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProjectProduct> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<ProjectProduct> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Projects { " + "projectId - " + projectId +
                ", user_id - " + user + ", project_name - " + projectName + " }";
    }
}


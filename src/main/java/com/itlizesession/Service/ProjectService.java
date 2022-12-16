package com.itlizesession.Service;


import com.itlizesession.Entity.Project;
import com.itlizesession.Entity.User;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    Project createProject(Integer proj_id);

    Project saveProject(Project project);

    void createProjs();

    List<Project> findAll();

    Project updateProjects(Project project);

    List<Project> findProjectsByUserId(User user);

    Set<Project> findProjectsByUser (User user);

    List<Project> findProjectsByUserContaining(User user);

    List<Project> findProjectsByIdContaining(Project project);

    void delProject(Project project);

    Project save(Project project);

}

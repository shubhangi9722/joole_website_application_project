package com.itlizesession.Service;


import com.itlizesession.Entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    Project createProject(Project project);

    Project getProject(Integer proj_id);

    List<Project> allProjects();

    void delProject(Integer projId);

    boolean updateProject(Project project, Integer project_id);

    Project save(Project project);





//    void createProjs();
//
//    List<Project> findAll();
//
//    Project updateProjects(Project project);
//
//    List<Project> findProjectsByUserId(User user);
//
//    Set<Project> findProjectsByUser (User user);
//
//    List<Project> findProjectsByUserContaining(User user);
//
//    List<Project> findProjectsByIdContaining(Project project);
//
//    void delProject(Project project);

}

package com.itlizesession.Service;


import com.itlizesession.Entity.Project;
import com.itlizesession.Entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {

    Project createProject(Project project);

    Project getProject(String proName);

    List<Project> allProjects();

    void delProject(Integer projId);

    boolean updateProject(Project project, Integer id);

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

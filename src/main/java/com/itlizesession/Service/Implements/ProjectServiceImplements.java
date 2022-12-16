package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.Project;
import com.itlizesession.Entity.User;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImplements implements ProjectService {

    @Autowired
    private ProjectRepository repository;


    @Override
    public Project createProject(Integer proj_id) {
        return null;
    }

    @Override
    public Project saveProject(Project project) {
        return null;
    }

    @Override
    public void createProjs() {

    }

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public Project updateProjects(Project project) {
        return null;
    }

    @Override
    public List<Project> findProjectsByUserId(User user) {
        return null;
    }

    @Override
    public Set<Project> findProjectsByUser(User user) {
        return null;
    }

    @Override
    public List<Project> findProjectsByUserContaining(User user) {
        return null;
    }

    @Override
    public List<Project> findProjectsByIdContaining(Project project) {
        return null;
    }

    @Override
    public void delProject(Project project) {

    }

    @Override
    public Project save(Project project) {
        return null;
    }
}

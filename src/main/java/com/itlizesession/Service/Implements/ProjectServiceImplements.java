package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.Project;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Repository.UserRepository;
import com.itlizesession.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplements implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Project createProject(Project project) {
        Project created = getProject(project.getProjectId());
        projectRepository.save(created);
        return created;
    }

    @Override
    public Project getProject(Integer proj_id) {
        if(proj_id != null){
            return projectRepository.findProjectByProjectId(proj_id).orElse(null);
        }
        return null;
    }

    @Override
    public List<Project> allProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void delProject(Integer projId) {
        projectRepository.deleteById(projId);
    }

    @Override
    public boolean updateProject(Project project, Integer project_id) {
        if(project == null || project_id == null){
            return false;
        }
        Project updated = projectRepository.findProjectByUserId(project_id).orElse(null);
        assert updated != null;
        projectRepository.save(updated);
        return true;
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}

package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.Project;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Repository.UserRepository;
import com.itlizesession.Service.ProjectService;
import com.itlizesession.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ProjectServiceImplements implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Project createProject(Project project) {
        //Optional<User> created = userRepository.findById(user_id);
        //userRepository.save(project.getUser());
        userRepository.save(project.getUser());
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(String proj_name) {
        if(proj_name != null){
            return projectRepository.findProjectsByProjectName(proj_name).orElse(null);
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
    public boolean updateProject(Project project, Integer id) {
        if(project == null || id == null){
            return false;
        }
        Project updated = projectRepository.findById(id).orElse(null);
        if (updated != null) {
            updated.setProjectName(project.getProjectName());
            projectRepository.save(updated);
        }
        return true;
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}

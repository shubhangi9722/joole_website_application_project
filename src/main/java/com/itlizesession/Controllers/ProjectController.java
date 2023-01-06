package com.itlizesession.Controllers;


import com.itlizesession.Entity.Project;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/projects/projectsList")
@Controller
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> findProjectById(@PathVariable int projectId){
        if(projectId == Integer.parseInt(" ")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);
    }

    @GetMapping("/projectsList")
    public ResponseEntity<List<Project>> findAllProjects(){
        return new ResponseEntity<>(projectService.allProjects(), HttpStatus.OK);
    }


    @PostMapping("/createProject")
    public ResponseEntity<Project> createProjects(@RequestBody Project createProject){
        return new ResponseEntity<>(projectService.createProject(createProject), HttpStatus.CREATED);
    }

    @PutMapping("/updateProject")
    public ResponseEntity<Project> updateProject(@RequestParam("{id}") int updateProjectId, Project project){
        Project updated = projectRepository.findProjectByUserId(updateProjectId).orElse(null);
        if(updated == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            projectService.updateProject(project, updated.getProjectId());
        }
        return new ResponseEntity<>(projectService.getProject(project.getProjectId()), HttpStatus.OK);
    }


    @DeleteMapping("/deleteProject")
    public ResponseEntity<?> deleteProjectById (@RequestParam("{id}") int delProjId){
        Project delProject = projectRepository.findProjectByProjectId(delProjId).orElse(null);
        if(delProject == null){
            return new ResponseEntity<>("Oops, Sorry cannot find the Project to delete", HttpStatus.NOT_FOUND);
        } else {
            projectService.delProject(delProjId);
        }
        return new ResponseEntity<>(delProject, HttpStatus.OK);
    }

    @PostMapping("/saveProjects")
    public ResponseEntity<Project> saveProjects(@RequestBody Project project){
        return new ResponseEntity<>(projectService.save(project), HttpStatus.OK);
    }
}

package com.itlizesession.Services.Implements;

import com.itlizesession.Entity.Project;
import com.itlizesession.Entity.User;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Repository.UserRepository;
import com.itlizesession.Service.ProjectService;
import com.itlizesession.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Component
@SpringBootTest
class ProjectServiceImplementsTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;


    @Test
    void createProject1() {
        Project createProj1 = new Project();
        try {
            createProj1.setProjectName("Mechanical");
            System.out.println(createProj1.getProjectName());
            projectRepository.save(createProj1);
            Project isSuccessfull = projectService.createProject(createProj1);
            System.out.println(isSuccessfull.getProjectName());
            Assertions.assertEquals(createProj1, isSuccessfull);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void createProject2() {
        Project createProj2 = new Project();
        try {
            createProj2.setProjectName("ELectronics");
            projectRepository.save(createProj2);
            Project isSuccessfull = projectService.createProject(createProj2);
            Assertions.assertEquals(createProj2, isSuccessfull);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void createProject3() {
        Project createProj3 = new Project();
        try {
            createProj3.setProjectName("Home Appliances");
            projectRepository.save(createProj3);
            Project isSuccessfull = projectService.createProject(createProj3);
            Assertions.assertEquals(createProj3, isSuccessfull);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void createProject4() {
        Project createProj = new Project();
        try {
            createProj.setProjectName("Furniture");
            projectRepository.save(createProj);
            Project isSuccessfull = projectService.createProject(createProj);
            Assertions.assertEquals(createProj, isSuccessfull);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getProject1() {
        Project received1 = projectService.getProject("Mechanical");
        System.out.println("The queried project is - " + received1.getProjectName());
        Assertions.assertNotNull(received1);
    }

    @Test
    void getProject2() {
        Project received2 = projectService.getProject("Electronics");
        System.out.println("The queried project is - " + received2.getProjectName());
        Assertions.assertNotNull(received2);
    }

    @Test
    void getProject3() {
        Project received3 = projectService.getProject("Home Appliances");
        System.out.println("The queried project is - " + received3.getProjectName());
        Assertions.assertNotNull(received3);
    }

    @Test
    void getProject4() {
        Project received4 = projectService.getProject("Furniture");
        System.out.println("The queried project is - " + received4.getProjectName());
        Assertions.assertNotNull(received4);
    }

    @Test
    void allProjects() {
        List<Project> allProjectList = projectService.allProjects();
        System.out.println("These are all the projects - ( " + allProjectList + " )");
        Assertions.assertNotNull(allProjectList);
    }

    @Test
    void delProject1() {
        Optional<Project> delTest1 = projectRepository.findProjectByProjectId(26);
        System.out.println("Deleted Project is " + delTest1);
        projectService.delProject(delTest1.orElseThrow().getProjectId());
    }

    @Test
    void delProject2() {
        Optional<Project> delTest2 = projectRepository.findProjectByProjectId(15);
        System.out.println("Deleted Project is " + delTest2);
        projectService.delProject(delTest2.orElseThrow().getProjectId());
    }

    @Test
    void delProject3() {
        Optional<Project> delTest3 = projectRepository.findProjectByProjectId(3);
        System.out.println("Deleted Project is " + delTest3);
        projectService.delProject(delTest3.orElseThrow().getProjectId());
    }

    @Test
    void delProject4() {
        Optional<Project> delTest4 = projectRepository.findProjectByProjectId(22);
        System.out.println("Deleted Project is " + delTest4);
        projectService.delProject(delTest4.orElseThrow().getProjectId());
    }

    @Test
    void updateProject1() {
        Project projUpdated = projectService.getProject("Mechanical");
        projUpdated.setProjectName("Mechanical & Civil");
        boolean isSuccess = projectService.updateProject(projUpdated, 21);
        Assertions.assertTrue(isSuccess);
    }

    @Test
    void updateProject2() {
        Project projUpdated = projectService.getProject("Home Appliances");
        projUpdated.setProjectName("Home Technical");
        boolean isSuccess = projectService.updateProject(projUpdated, 23);
        Assertions.assertTrue(isSuccess);
    }

}
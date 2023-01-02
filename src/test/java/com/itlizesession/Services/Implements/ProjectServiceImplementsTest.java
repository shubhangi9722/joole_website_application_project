package com.itlizesession.Services.Implements;

import com.itlizesession.Entity.Project;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Service.ProjectService;
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
        Project createProj = new Project();
        createProj.setProjectId(1);
        Project isSuccessfull = projectService.createProject(createProj);
//        Project isSuccessfull = projectRepository.findProjectByProjectId
//                (createProj.getProjectId()).orElse(null);
        Assertions.assertEquals(createProj, isSuccessfull);
    }

    @Test
    void createProject2() {
        Project createProj = new Project();
        createProj.setProjectId(2);
        Project isSuccessfull = projectService.createProject(createProj);
//        Project isSuccessfull = projectRepository.findProjectByProjectId
//                (createProj.getProjectId()).orElse(null);
        Assertions.assertEquals(createProj, isSuccessfull);
    }

    @Test
    void createProject3() {
        Project createProj = new Project();
        createProj.setProjectId(3);
        Project isSuccessfull = projectService.createProject(createProj);
//        Project isSuccessfull = projectRepository.findProjectByProjectId
//                (createProj.getProjectId()).orElse(null);
        Assertions.assertEquals(createProj, isSuccessfull);
    }

    @Test
    void createProject4() {
        Project createProj = new Project();
        createProj.setProjectId(4);
        Project isSuccessfull = projectService.createProject(createProj);
//        Project isSuccessfull = projectRepository.findProjectByProjectId
//                (createProj.getProjectId()).orElse(null);
        Assertions.assertEquals(createProj, isSuccessfull);
    }

    @Test
    void getProject1() {
        Project received = projectService.getProject(1);
        Assertions.assertNotNull(received);
    }

    @Test
    void getProject2() {
        Project received = projectService.getProject(2);
        Assertions.assertNotNull(received);
    }

    @Test
    void getProject3() {
        Project received = projectService.getProject(3);
        Assertions.assertNotNull(received);
    }

    @Test
    void getProject4() {
        Project received = projectService.getProject(4);
        Assertions.assertNotNull(received);
    }

    @Test
    void allProjects() {
        List<Project> allProjectList = projectService.allProjects();
        Assertions.assertNotNull(allProjectList);
    }

    @Test
    void delProject1() {
        Optional<Project> delTest = projectRepository.findProjectByProjectId(1);
        projectService.delProject(delTest.orElseThrow().getProjectId());
    }

    @Test
    void delProject2() {
        Optional<Project> delTest = projectRepository.findProjectByProjectId(2);
        projectService.delProject(delTest.orElseThrow().getProjectId());
    }

    @Test
    void delProject3() {
        Optional<Project> delTest = projectRepository.findProjectByProjectId(3);
        projectService.delProject(delTest.orElseThrow().getProjectId());
    }

    @Test
    void delProject4() {
        Optional<Project> delTest = projectRepository.findProjectByProjectId(4);
        projectService.delProject(delTest.orElseThrow().getProjectId());
    }

    @Test
    void updateProject1() {
        Project updatedProjTest = projectService.getProject(2);
        updatedProjTest.setProjectId(1);
        boolean isSuccessfull = projectService.updateProject(updatedProjTest, 2);
        Assertions.assertTrue(isSuccessfull);
    }

    @Test
    void updateProject2() {
        Project updatedProjTest = projectService.getProject(3);
        updatedProjTest.setProjectId(4);
        boolean isSuccessfull = projectService.updateProject(updatedProjTest, 3);
        Assertions.assertTrue(isSuccessfull);
    }

    @Test
    void save1() {
        Project saved = new Project();
        Project isSucessfull = projectService.save(saved);
        Assertions.assertNotNull(isSucessfull);
    }

    @Test
    void save2() {
        Project saved = new Project();
        Project isSucessfull = projectService.save(saved);
        Assertions.assertNotNull(isSucessfull);
    }

    @Test
    void save3() {
        Project saved = new Project();
        Project isSucessfull = projectService.save(saved);
        Assertions.assertNotNull(isSucessfull);
    }

    @Test
    void save4() {
        Project saved = new Project();
        Project isSucessfull = projectService.save(saved);
        Assertions.assertNotNull(isSucessfull);
    }
}
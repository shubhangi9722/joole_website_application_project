package com.itlizesession.Repository;

import com.itlizesession.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends JpaRepository <Project, Integer> {
     Optional<Project> findProjectByProjectId (Integer project);
//
     Optional<Project> findProjectByUserId(Integer userId);
//
//    Optional<HashSet<Project>> findProjectsByUser (User user);
//
//    Optional<List<Project>> findProjectsByUserContaining (String user_address);
//
//    Optional<List<Project>> findProjectsByIdContaining (User user_id);

}

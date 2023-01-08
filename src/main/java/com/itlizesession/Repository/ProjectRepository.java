package com.itlizesession.Repository;

import com.itlizesession.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Integer> {
     Optional<Project> findProjectByProjectId (int project);
//
     Optional<Project> findProjectByUserUserName (String username);

     Optional<Project> findProjectsByProjectName(String projName);
//
//    Optional<HashSet<Project>> findProjectsByUser (User user);
//
//    Optional<List<Project>> findProjectsByUserContaining (String user_address);
//
//    Optional<List<Project>> findProjectsByIdContaining (User user_id);

}

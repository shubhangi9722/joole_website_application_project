package com.itlizesession.Repository;

import com.itlizesession.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Integer> {
//    Optional<Project> findProjectById (Integer project);
//
//    Optional<List<Project>> findProjectByUserId(Integer userId);
//
//    Optional<HashSet<Project>> findProjectsByUser (User user);
//
//    Optional<List<Project>> findProjectsByUserContaining (String user_address);
//
//    Optional<List<Project>> findProjectsByIdContaining (User user_id);

}

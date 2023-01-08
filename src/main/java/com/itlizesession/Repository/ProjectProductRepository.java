package com.itlizesession.Repository;

import com.itlizesession.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {

  //  Optional<ProjectProduct> findProjectProductByProject(ProjectProduct project);

//    Optional<ProjectProduct> findProjectProductByProject_id (Integer projId);

//    Optional<ProjectProduct> findProjectProductByProduct(Product product);

//    Optional<ProjectProduct> findProjectProductByProduct_id (Integer prodId);


}

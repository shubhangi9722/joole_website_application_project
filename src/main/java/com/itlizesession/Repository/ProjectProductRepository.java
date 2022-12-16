package com.itlizesession.Repository;

import com.itlizesession.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {

//    Optional<ProjectProduct> findProjectProductByProject(ProjectProduct project);
//
//    Optional<ProjectProduct> findProjectProductByProject_id (Integer projId);
//
////    Optional<ProjectProduct> findProjectProductByProduct(Product product);
//
//    Optional<ProjectProduct> findProjectProductByProduct_id (Integer prodId);

//    Optional<List<ProjectProduct>> findProjectProductsByProject_idContaining (Integer containing);
//
//    Optional<List<ProjectProduct>> findProjectProductsByProduct_idContaining (Integer containing);

}

package com.itlizesession.Service;

import com.itlizesession.Entity.ProjectProduct;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectProductService {
    ProjectProduct createProjProd (ProjectProduct projectProduct);


    List<ProjectProduct> findAll();

    ProjectProduct getProductsProjects(Integer id);

//    Optional<ProjectProduct> findByProjId(Integer id);
//
//    Optional<ProjectProduct> findByProdId(Integer id);

    boolean delProjProd(Integer projectProductId);

    ProjectProduct save(ProjectProduct projectProduct);

}

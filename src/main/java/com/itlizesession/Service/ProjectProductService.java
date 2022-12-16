package com.itlizesession.Service;

import com.itlizesession.Entity.ProjectProduct;

import java.util.List;
import java.util.Optional;

public interface ProjectProductService {
    ProjectProduct createProjProd (ProjectProduct projectProduct);

    ProjectProduct saveProjProd (ProjectProduct projectProduct);

    void createProjProd();

    List<ProjectProduct> findAll();

    ProjectProduct updateProjects(ProjectProduct projectProduct);

    Optional<ProjectProduct> findByProjId(Integer id);

    Optional<ProjectProduct> findByProdId(Integer id);

    void delProjProd(ProjectProduct projectProduct);

    void delProjProd1(ProjectProduct projectProduct);

    ProjectProduct save(ProjectProduct projectProduct);

}

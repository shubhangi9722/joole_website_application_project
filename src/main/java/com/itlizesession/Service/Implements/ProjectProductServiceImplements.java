package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.ProjectProduct;
import com.itlizesession.Repository.ProductRepository;
import com.itlizesession.Repository.ProjectProductRepository;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Service.ProductService;
import com.itlizesession.Service.ProjectProductService;
import com.itlizesession.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ProjectProductServiceImplements implements ProjectProductService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ProjectProductRepository projectProductRepository;


    @Override
    public ProjectProduct createProjProd(ProjectProduct projectProduct) {
        if (projectProduct == null){
            return null;
        }
        projectService.getProject(projectProduct.getProject().getProjectName());
        productService.getProduct(projectProduct.getProduct().getProductId());
        return projectProductRepository.save(projectProduct);
    }

    @Override
    public List<ProjectProduct> findAll() {
       return projectProductRepository.findAll();
    }

    @Override
    public ProjectProduct getProductsProjects(Integer id) {
        return projectProductRepository.findById(id).orElse(null);
    }


//    @Override
//    public Optional<ProjectProduct> findByProjId(Integer id) {
//        if (id == null) return Optional.empty();
//        return projectProductRepository.findProjectProductByProject_id(id);
//    }
//
//    @Override
//    public Optional<ProjectProduct> findByProdId(Integer id) {
//       if (id == null) return Optional.empty();
//       return projectProductRepository.findProjectProductByProduct_id(id);
//    }

    @Override
    public boolean delProjProd(Integer projectProductId) {
        projectProductRepository.deleteById(projectProductId);
        return true;
    }

    @Override
    public ProjectProduct save(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }

}

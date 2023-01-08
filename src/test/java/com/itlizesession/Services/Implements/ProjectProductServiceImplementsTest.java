package com.itlizesession.Services.Implements;

import com.itlizesession.Entity.ProjectProduct;
import com.itlizesession.Repository.ProductRepository;
import com.itlizesession.Repository.ProjectProductRepository;
import com.itlizesession.Repository.ProjectRepository;
import com.itlizesession.Service.ProductService;
import com.itlizesession.Service.ProjectProductService;
import com.itlizesession.Service.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectProductServiceImplementsTest {

//    @Autowired
//    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

//    @Autowired
//    private ProductRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProjectProductService projectProductService;
    @Autowired
    private ProjectProductRepository projectProductRepository;



    @Test
    void createProjProd1() {
        ProjectProduct addNew = new ProjectProduct();
        addNew.setProject(projectService.getProject("Furniture"));
        addNew.setProduct(productService.getProduct(4));
        projectProductRepository.save(addNew);
        System.out.println(addNew.getProject());
        System.out.println(addNew.getProduct());
        ProjectProduct isCreated = projectProductService.createProjProd(addNew);
        System.out.println(isCreated.getProjProdId());
        Assertions.assertEquals(addNew, isCreated);
    }

    @Test
    void createProjProd2() {
        ProjectProduct addNew = new ProjectProduct();
        addNew.setProject(projectService.getProject("Mechanical & Civil"));
        addNew.setProduct(productService.getProduct(3));
        projectProductRepository.save(addNew);
        System.out.println(addNew.getProject());
        System.out.println(addNew.getProduct());
        ProjectProduct isCreated = projectProductService.createProjProd(addNew);
        System.out.println(isCreated.getProjProdId());
        Assertions.assertEquals(addNew, isCreated);
    }

    @Test
    void createProjProd3() {
        ProjectProduct addNew = new ProjectProduct();
        addNew.setProject(projectService.getProject("Mechanical"));
        addNew.setProduct(productService.getProduct(1));
        projectProductRepository.save(addNew);
        System.out.println(addNew.getProject());
        System.out.println(addNew.getProduct());
        ProjectProduct isCreated = projectProductService.createProjProd(addNew);
        System.out.println(isCreated.getProjProdId());
        Assertions.assertEquals(addNew, isCreated);
    }

    @Test
    void getProductsProjects() {
        ProjectProduct isReceived = projectProductService.getProductsProjects(10);
        System.out.println("The corresponding Product for Project is: " + isReceived.getProduct());
        System.out.println("The corresponding Project for Product is: " + isReceived.getProject());
        Assertions.assertNotNull(isReceived);
    }


    @Test
    void findAll() {
        List<ProjectProduct> allProjectProducts = projectProductService.findAll();
        System.out.println("These are all the list of Projects and Products ( " + allProjectProducts + " )" );
        Assertions.assertNotNull(allProjectProducts);
    }


    @Test
    void delProjProd() {
       boolean isDeleted = projectProductService.delProjProd(12);
       Assertions.assertTrue(isDeleted);
    }

}
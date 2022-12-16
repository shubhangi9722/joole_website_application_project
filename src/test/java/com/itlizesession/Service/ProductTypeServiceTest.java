package com.itlizesession.Service;

import com.itlizesession.Entity.ProductType;
import com.itlizesession.Repository.ProductTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;



@SpringBootTest
class ProductTypeServiceTest {

    @Autowired
    private ProductTypeService service;

    @Autowired
    private ProductTypeRepository repo;

    @Test
    void testCreateProductType() {

        ProductType type = new ProductType();
        type.setType("Industrial");
        type.setApplication("outdoor");
        type.setMountingLocation("Roof");
        type.setAccessories("With light");
        type.setModelYear(2018);
        ProductType savedProductType = service.createProductType(type);
        Assertions.assertEquals("Industrial",type.getType());
    }

    @Test
    void testFindbyType() {
        Optional<ProductType> types = service.findbyType("Industrial");
        Assertions.assertTrue(types != null);
    }

    @Test
    void updateProductType() {
        ProductType type = repo.getById(2);
        type.setType("Commercial");
        repo.save(type);
        Assertions.assertEquals("Commercial",type.getType());
    }

}
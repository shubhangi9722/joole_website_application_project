package com.itlizesession.Services.Implements;

import com.itlizesession.Entity.Product;
import com.itlizesession.Entity.Description;
import com.itlizesession.Entity.ProductType;
import com.itlizesession.Entity.TechnicalDetail;
import com.itlizesession.Service.DescriptionService;
import com.itlizesession.Service.ProductService;
import com.itlizesession.Service.ProductTypeService;
import com.itlizesession.Service.TechnicalDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceImplementsTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private TechnicalDetailService technicalDetailService;

    @Test
    void createProduct1() {
        Product toAdd = new Product();
        toAdd.setProductBrand("Columbia Company");
        toAdd.setCertification("certification");
        Description newDescription = new Description("Big ass", "Haiku H",
                "S3150-S0-BC-04-01-C-01");
        TechnicalDetail newTechnicalDetail = new TechnicalDetail(5467, 21, 240,
                200, 35, 60, 12);
        ProductType newProductType = new ProductType("Commercial", "Indoor", "Roof",
                "with light", 2016);

        toAdd.setDescription(newDescription);
        descriptionService.createDescription(newDescription);

        toAdd.setTechnicalDetail(newTechnicalDetail);
        technicalDetailService.createTechnicalDetail(newTechnicalDetail);

        toAdd.setProductType(newProductType);
        productTypeService.createProductType(newProductType);

        Product isSuccessful = productService.createProduct(toAdd);
        Assertions.assertEquals(toAdd, isSuccessful);
    }

    @Test
    void createProduct2() {
        Product toAdd = new Product();
        toAdd.setProductBrand("Laars");
        toAdd.setCertification("certification");
        Description newDescription = new Description("Emerson", "Minka",
                "CF860");
        TechnicalDetail newTechnicalDetail = new TechnicalDetail(8500, 33, 240,
                240, 40, 55, 10);
        ProductType newProductType = new ProductType("Commercial", "Indoor", "Roof",
                "with light", 2014);

        toAdd.setDescription(newDescription);
        descriptionService.createDescription(newDescription);

        toAdd.setTechnicalDetail(newTechnicalDetail);
        technicalDetailService.createTechnicalDetail(newTechnicalDetail);

        toAdd.setProductType(newProductType);
        productTypeService.createProductType(newProductType);

        Product isSuccessful = productService.createProduct(toAdd);
        Assertions.assertEquals(toAdd, isSuccessful);
    }

    @Test
    void createProduct3() {
        Product toAdd = new Product();
        toAdd.setProductBrand("Laars");
        toAdd.setCertification("certification");
        Description newDescription = new Description("Emerson", "Luray Eco",
                "CF860");
        TechnicalDetail newTechnicalDetail = new TechnicalDetail(8500, 33, 240,
                240, 40, 55, 10);
        ProductType newProductType = new ProductType("Commercial", "Indoor", "Roof",
                "with light", 2014);

        toAdd.setDescription(newDescription);
        descriptionService.createDescription(newDescription);

        toAdd.setTechnicalDetail(newTechnicalDetail);
        technicalDetailService.createTechnicalDetail(newTechnicalDetail);

        toAdd.setProductType(newProductType);
        productTypeService.createProductType(newProductType);

        Product isSuccessful = productService.createProduct(toAdd);
        Assertions.assertEquals(toAdd, isSuccessful);
    }

    @Test
    void createProduct4() {
        Product toAdd = new Product();
        toAdd.setProductBrand("Hurst & Welding Company, Inc.");
        toAdd.setCertification("certification");
        Description newDescription = new Description("Minka", "Avlation",
                "CF860");
        TechnicalDetail newTechnicalDetail = new TechnicalDetail(8500, 33, 240,
                240, 40, 55, 10);
        ProductType newProductType = new ProductType("Commercial", "Indoor", "Roof",
                "with light", 2014);

        toAdd.setDescription(newDescription);
        descriptionService.createDescription(newDescription);

        toAdd.setTechnicalDetail(newTechnicalDetail);
        technicalDetailService.createTechnicalDetail(newTechnicalDetail);

        toAdd.setProductType(newProductType);
        productTypeService.createProductType(newProductType);

        Product isSuccessful = productService.createProduct(toAdd);
        Assertions.assertEquals(toAdd, isSuccessful);
    }

    @Test
    void getProduct() {
        Product res = productService.getProduct(1);
//        System.out.println(res);
        Assertions.assertNotNull(res);
    }

    @Test
    void updateProduct() {
        Product toUpdate = productService.getProduct(2);
//        System.out.println(toUpdate);
        toUpdate.setProductBrand("Fulton Inc");
//        System.out.println(toUpdate);
        boolean isSuccessful = productService.updateProduct(toUpdate, 2);
//        System.out.println(isSuccessful);
        Assertions.assertTrue(isSuccessful);
    }

    @Test
    void deleteProduct() {
        boolean isSuccessful = productService.deleteProduct(15);
        Assertions.assertTrue(isSuccessful);
    }

    @Test
    void findAllProducts() {
        List<Product> productList = productService.findAllProducts();
//        System.out.println(productList);
        Assertions.assertNotNull(productList);
    }
}
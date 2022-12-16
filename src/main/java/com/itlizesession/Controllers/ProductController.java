package com.itlizesession.Controllers;


//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import com.itlizesession.Entity.Description;
import com.itlizesession.Entity.Product;
import com.itlizesession.Entity.ProductType;
import com.itlizesession.Entity.TechnicalDetail;
import com.itlizesession.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@ResponseBody
public class ProductController {
    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/products")
    public List<Product> list() { return productService.findAllProducts(); }

    @PostMapping("/addProducts")
    public Product createProduct(@RequestParam("brand") String brand, @RequestParam("certification") String certification,
                                 @RequestBody ProductType productType, @RequestBody TechnicalDetail technicalDetail, @RequestBody Description description) {
        Product product1 = new Product();
        product1.setProductBrand(brand);
        product1.setCertification(certification);
        product1.setProductType(productType);
        product1.setTechnicalDetail(technicalDetail);
        product1.setDescription(description);
        return productService.createProduct(product1);
    }

    @GetMapping("/read/{id}")
    public Product readProduct(@RequestParam("productId") Integer productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product, @RequestParam("productId") Integer productId) {
        productService.updateProduct(product, productId);
        return productService.getProduct(productId);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@RequestParam("productId") Integer productId) {
        return productService.deleteProduct(productId);
    }
}
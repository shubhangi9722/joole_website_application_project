package com.itlizesession.Controllers;

import com.itlizesession.Entity.Product;
import com.itlizesession.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;


@WebServlet("/product/allProducts")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAllProducts() { return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK) ; }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductBYId(@PathVariable int id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    //    @PostMapping("/create")
//    public Product createProduct(@RequestParam("brand") String brand, @RequestParam("certification") String certification,
//                                 @RequestBody ProductType productType, @RequestBody TechnicalDetail technicalDetail, @RequestBody Description description) {
//        Product product1 = new Product();
//        product1.setProductBrand(brand);
//        product1.setCertification(certification);
//        product1.setProductType(productType);
//        product1.setTechnicalDetail(technicalDetail);
//        product1.setDescription(description);
//        return productService.createProduct(product1);
//    }
//
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product, product.getProductId());
        return new ResponseEntity<>(productService.getProduct(product.getProductId()), HttpStatus.OK) ;
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
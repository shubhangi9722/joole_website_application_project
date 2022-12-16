package com.itlizesession.Service;


import com.itlizesession.Entity.Product;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public interface ProductService {
    // create
    Product createProduct(Product product);

    // read
    Product getProduct(Integer productId);

    // update
    boolean updateProduct(Product product, Integer productId);

    // delete
    boolean deleteProduct(Integer productId);

    //read all products
    List<Product> findAllProducts();
}

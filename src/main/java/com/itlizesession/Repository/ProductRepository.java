package com.itlizesession.Repository;

import com.itlizesession.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    Optional<Product> findProductByProductId(Integer productId);
//
//    Optional<List<Product>> findProductsByProductBrand(String brand);
//
//    Optional<List<Product>> findProductsByCertification(String certification);
}

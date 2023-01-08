package com.itlizesession.Service;


import com.itlizesession.Entity.ProductType;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public interface ProductTypeService {
    @Transactional
    ProductType createProductType(ProductType ProductType);

    Optional<ProductType> findbyType(String type);

    ProductType updateProductType(ProductType ProductType);

    //void deleteProductType(int id);
}

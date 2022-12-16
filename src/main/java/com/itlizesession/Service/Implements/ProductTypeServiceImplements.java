
package com.itlizesession.Service.Implements;


import com.itlizesession.Entity.ProductType;
import com.itlizesession.Repository.ProductTypeRepository;
import com.itlizesession.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class ProductTypeServiceImplements implements ProductTypeService {

    @Autowired
    private ProductTypeRepository repo;


    @Override
    public ProductType createProductType(ProductType productType) {
        return repo.save(productType);
    }

    @Override
    public Optional<ProductType> findbyType(String type) {
        return repo.findByType(type);
    }

    @Override
    public ProductType updateProductType(ProductType ProductType) {
        ProductType existingProductType = new ProductType();

        // asserting as these operations will take place only when its not null
        existingProductType.setType(ProductType.getType());
        existingProductType.setApplication(ProductType.getApplication());
        existingProductType.setMountingLocation(ProductType.getMountingLocation());
        existingProductType.setAccessories(ProductType.getAccessories());
        return repo.save(existingProductType);
    }

    //@Override
    /*public void deleteProductType(int id) {
        repo.deleteById(id);
    }*/
}

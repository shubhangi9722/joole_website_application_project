
package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.Product;
import com.itlizesession.Repository.DescriptionRepository;
import com.itlizesession.Repository.ProductRepository;
import com.itlizesession.Repository.ProductTypeRepository;
import com.itlizesession.Repository.TechnicalDetailRepository;
import com.itlizesession.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImplements implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DescriptionRepository descriptionRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private TechnicalDetailRepository technicalDetailRepository;

    @Override
    public Product createProduct(Product product) {
        if (product == null) {
            System.out.println("null input");
            return null;
        }
        Product target = getProduct(product.getProductId());
        if (target != null) {
            System.out.println("Product already exists");
            return null;
        }
        productTypeRepository.save(product.getProductType());
        descriptionRepository.save(product.getDescription());
        technicalDetailRepository.save(product.getTechnicalDetail());
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Integer productId) {
        if (productId == null) return null;
        return productRepository.findById(productId).orElse(null);

    }

    @Override
    public boolean updateProduct(Product product, Integer productId) {
        if (product == null || productId == null) {
            System.out.println("null input");
            return false;
        }
        Product productToUpdate = productRepository.findById(productId).orElse(null);
        if (productToUpdate == null) {
            System.out.println("No product with id: " + productId);
            return false;
        }
        try {
            productToUpdate.setProductBrand(product.getProductBrand());
            productToUpdate.setCertification(product.getCertification());
            productToUpdate.setProductType(product.getProductType());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setTechnicalDetail(product.getTechnicalDetail());
            productRepository.save(productToUpdate);
        } catch (Exception e) {
            System.out.println("something wrong when updating: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        if (productId == null) {
            System.out.println("null input");
            return false;
        }
        Product product = getProduct(productId);
        if (product == null) return false;
        try {
            productRepository.delete(product);
//            System.out.println("done");
        } catch (Exception e) {
            System.out.println("something wrong when deleting: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}

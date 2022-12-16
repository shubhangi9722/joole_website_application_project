
package com.itlizesession.Repository;

import com.itlizesession.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    Optional<ProductType> findByType(String type);
}

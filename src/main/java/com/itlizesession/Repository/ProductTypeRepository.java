
package com.itlizesession.Repository;

import com.itlizesession.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    Optional<ProductType> findByType(String type);
}

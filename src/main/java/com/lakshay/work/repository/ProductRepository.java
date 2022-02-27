package com.lakshay.work.repository;
import com.lakshay.work.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

        List<Product> findByName(String Name);

        Product findById(long id);

    List<Product> findBySellerId(Long sellerId);
}


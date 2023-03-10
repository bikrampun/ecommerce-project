package com.learning.ecommerce.dao;

import com.learning.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring will execute query similar to this
    // select * from Product where category_id=?
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // Spring will execute query similar to this
    // select * from Product p where p.name like concat('%', :name, '%')
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}

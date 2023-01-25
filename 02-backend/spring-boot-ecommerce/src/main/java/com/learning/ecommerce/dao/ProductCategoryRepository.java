package com.learning.ecommerce.dao;

import com.learning.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
// productCategory -- name of json entry and /product-category will be actual reference for the path
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}

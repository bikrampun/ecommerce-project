package com.learning.ecommerce.dao;

import com.learning.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//web browser will not allow script code to call APIs not on the same origin due to same origin policy
// @CrossOrigin("http://localhost:4200") - allow cross origin requests from http://localhost:4200
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
// productCategory -- name of json entry and /product-category will be actual reference for the path
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}

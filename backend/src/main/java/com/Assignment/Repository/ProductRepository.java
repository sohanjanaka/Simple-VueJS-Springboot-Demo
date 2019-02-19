package com.Assignment.Repository;

import com.Assignment.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //SELECT * FROM name WHERE name = {name}
    Collection<Product> findByName(@Param("name") String name);

}

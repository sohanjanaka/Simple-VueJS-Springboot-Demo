package com.Assignment.Controller;


import com.Assignment.Entity.Product;
import com.Assignment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private int id;

    @RequestMapping(method = RequestMethod.GET, value = "name/{name}")
    Collection<Product> getAllProductByName(@PathVariable String name){
        System.out.println("my method");
        return this.pr.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Product> getAllProducts(){
        return this.pr.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "id/{id}")
    String getProductById(@PathVariable int id){
        return this.pr.findById(id).get().getName();
    }

    @Autowired
    ProductRepository pr;
}

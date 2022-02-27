package com.lakshay.work.controller;


import com.lakshay.work.entity.Product;
import com.lakshay.work.exception.ProductNotFoundException;
import com.lakshay.work.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProductController {
    @Autowired
   private ProductRepository repository;

   /* ProductController(ProductRepository repository){
        this.repository = repository;
    }*/
    @GetMapping("/products")
    List<Product> all(){
        return repository.findAll();
    }
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/products{id}")
    Product one(@PathVariable Long id) throws ProductNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

    }
    @PutMapping("/Products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setCategory(newProduct.getCategory());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }

}












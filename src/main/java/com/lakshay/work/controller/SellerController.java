package com.lakshay.work.controller;


import com.lakshay.work.entity.Product;
import com.lakshay.work.exception.ProductNotFoundException;
import com.lakshay.work.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SellerController {
    private final ProductRepository repository;

    SellerController(ProductRepository repository){
        this.repository = repository;
    }
    @GetMapping("/sellers/{sellerId}/products")
    List<Product> all(@PathVariable Long sellerId ){
        return repository.findBySellerId(sellerId);

    }
    @PostMapping("/sellers/{sellerId}/product")
    Product newProduct(@PathVariable Long sellerId, @RequestBody Product newProduct){
        return repository.save(newProduct);

    }


    @GetMapping("/sellers/{sellerId}/product/{id}")
    Product one(@PathVariable Long sellerId, @PathVariable Long id) throws ProductNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

    }
    @PutMapping("/sellers/{sellerId}/product/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long sellerId, @PathVariable Long id) {

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

    @DeleteMapping("/sellers/{sellerId}/product/{id}")
    void deleteProduct(@PathVariable Long sellerId, @PathVariable Long id) {
        repository.deleteById(id);
    }

}

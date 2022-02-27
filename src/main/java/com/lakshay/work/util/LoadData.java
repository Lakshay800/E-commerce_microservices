package com.lakshay.work.util;

import com.lakshay.work.entity.Product;
import com.lakshay.work.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {

    public CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            // todo make 4 users seller1 seller2
            // create more products

            repository.save(new Product("Dell alienwear", "Laptops", "an gaming laptop",258871.50, 1L,"electronics"));
            repository.save(new Product("Lenovo", "Laptops", "buisness laptop with pre installed MS Office",38950.99,2L,"electronics"));
            repository.save(new Product("Android", "Software","An software cheap and easy to use",15000.00,3L,"OS"));
            repository.save(new Product("Mac", "Laptops","laptop for developers",45000.00,4L,"electronics"));
            repository.save(new Product("Chrome", "Software", "Cheap & fast operating system",4000.00,5L,"OS"));
            repository.save(new Product("HP", "Laptops", "180 degree rotatable screen with build in Corei3",59999.01,6L,"electronics"));
            repository.save(new Product("Linux", "Software", "Programmers loves it",6000.00,7L,"OS"));
            repository.save(new Product("ASUS", "Laptops", "Build strong for the strong",90000.00,8L,"electronice"));



        };
    }
}
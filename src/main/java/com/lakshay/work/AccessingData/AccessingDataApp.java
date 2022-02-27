package com.lakshay.work.AccessingData;

import com.lakshay.work.entity.Product;
import com.lakshay.work.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class AccessingDataApp {

    //private static final Logger log = LoggerFactory.getLogger(AccessingDataApp.class);

    public static void main(String[] args)
    {
        SpringApplication.run(AccessingDataApp.class, args);

    }
    //@Autowired
    //@Bean
    //public CommandLineRunner demo(ProductRepository repository){
      //  return(args) ->{
        //    repository.save(new Product("Dell alienwear", "Laptops", "an gaming laptop", "Rs 250000"));
          //  repository.save(new Product("Lenovo", "Laptops", "buisness laptop with pre installed MS Office", "Rs 100000"));
            //repository.save(new Product("Android", "Software","An software cheap and easy to use", "Rs15000"));
            //repository.save(new Product("Mac", "Laptops","laptop for developers", "Rs80000"));
            //repository.save(new Product("kali", "Software", "A software to penitrate test profiles", "Rs50000"));

           // log.info("Product found with findAll():");
            //log.info("-------------------------------");
            //for (Product product : repository.findAll()) {
              //  log.info(product.toString());
            //}
           // log.info("");
            //Product product = repository.findById(1L);
            //log.info("Product found with findById(1L):");
            //log.info("--------------------------------");
            //log.info(product.toString());
            //log.info("");

            // fetch customers by last name
           // log.info("Product found with findByLastName('Bauer'):");
            //log.info("--------------------------------------------");
            //repository.findByName("Lenovo").forEach(Lenovo -> {
             //   log.info(Lenovo.toString());
            //});
            //log.info("");
       // };
    //}
}

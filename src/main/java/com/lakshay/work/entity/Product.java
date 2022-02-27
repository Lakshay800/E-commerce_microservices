package com.lakshay.work.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
  public class Product {
     @Id
    @GeneratedValue
     private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Long sellerId;
    private String productType;

    // add product type



    public Product(String name, String category, String description, Double price, Long sellerId, String productType) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.sellerId = sellerId;
        this.productType = productType;

    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && name.equals(product.name) && category.equals(product.category)
                && description.equals(product.description) && price.equals(product.price)
                && sellerId.equals(product.sellerId) && productType.equals(product .productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, description, price, sellerId, productType);
    }
}

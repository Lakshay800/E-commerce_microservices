package com.lakshay.work.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@Entity
public class ProductType {
                                                //Name attributes, annotations, additonal fields type set,

    private @Id
    @GeneratedValue                             // foregn key attibute
    Long id;
      @ElementCollection                                       //jpa with set
    private Set<String>additionalFields;                        // jpa with element collection



    public ProductType(){


    }

    }


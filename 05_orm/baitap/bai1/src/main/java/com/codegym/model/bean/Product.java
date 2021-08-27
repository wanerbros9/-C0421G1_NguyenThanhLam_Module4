package com.codegym.model.bean;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String description;
    private String manufacture;

    public Product() {
    }

    public Product(String name, int price, String describe, String manufacture) {
        this.name = name;
        this.price = price;
        this.description = describe;
        this.manufacture = manufacture;
    }

    public Product(int id, String name, int price, String describe, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = describe;
        this.manufacture = manufacture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return description;
    }

    public void setDescribe(String describe) {
        this.description = describe;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}

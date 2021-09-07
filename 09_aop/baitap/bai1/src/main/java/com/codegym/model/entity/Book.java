package com.codegym.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private String content;
    private int amount;

    @OneToMany(mappedBy = "book")
    private Set<RentCode> rentCode;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<RentCode> getRentCode() {
        return rentCode;
    }

    public void setRentCode(Set<RentCode> rentCode) {
        this.rentCode = rentCode;
    }
}

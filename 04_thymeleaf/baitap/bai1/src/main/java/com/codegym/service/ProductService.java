package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Milk", 3000, "Liquid", "Vinamilk"));
        products.add(new Product(2, "Coffee", 5000, "Liquid", "Highlands"));
        products.add(new Product(3, "Chicken", 10000, "Meat", "KFC"));
        products.add(new Product(4, "Beef", 7000, "Meat", "McDonald"));
        products.add(new Product(5, "Burger", 12000, "Bread", "Burger King"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(products.get(products.size() - 1).getId() + 1);
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        for (Product product1 : products) {
            if (product1.getId() == product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescribe(product.getDescribe());
                product1.setManufacture(product.getManufacture());
            }
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name))
                return product;
        }
        return null;
    }
}

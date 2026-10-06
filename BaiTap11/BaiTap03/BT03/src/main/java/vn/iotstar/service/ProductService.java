package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.Product;

public interface ProductService {

    void insert(Product product);

    void update(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();
}
package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.Product;

public interface ProductDao {

    List<Product> getAll();

    Product get(int id);

    void insert(Product product);

    void update(Product product);

    void delete(int id);

    List<Product> getTop10Products();

    List<Product> getProductsByPage(int page, int pageSize);

    int countProducts();
}
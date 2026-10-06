package vn.iotstar.de1_22133037.dao;

import vn.iotstar.de1_22133037.entity.Author_22133037;

import java.util.List;

public interface AuthorDAO_22133037 {

    List<Author_22133037> findAll(int page, int size);

    long count();

    Author_22133037 findById(Integer id);

    Author_22133037 save(Author_22133037 author);

    Author_22133037 update(Author_22133037 author);

    void delete(Integer id);
}
package vn.iotstar.de1_22133037.dao;

import vn.iotstar.de1_22133037.entity.Book_22133037;

import java.util.List;

public interface BookDAO_22133037 {

    List<Book_22133037> findAll(int page, int size);

    long count();

    Book_22133037 findById(Integer id);

    Book_22133037 save(Book_22133037 book);

    Book_22133037 update(Book_22133037 book);

    void delete(Integer id);
}
package vn.iotstar.de1_22133037.service;

import vn.iotstar.de1_22133037.dao.BookDAO_22133037;
import vn.iotstar.de1_22133037.dao.BookDAOImpl_22133037;
import vn.iotstar.de1_22133037.entity.Book_22133037;

import java.util.List;

public class BookService_22133037 {

    private final BookDAO_22133037 dao =
            new BookDAOImpl_22133037();

    public List<Book_22133037> findAll(
            int page,
            int size) {

        return dao.findAll(page, size);
    }

    public long count() {
        return dao.count();
    }

    public Book_22133037 findById(Integer id) {
        return dao.findById(id);
    }

    public void save(Book_22133037 book) {
        dao.save(book);
    }

    public void update(Book_22133037 book) {
        dao.update(book);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }
}
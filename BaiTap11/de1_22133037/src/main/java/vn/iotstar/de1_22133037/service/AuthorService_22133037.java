package vn.iotstar.de1_22133037.service;

import vn.iotstar.de1_22133037.dao.AuthorDAO_22133037;
import vn.iotstar.de1_22133037.dao.AuthorDAOImpl_22133037;
import vn.iotstar.de1_22133037.entity.Author_22133037;

import java.util.List;

public class AuthorService_22133037 {

    private final AuthorDAO_22133037 dao =
            new AuthorDAOImpl_22133037();

    public List<Author_22133037> findAll(
            int page,
            int size) {

        return dao.findAll(page, size);
    }

    public long count() {
        return dao.count();
    }

    public Author_22133037 findById(Integer id) {
        return dao.findById(id);
    }

    public void save(Author_22133037 author) {
        dao.save(author);
    }

    public void update(Author_22133037 author) {
        dao.update(author);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }
}
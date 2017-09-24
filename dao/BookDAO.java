package dao;

import entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {

    void add(Book book) throws SQLException;

    List<Book> getAll() throws SQLException;

    Book getById(Long id) throws SQLException;

    void update(Book book) throws SQLException;

    void delete(Book book) throws SQLException;
}

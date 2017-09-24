package service;

import bl.SessionUtil;
import dao.BookDAO;
import entity.Book;
import org.hibernate.Session;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class BookService extends SessionUtil implements BookDAO {
    public void add(Book book) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(book);

        closeTransactionSession();
    }

    public List<Book> getAll() throws SQLException {
        openTransactionSession();

        String SQL = "SELECT * FROM BOOKLIST";
        Session session = getSession();

        Query query = session.createNativeQuery(SQL).addEntity(Book.class);
        List<Book> books = query.getResultList();

        closeTransactionSession();

        return books;
    }

    public Book getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM BOOKLIST WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Book.class);
        query.setParameter("id", id);

        Book book = (Book) query.getSingleResult();

        closeTransactionSession();

        return book;
    }

    public void update(Book book) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(book);

        closeTransactionSession();
    }

    public void delete(Book book) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(book);

        closeTransactionSession();
    }
}

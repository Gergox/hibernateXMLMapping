import bl.HibernateUtil;
import bl.SessionUtil;
import entity.Book;
import org.hibernate.Session;
import service.BookService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        //открываем сессию
        BookService bookService = new BookService();

        //создаем новую книгу для добавления
        Book book = new Book();
        book.setTitle("java with Hibernate");
        book.setAuthor("I don't know");
        book.setDescription("book about using hibernate with java");
        book.setNumberInRating(50);

        //сохраняем данные в бд
        try {
            bookService.add(book);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //делаем коммит, что бы прошла транзакция
        try {
            Book b = bookService.getById( 12l);
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //закрываем сессию
        HibernateUtil.shotdown();
    }
}

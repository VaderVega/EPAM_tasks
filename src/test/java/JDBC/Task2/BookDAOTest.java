package JDBC.Task2;

import JDBC.Task2.ConnectionPool.ConnectionPool;
import JDBC.Task2.DAO.BookDAO;
import JDBC.Task2.Model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class BookDAOTest {

    Connection connection;
    private Book book;
    private Book secondBook;
    private Book thirdBook;
    private BookDAO bookDAO;
    private ConnectionPool connectionPool;


    @Before
    public void setupObjects() {
        book = new Book("Harper Lee", "To kill a mockingbird", "Novel", 1);
        secondBook = new Book("John Ronald Reuel Tolkien", "The Silmarillion", "Fantasy", 1);
        thirdBook = new Book("John Ronald Reuel Tolkien", "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 1);

        connectionPool = new ConnectionPool();
        connectionPool.init();
        connection = connectionPool.getConnection();
        bookDAO = new BookDAO(connection);
    }

    @After
    public void close() {
        connectionPool.returnConnection(connection);
        connectionPool.closeConnections();
    }

    @Test
    public void insertBook() {
        bookDAO.insertBook(book);
        assertEquals(1, bookDAO.selectAll().size());
    }

    @Test
    public void updateName() {
        bookDAO.insertBook(secondBook);
        bookDAO.updateName(secondBook, "The Lord of the Rings: The Fellowship of the Ring");
        assertEquals("The Lord of the Rings: The Fellowship of the Ring", bookDAO.selectName(thirdBook));
    }

    @Test
    public void updateAuthor() {
        bookDAO.insertBook(book);
        bookDAO.updateAuthor(book, "Nelle Harper Lee");
        assertEquals("Nelle Harper Lee", bookDAO.selectAuthor(book));
    }

}

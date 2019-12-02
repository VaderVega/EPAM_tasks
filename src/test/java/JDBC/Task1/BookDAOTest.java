package JDBC.Task1;

import JDBC.Task1.DAO.BookDAO;
import JDBC.Task1.DAO.SQLConnection;
import JDBC.Task1.Model.Book;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class BookDAOTest {
    Connection connection;
    BookDAO bookDAO;
    Book book;

    @Before
    @SneakyThrows
    public void setConnection() {
        connection = SQLConnection.getInstance().getConnection();
        bookDAO = new BookDAO(connection);
    }

    @Before
    public void createBook() {
        book = new Book("Jon Kleinberg, Eva Tardos", "Algorithm Design", "Computer Science", 1);
        setConnection();
    }



    @After
    @SneakyThrows
    public void close() {
        connection.close();
    }

    @Test
    public void select() {
        assertEquals(1, bookDAO.selectBook("Algorithm Design").size());
    }

    @Test
    public void update() {
        bookDAO.updateGenre("Algorithm Design", "Classic of Computer Science");
        assertEquals(1, bookDAO.selectBook("Algorithm Design").size());
    }

    @Test
    public void delete() {
        bookDAO.deleteTable("todelete");
    }
}

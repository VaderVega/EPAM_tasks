package JDBC.Task2.DAO;

import JDBC.Task2.Model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

    private String query = "";
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public List<String> selectBook(String name) {
        List<String> books = new ArrayList<>();
        query = "SELECT name FROM homelibrary WHERE name=" + "'" + name + "'";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                books.add(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> selectAll() {
        query = "SELECT * FROM homelibrary";
        List<Book> bookList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                bookList.add(new Book(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public String selectAuthor(Book book) {
        query = "SELECT author FROM homelibrary WHERE name='" + book.getName() + "'";
        String author = "";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                author = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public String selectName(Book book) {
        query = "SELECT name FROM homelibrary WHERE name='" + book.getName() + "'";
        String name = "";

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
                name = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public void insertBook(Book book) {
        query = "INSERT INTO homelibrary(author, name, genre, volumes) VALUES(?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getName());
            statement.setString(3, book.getGenre());
            statement.setInt(4, book.getVolumes());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGenre(String name, String genre) {
        query = "UPDATE homelibrary SET name=" + "'" + name + "'" + "WHERE genre=" + "'" + genre + "'";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateName(Book book, String newName) {
        query = "UPDATE homelibrary SET name=" + "'" + newName + "'" + "WHERE author='" + book.getAuthor()+"'";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

     public void updateAuthor(Book book, String newAuthor) {
        query = "UPDATE homelibrary SET author=" + "'" + newAuthor + "'" + "WHERE author='" + book.getAuthor() + "'";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

     public void deleteBook(Book book) {
        query = "DELETE FROM homelibrary WHERE name=" + "'" + book.getName() + "'";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

    public void deleteTable(String table) {
        query = "DROP TABLE " + table;

        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

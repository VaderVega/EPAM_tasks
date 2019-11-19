package IOStreams.Task4;

import java.io.*;
import java.util.Objects;
import java.util.Set;

public class MovieCollection {
    private final String name;
    private Set<Movie> movies;

    public MovieCollection(String name) {
        this.name = name;
    }

    public MovieCollection(String name, Set<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void deleteMovie(Movie movie) {
        movies.remove(movie);
    }

    public void writeToFile(File file) {
        try(ObjectOutputStream objectInputStream = new ObjectOutputStream(
                new FileOutputStream(file))) {
            objectInputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MovieCollection readFromFile(File file) {
        MovieCollection collection = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file)
        )) {
            collection = (MovieCollection) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return collection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCollection that = (MovieCollection) o;
        return name.equals(that.name) &&
                Objects.equals(movies, that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movies);
    }

    @Override
    public String toString() {
        return "MovieCollection{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}

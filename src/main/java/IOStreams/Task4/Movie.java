package IOStreams.Task4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Movie {
    private final String name;
    private final Set<Actor> actors;

    public Movie(String name) {
        this.name = name;
        actors = new HashSet<>();
    }

    public Movie(String name, Set<Actor> actors) {
        this.name = name;
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void deleteActor(Actor actor) {
        actors.remove(actor);
    }

    public String getName() {
        return name;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", actors=" + actors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return name.equals(movie.name) &&
                Objects.equals(actors, movie.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, actors);
    }
}

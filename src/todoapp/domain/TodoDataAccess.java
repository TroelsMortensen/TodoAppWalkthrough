package todoapp.domain;

import todoapp.domain.Todo;

import java.util.List;

public interface TodoDataAccess {
    void add(Todo todo);

    void update(Todo todo);

    void delete(int id);

    List<Todo> getAll();

    Todo get(int id);
}

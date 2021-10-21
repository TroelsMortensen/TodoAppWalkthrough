package todoapp.logic;

import todoapp.model.Todo;

import java.util.List;

public interface TodoLogic {

    void add(Todo todo);

    void update(Todo todo);

    void delete(int id);

    List<Todo> getAll();

    Todo get(int id);
}

package todoapp.view.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import todoapp.domain.TodoLogic;
import todoapp.domain.Todo;

import java.util.List;

public class ListViewModel {
    private TodoLogic todoLogic;
    private ObservableList<Todo> todos = FXCollections.observableArrayList();

    public ListViewModel(TodoLogic todoLogic) {
        this.todoLogic = todoLogic;
    }

    public void loadData() {
        List<Todo> all = todoLogic.getAll();
        todos.addAll(all);
    }

    public ObservableList<Todo> getTodos() {
        return todos;
    }

    public void updateTodo(Todo todo) {
        todoLogic.update(todo);
    }

    public void deleteTodo(int id) {
        todoLogic.delete(id);
        if(!todos.removeIf(todo -> todo.getId() == id)) {
            throw new RuntimeException("Todo with id " + id + " could not be found in the table");
        }
    }
}

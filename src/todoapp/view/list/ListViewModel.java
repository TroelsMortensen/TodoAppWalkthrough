package todoapp.view.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import todoapp.logic.TodoLogic;
import todoapp.model.Todo;

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
}

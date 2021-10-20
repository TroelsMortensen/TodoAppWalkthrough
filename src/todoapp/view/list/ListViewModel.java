package todoapp.view.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import todoapp.model.Todo;
import todoapp.model.TodoService;

import java.util.List;

public class ListViewModel {
    private TodoService todoService;
    private ObservableList<Todo> todos = FXCollections.observableArrayList();

    public ListViewModel(TodoService todoService) {
        this.todoService = todoService;
    }

    public void loadData() {
        List<Todo> all = todoService.getAll();
        todos.addAll(all);
    }

    public ObservableList<Todo> getTodos() {
        return todos;
    }
}

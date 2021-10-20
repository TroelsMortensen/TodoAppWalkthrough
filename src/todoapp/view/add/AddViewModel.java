package todoapp.view.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import todoapp.model.Todo;
import todoapp.model.TodoService;

public class AddViewModel {

    private TodoService todoService;
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();

    public AddViewModel(TodoService todoService){
        this.todoService = todoService;
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void addTodo() {
        Todo todo = new Todo(owner.getValue(), description.getValue());
        todoService.add(todo);
    }
}

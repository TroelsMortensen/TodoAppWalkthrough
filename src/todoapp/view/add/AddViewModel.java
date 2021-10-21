package todoapp.view.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import todoapp.domain.TodoLogic;
import todoapp.domain.Todo;

public class AddViewModel {

    private TodoLogic todoLogic;
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();

    public AddViewModel(TodoLogic todoLogic){
        this.todoLogic = todoLogic;
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void addTodo() {
        Todo todo = new Todo(owner.getValue(), description.getValue());
        todoLogic.add(todo);
    }
}

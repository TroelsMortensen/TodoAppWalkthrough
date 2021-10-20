package todoapp.view.update;

import javafx.beans.property.*;
import todoapp.model.Todo;
import todoapp.model.TodoService;

public class UpdateViewModel {

    private TodoService todoService;
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private BooleanProperty completed = new SimpleBooleanProperty();
    private Todo todo;

    public UpdateViewModel(TodoService todoService) {
        this.todoService = todoService;
    }

    void load(int id) {
        todo = todoService.get(id);

        owner.setValue(todo.getOwner());
        description.setValue(todo.getText());
        this.id.setValue(todo.getId());
        completed.setValue(todo.getCompleted());
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public BooleanProperty completedProperty() {
        return completed;
    }

    public void save() {
        todo.setOwner(owner.getValue());
        todo.setText(description.getValue());
        todoService.update(todo);
    }
}

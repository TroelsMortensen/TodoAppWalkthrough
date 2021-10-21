package todoapp.view.update;

import javafx.beans.property.*;
import todoapp.domain.TodoLogic;
import todoapp.domain.Todo;

public class UpdateViewModel {

    private TodoLogic todoLogic;
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private BooleanProperty completed = new SimpleBooleanProperty();
    private Todo todo;

    public UpdateViewModel(TodoLogic todoLogic) {
        this.todoLogic = todoLogic;
    }

    void load(int id) {
        todo = todoLogic.get(id);

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
        todoLogic.update(todo);
    }
}

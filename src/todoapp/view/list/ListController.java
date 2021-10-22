package todoapp.view.list;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import todoapp.core.ViewHandler;
import todoapp.domain.Todo;

public class ListController {

    public TableView<Todo> tableView;
    public TableColumn<Todo, Integer> idColumn;
    public TableColumn<Todo, String> ownerColumn;
    public TableColumn<Todo, String> textColumn;
    public TableColumn<Todo, CheckBox> statusColumn;
    public TableColumn<Todo, Button> editColumn;
    public TableColumn<Todo, Button> deleteColumn;

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ListViewModel listVM) {
        this.viewHandler = viewHandler;
        listVM.loadData();
        tableView.setItems(listVM.getTodos());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ownerColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
        textColumn.setCellValueFactory(new PropertyValueFactory<>("text"));

        statusColumn.setCellValueFactory(arg -> {
                    CheckBox checkBox = new CheckBox();
                    Todo todo = arg.getValue();
                    checkBox.selectedProperty().setValue(todo.getCompleted());

                    checkBox.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
                        todo.setCompleted(newValue);
                        listVM.updateTodo(todo);

                    });

                    return new SimpleObjectProperty<>(checkBox);
                }
        );

        editColumn.setCellValueFactory(arg -> {
                    Button button = new Button("Edit");
                    Todo todo = arg.getValue();

                    button.setOnAction(evt -> {
                                viewHandler.openEditView(todo.getId());
                            }
                    );

                    return new SimpleObjectProperty<>(button);
                }
        );

        deleteColumn.setCellValueFactory(arg -> {
            Button button = new Button("Del");
            Todo todo = arg.getValue();

            button.setOnAction(evt -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete todo?", ButtonType.OK, ButtonType.CANCEL);
                    alert.showAndWait();
                    if(alert.getResult() == ButtonType.OK){
                        listVM.deleteTodo(todo.getId());
                    }
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE).showAndWait();
                }
            });


            return new SimpleObjectProperty<>(button);
        });
    }

    public void onAddButton() {
        viewHandler.openAddView();
    }
}


































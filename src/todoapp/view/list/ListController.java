package todoapp.view.list;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    }

    public void onAddButton() {
        viewHandler.openAddView();
    }
}

package todoapp.view.list;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import todoapp.core.ViewHandler;
import todoapp.model.Todo;

public class ListController {

    public TableView<Todo> tableView;
    public TableColumn<Todo, Integer> idColumn;
    public TableColumn<Todo, String> ownerColumn;
    public TableColumn<Todo, String> textColumn;
    public TableColumn<Todo, Boolean> statusColumn;

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ListViewModel listVM) {
        this.viewHandler = viewHandler;
        listVM.loadData();
        tableView.setItems(listVM.getTodos());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ownerColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
        textColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));
    }

    public void onAddButton() {
        viewHandler.openAddView();
    }
}

package todoapp.view.add;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import todoapp.core.ViewHandler;

public class AddController {

    public TextField ownerTextField;
    public TextField descriptionTextField;
    private ViewHandler viewHandler;
    private AddViewModel addVM;

    public void init(ViewHandler viewHandler, AddViewModel addVM){
        this.viewHandler = viewHandler;
        this.addVM = addVM;
        ownerTextField.textProperty().bindBidirectional(addVM.ownerProperty());
        descriptionTextField.textProperty().bindBidirectional(addVM.descriptionProperty());
    }

    public void onOkButton() {
        try {
            addVM.addTodo();
            viewHandler.openListView();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    public void onCancelButton() {
        viewHandler.openListView();
    }
}

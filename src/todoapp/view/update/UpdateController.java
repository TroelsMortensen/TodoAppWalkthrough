package todoapp.view.update;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import todoapp.core.ViewHandler;

public class UpdateController {
    public TextField idField;
    public TextField ownerField;
    public TextField descriptionField;
    public CheckBox completedBox;
    private ViewHandler viewHandler;
    private UpdateViewModel vm;

    public void init(ViewHandler viewHandler, UpdateViewModel vm, int id) {
        this.viewHandler = viewHandler;
        this.vm = vm;
        Bindings.bindBidirectional(idField.textProperty(), vm.idProperty(), new NumberStringConverter());
        ownerField.textProperty().bindBidirectional(vm.ownerProperty());
        descriptionField.textProperty().bindBidirectional(vm.descriptionProperty());
        completedBox.selectedProperty().bind(vm.completedProperty());

        vm.load(id);
    }

    public void onSaveButton() {
        try {
            vm.save();
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

package todoapp.view.add;

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
            e.printStackTrace();
            // TODO handle this better
        }
    }

    public void onCancelButton() {
        viewHandler.openListView();
    }
}

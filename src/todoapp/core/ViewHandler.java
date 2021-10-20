package todoapp.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import todoapp.view.add.AddController;
import todoapp.view.list.ListController;
import todoapp.view.update.UpdateController;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
        stage = new Stage();
    }

    public void start() {
        openListView();
        stage.show();
    }

    public void openListView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/list/List.fxml"));
            Parent root = loader.load();

            ListController controller = loader.getController();
            controller.init(this, vmf.getListVM());

            Scene scene = new Scene(root);
            stage.setTitle("View all");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAddView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/add/Add.fxml"));
            Parent root = loader.load();

            AddController controller = loader.getController();
            controller.init(this, vmf.getAddVM());

            Scene scene = new Scene(root);
            stage.setTitle("Add todo");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openEditView(int id) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/update/Update.fxml"));
            Parent root = loader.load();

            UpdateController controller = loader.getController();
            controller.init(this, vmf.getUpdateVM(), id);

            Scene scene = new Scene(root);
            stage.setTitle("Update todo");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




































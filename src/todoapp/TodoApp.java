package todoapp;

import javafx.application.Application;
import javafx.stage.Stage;
import todoapp.core.ModelFactory;
import todoapp.core.ViewHandler;
import todoapp.core.ViewModelFactory;

public class TodoApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}

package todoapp;

import javafx.application.Application;
import javafx.stage.Stage;
import todoapp.core.LogicFactory;
import todoapp.core.DataAccessFactory;
import todoapp.core.ViewHandler;
import todoapp.core.ViewModelFactory;

public class TodoApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DataAccessFactory daf = new DataAccessFactory();
        LogicFactory lf = new LogicFactory(daf);
        ViewModelFactory vmf = new ViewModelFactory(lf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}

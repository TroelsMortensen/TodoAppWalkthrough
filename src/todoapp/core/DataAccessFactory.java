package todoapp.core;

import todoapp.model.TodoFileService;
import todoapp.model.TodoDataAccess;

public class DataAccessFactory {

    private TodoDataAccess todoService;

    public TodoDataAccess getTodoDataAccess() {
        if(todoService == null) {
            todoService = new TodoFileService();
        }
        return todoService;
    }
}

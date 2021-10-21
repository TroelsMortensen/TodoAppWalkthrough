package todoapp.core;

import todoapp.dataaccess.TodoFileService;
import todoapp.domain.TodoDataAccess;

public class DataAccessFactory {

    private TodoDataAccess todoService;

    public TodoDataAccess getTodoDataAccess() {
        if(todoService == null) {
            todoService = new TodoFileService();
        }
        return todoService;
    }
}

package todoapp.core;

import todoapp.model.TodoFileService;
import todoapp.model.TodoService;

public class ModelFactory {

    private TodoService todoService;

    public TodoService getTodoService() {
        if(todoService == null) {
            todoService = new TodoFileService();
        }
        return todoService;
    }
}

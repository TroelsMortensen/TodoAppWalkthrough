package todoapp.core;

import todoapp.logic.TodoLogic;
import todoapp.logic.TodoLogicImpl;

public class LogicFactory {

    private DataAccessFactory dataAccessFactory;

    public LogicFactory(DataAccessFactory dataAccessFactory) {
        this.dataAccessFactory = dataAccessFactory;
    }

    public TodoLogic getTodoLogic() {
        return new TodoLogicImpl(dataAccessFactory.getTodoDataAccess());
    }
}

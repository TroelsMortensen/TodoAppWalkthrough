package todoapp.core;

import todoapp.domain.TodoLogic;
import todoapp.domain.TodoLogicImpl;

public class DomainFactory {

    private DataAccessFactory dataAccessFactory;

    public DomainFactory(DataAccessFactory dataAccessFactory) {
        this.dataAccessFactory = dataAccessFactory;
    }

    public TodoLogic getTodoLogic() {
        return new TodoLogicImpl(dataAccessFactory.getTodoDataAccess());
    }
}

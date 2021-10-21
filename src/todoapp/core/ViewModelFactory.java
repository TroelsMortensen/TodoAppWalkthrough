package todoapp.core;

import todoapp.view.add.AddViewModel;
import todoapp.view.list.ListViewModel;
import todoapp.view.update.UpdateViewModel;

public class ViewModelFactory {

    private DomainFactory logicFactory;

    public ViewModelFactory(DomainFactory logicFactory) {
        this.logicFactory = logicFactory;
    }

    public ListViewModel getListVM() {
        return new ListViewModel(logicFactory.getTodoLogic());
    }

    public AddViewModel getAddVM() {
        return new AddViewModel(logicFactory.getTodoLogic());
    }

    public UpdateViewModel getUpdateVM() {
        return new UpdateViewModel(logicFactory.getTodoLogic());
    }
}

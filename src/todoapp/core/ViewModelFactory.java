package todoapp.core;

import todoapp.model.TodoService;
import todoapp.view.add.AddViewModel;
import todoapp.view.list.ListViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ListViewModel getListVM() {
        return new ListViewModel(modelFactory.getTodoService());
    }

    public AddViewModel getAddVM() {
        return new AddViewModel(modelFactory.getTodoService());
    }


}

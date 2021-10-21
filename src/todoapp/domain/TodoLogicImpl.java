package todoapp.domain;

import java.util.List;

public class TodoLogicImpl implements TodoLogic{

    private TodoDataAccess todoDataAccess;

    public TodoLogicImpl(TodoDataAccess todoDataAccess) {
        this.todoDataAccess = todoDataAccess;
    }

    @Override
    public void add(Todo todo) {
        validateTodo(todo);
        todoDataAccess.add(todo);
    }

    @Override
    public void update(Todo todo) {
        validateTodo(todo);
        todoDataAccess.update(todo);
    }

    private void validateTodo(Todo todo) {
        if (todo.getOwner() == null || "".equals(todo.getOwner())) {
            throw new RuntimeException("Owner cannot be empty");
        }
        if (todo.getText() == null || "".equals(todo.getText())) {
            throw new RuntimeException("Description cannot be empty");
        }
    }

    @Override
    public void delete(int id) {
        Todo todo = get(id);
        if(!todo.getCompleted()) {
            throw new RuntimeException("Cannot delete uncompleted todo");
        }
        todoDataAccess.delete(id);
    }

    @Override
    public List<Todo> getAll() {
        return todoDataAccess.getAll();
    }

    @Override
    public Todo get(int id) {
        return todoDataAccess.get(id);
    }
}

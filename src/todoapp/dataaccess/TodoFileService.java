package todoapp.dataaccess;

import todoapp.domain.Todo;
import todoapp.domain.TodoDataAccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoFileService implements TodoDataAccess {

    private String path = "todos.bin";

    private List<Todo> seed() {
        List<Todo> list = new ArrayList<>();
        Todo t1 = new Todo("Troels", "walk the dog");
        t1.setId(1);
        list.add(t1);
        Todo t2 = new Todo("Troels", "Do the dishes");
        t2.setId(2);
        list.add(t2);
        Todo t3 = new Todo("Hans", "Mow the lawn");
        t3.setId(3);
        list.add(t3);
        Todo t4 = new Todo("Anne", "Pet the dog");
        t4.setId(4);
        list.add(t4);
        return list;
    }

    private List<Todo> readTodos() {
        List<Todo> list = new ArrayList<>();
        File file = new File(path);

        if(file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ArrayList<Todo>) ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                // todo fix this
            }
        } else {
            list = seed();
        }
        return list;
    }

    public void saveChanges(List<Todo> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("Problem saving data: " + e.getMessage());
        }
    }

    @Override
    public void add(Todo todo) {
        List<Todo> list = getAll();
        int max = 0;
        for (Todo t : list) {
            if(t.getId() > max) max = t.getId();
        }
        int id = (max+1);
        todo.setId(id);
        list.add(todo);
        saveChanges(list);
    }

    @Override
    public void update(Todo todo) {
        List<Todo> list = getAll();
        Todo found = null;
        for (Todo t : list) {
            if(t.getId() == todo.getId()) {
                found = t;
                break;
            }
        }

        if(found == null) {
            throw new RuntimeException("Todo with id " + todo.getId() + " could not be found");
        }

        found.setCompleted(todo.getCompleted());
        found.setOwner(todo.getOwner());
        found.setText(todo.getText());

        saveChanges(list);
    }

    @Override
    public void delete(int id) {
        List<Todo> list = readTodos();
        list.removeIf(t -> t.getId() == id);
        saveChanges(list);
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> list = readTodos();
        return new ArrayList<>(list);
    }

    @Override
    public Todo get(int id) {
        List<Todo> list = getAll();
        for (Todo todo : list) {
            if(todo.getId() == id) return todo;
        }
        throw new RuntimeException("Tood with id " + id + " not found.");
    }
}

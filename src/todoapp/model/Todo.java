package todoapp.model;

import java.io.Serializable;

public class Todo implements Serializable {

    private int id;
    private String owner;
    private String text;
    private boolean completed;

    public Todo(String owner, String text) {
        this.owner = owner;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

package model;

public class Subtask extends Task {
    private long epicId;

    public Subtask(long id, String name, String description, Status status) {
        super(id, name, description, status);
    }

    public Subtask(long id, String name, String description, Status status, long epicId) {
        super(id, name, description, status);
        this.epicId = epicId;
    }

    public long getEpicId() {
        return epicId;
    }

    public void setEpicId(long epicId) {
        this.epicId = epicId;
    }
}

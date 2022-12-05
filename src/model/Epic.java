package model;

import java.util.List;

public class Epic extends Task {
    private List<Long> subtasksId;

    public Epic(long id, String name, String description, Status status) {
        super(id, name, description, status);
    }

    public void addSubtaskId(long id) {
        subtasksId.add(id);
    }

    public List<Long> getSubtasksId() {
        return subtasksId;
    }

    public void setSubtasksId(List<Long> subtasksId) {
        this.subtasksId = subtasksId;
    }
}

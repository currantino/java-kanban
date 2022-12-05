package model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Long> subtasksId;

    public Epic(String name, String description) {
        super(name, description);
        subtasksId = new ArrayList<>();
    }

    public Epic(long id, String name, String description) {
        super(id, name, description);
        subtasksId = new ArrayList<>();
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", subtasksId=" + getSubtasksId() +
                '}';
    }
}

package manager;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private long nextTaskId;
    private long nextSubtaskId;
    private long nextEpicId;
    private Map<Long, Task> tasks;
    private Map<Long, Subtask> subtasks;
    private Map<Long, Epic> epics;

    public Manager() {
        nextTaskId = 1;
        nextSubtaskId = 1;
        nextEpicId = 1;
        tasks = new HashMap<>();
        subtasks = new HashMap<>();
        epics = new HashMap<>();
    }

    public Map<Long, Task> getTasks() {
        return tasks;
    }

    public Map<Long, Subtask> getSubtasks() {
        return subtasks;
    }

    public Map<Long, Epic> getEpics() {
        return epics;
    }

    public void removeAllTasks() {
        tasks.clear();
    }

    public void removeAllSubtasks() {
        subtasks.clear();
    }

    public void removeAllEpics() {
        epics.clear();
    }

    public Task getTaskById(long id) {
        return tasks.get(id);
    }

    public Subtask getSubtaskById(long id) {
        return subtasks.get(id);
    }

    public Epic getEpicById(long id) {
        return epics.get(id);
    }

    public void removeTaskById(long id) {
        tasks.remove(id);
    }

    public void removeSubtaskById(long id) {
        subtasks.remove(id);
    }

    public void removeEpicById(long id) {
        epics.remove(id);
    }

    public void addTask(Task task) {
        task.setId(getTaskNextId());
        tasks.put(task.getId(), task);
    }

    public void addSubtask(Subtask subtask) {
        long epicId = subtask.getEpicId();
        if (epics.containsKey(epicId)) {
            long subtaskId = getNextSubtaskId();
            subtask.setId(subtaskId);
            subtasks.put(subtaskId, subtask);
            Epic epic = epics.get(epicId);
            epic.addSubtaskId(subtaskId);
            epic.setStatus(calculateStatusOfEpic(epic));
        }

    }

    private Status calculateStatusOfEpic(Epic epic) {
        int newStatusCounter = 0;
        int inProgressStatusCounter = 0;
        int doneStatusCounter = 0;
        List<Long> subtasksId = epic.getSubtasksId();
        for (Long subtaskId : subtasksId) {
            Status statusOfSubtask = subtasks.get(subtaskId).getStatus();
            if (statusOfSubtask.equals(Status.NEW)) {
                newStatusCounter++;
            } else if (statusOfSubtask.equals(Status.IN_PROGRESS)) {
                inProgressStatusCounter++;
            } else if (statusOfSubtask.equals(Status.DONE)) {
                doneStatusCounter++;
            }
        }
        if (newStatusCounter == subtasksId.size()) return Status.NEW;
        else if (inProgressStatusCounter > 0) return Status.IN_PROGRESS;
        else if (doneStatusCounter == subtasksId.size()) return Status.DONE;
        return null;
    }


    public void addEpic(Epic epic) {
        epic.setId(getNextEpicId());
    }

    private long getTaskNextId() {
        return nextTaskId++;
    }

    private long getNextSubtaskId() {
        return nextSubtaskId++;
    }

    private long getNextEpicId() {
        return nextEpicId++;
    }

}

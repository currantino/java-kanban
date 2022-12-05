import manager.Manager;
import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;


public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();

        printTestSeparator();
        System.out.println("Task methods testing:\n");

        Task task1 = new Task("Task 1", "Description of Task 1");
        Task task2 = new Task("Task 2", "Description of Task 2");

        manager.addTask(task1);
        manager.addTask(task2);

        System.out.println(manager.getTasks());

        Task updatedTask1 = new Task(task1.getId(),
                "Updated Task 1",
                "Updated description of Task 1",
                Status.IN_PROGRESS);
        Task updatedTask2 = new Task(task2.getId(),
                "Updated Task 2",
                "Updated description of Task 2",
                Status.DONE);

        manager.updateTask(updatedTask1);
        manager.updateTask(updatedTask2);

        System.out.println(manager.getTasks());

        manager.removeTaskById(2);

        System.out.println(manager.getTasks());
        System.out.println(manager.getTaskById(1));

        manager.removeAllTasks();

        System.out.println(manager.getTasks());

        printTestSeparator();
        System.out.println("Epic methods testing:\n");

        Epic epic1 = new Epic("Epic 1", "Description of Epic 1");
        Epic epic2 = new Epic("Epic 2", "Description of Epic 2");

        manager.addEpic(epic1);
        manager.addEpic(epic2);

        Subtask subtask1OfEpic1 = new Subtask("Subtask 1 of Epic 1",
                "Description of Subtask 1 of Epic 1",
                epic1.getId());
        Subtask subtask2OfEpic1 = new Subtask("Subtask 2 of Epic 1",
                "Description of Subtask 2 of Epic 2",
                epic1.getId());
        Subtask subtask1OfEpic2 = new Subtask("Subtask 1 of Epic 2",
                "Description of Subtask 1 of Epic 2",
                epic2.getId());

        manager.addSubtask(subtask1OfEpic1);
        manager.addSubtask(subtask2OfEpic1);
        manager.addSubtask(subtask1OfEpic2);

        System.out.println(manager.getEpics());

        Subtask updatedSubtask1OfEpic1 = new Subtask(
                subtask1OfEpic1.getId(),
                "Updated Subtask 1 of Epic 1",
                "Description of Updated Subtask 1 of Epic 1",
                Status.IN_PROGRESS,
                epic1.getId()
        );

        manager.updateSubtask(updatedSubtask1OfEpic1);

        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());
        System.out.println(manager.getSubtaskById(1));

        Subtask updatedSubtask1OfEpic2 = new Subtask(
                subtask1OfEpic2.getId(),
                "Updated Subtask 1 of Epic 2",
                "Description of Updated Subtask 1 of Epic 2",
                Status.DONE,
                epic2.getId()
        );

        manager.updateSubtask(updatedSubtask1OfEpic2);

        System.out.println(manager.getEpicById(2));

        printTestSeparator();
        System.out.println("Subtask methods testing:\n");

        Epic updatedEpic2 = new Epic(epic2.getId(), "Updated Epic 2", "Updated description of Epic 2");

        manager.updateEpic(updatedEpic2);
        System.out.println(manager.getEpicById(2));
        manager.removeEpicById(2);
        System.out.println(manager.getSubtasks());

        manager.removeSubtaskById(subtask1OfEpic1.getId());

        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());
        System.out.println(manager.getSubtasksOfEpic(epic1));

        manager.removeAllSubtasks();
        manager.removeAllEpics();
        manager.removeAllTasks();

        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());
    }

    private static void printTestSeparator() {
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    }

}
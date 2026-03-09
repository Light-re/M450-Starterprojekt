import java.util.ArrayList;
import java.util.List;

public class TaskManagerRefactored {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        for (Task task : tasks) {
            System.out.println("Task: " + task.getName());
            System.out.println("Status: " + task.getStatus());
        }
    }
}

class Task {
    private final String name;
    private final String status;

    public Task(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}

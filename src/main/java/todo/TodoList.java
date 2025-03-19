package todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;
    private int nbrOfTasks;
    private int finishedTasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
        nbrOfTasks = 0;
        finishedTasks = 0;
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        nbrOfTasks++;
    }

    public void completeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            if (!tasks.get(taskIndex).isCompleted()) {
                task.complete();
                finishedTasks++;
            }
        }
    }

    public int getNbrOfTasks() {
        return nbrOfTasks;
    }

    public int getFinishedTasks() {
        return finishedTasks;
    }

    public boolean isTaskFinished(int taskIndex) {
        boolean finished = false;
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            finished = tasks.get(taskIndex).isCompleted();
        }
        return finished;
    }

    public boolean isListFinished() {
        boolean finished = false;
        if (nbrOfTasks - finishedTasks == 0) {
            finished = true;
        }
        return finished;
    }

    public List<Task> getTasks() {
        return tasks;
    }


    public String getList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(tasks.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}

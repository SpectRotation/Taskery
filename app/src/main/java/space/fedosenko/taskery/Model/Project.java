package space.fedosenko.taskery.Model;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;

public class Project {
 private String name;
 private ArrayList<Task> tasks;

    public Project(String name, ArrayList<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}

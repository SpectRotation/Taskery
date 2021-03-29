package space.fedosenko.taskery.Model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;

public class Storage {
    private static Storage instance = null;
    private SharedPreferences sharedPreferences;
    private Context context;
    ArrayList<Task> tasks = new ArrayList<>();

    private Storage(Context context){
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);
    }
    public static Storage getInstance(Context context){
        if (instance==null){
            instance = new Storage(context);
        }
        return instance;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks){
        this.tasks=tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void initTest(){
        Task task1 = new Task("Test task 1", "test description 1");
        Task task2 = new Task("Test task 2", "test description 2");
        Task task3 = new Task("Test task 3", "test description 3");
        Task task4 = new Task("Test task 4", "test description 4");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
    }
    public void saveDate(){
        SharedPreferences.Editor editor = sharedPreferences.edit();

    }

}

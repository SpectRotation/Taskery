package space.fedosenko.taskery.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;

public class Storage {
    private static Storage instance = null;
    private static final String ALL_TASKS_KEY = "all tasks";
    private SharedPreferences sharedPreferences;
    private Context context;

    private  ArrayList<Task> tasks;

    private Storage(Context context){
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if (null == tasks){
            tasks = getTasks();
        }
        if (tasks==null){

            initData();
        }
    }
    public static Storage getInstance(Context context){
        if (instance==null){
            instance = new Storage(context);
        }
        return instance;
    }

    public ArrayList<Task> getTasks(){
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Task>>(){}.getType();
        tasks = gson.fromJson(sharedPreferences.getString(ALL_TASKS_KEY, null), type) ;
        return tasks;
    }
    public void changeTaskState(int position){
        tasks.get(position).changeState();
        saveData();
    }

    public void setTasks(ArrayList<Task> tasks){
        this.tasks=tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
        saveData();
    }
    public void removeTask(int position){
        tasks.remove(position);
        saveData();
    }
    public void initData(){
        tasks = new ArrayList<>();
        Task task1 = new Task("Test task 1", "test description 1");
        Task task2 = new Task("Test task 2", "test description 2");
        Task task3 = new Task("Test task 3", "test description 3");
        Task task4 = new Task("Test task 4", "test description 4");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
    }
    public void saveData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_TASKS_KEY, gson.toJson(tasks));
        editor.apply();
    }

}

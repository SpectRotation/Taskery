package space.fedosenko.taskery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;
import space.fedosenko.taskery.Model.ProjectsMenu;
import space.fedosenko.taskery.Model.Storage;

public class MainActivity extends AppCompatActivity implements NewTaskDialog.PassTaskInterface {

    public static final String TASK_KEY="task";
    private RecyclerView tasksRecView;
    private FloatingActionButton floatingActionButton, btProjectsMenu;
    private TaskRecViewAdapter adapter;
    private ArrayList<Task> tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        adapter = new TaskRecViewAdapter(this);
        tasksRecView = findViewById(R.id.tasksRecyclerView);
        tasksRecView.setAdapter(adapter);
        tasksRecView.setLayoutManager(new LinearLayoutManager(this));
        btProjectsMenu=findViewById(R.id.bt_projects_menu);
        btProjectsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProjectsMenu.class);
                startActivity(intent);
            }
        });


        Storage.getInstance().addTask(new Task("First Task", "It is a first task you have"));
        tasks= Storage.getInstance().getTasks();
        adapter.setTasks(tasks);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewTaskDialog dialog = new NewTaskDialog();
                Bundle bundle = new Bundle();
                bundle.putParcelable(TASK_KEY,new Task("Parcelable","Parcelable task"));
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "Task detail dialog");

                adapter.setTasks(tasks);
            }
        });

    }

    @Override
    public void getPlan(Task task) {
        Storage.getInstance().addTask(task);
    }
}
package space.fedosenko.taskery.Model;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;
import space.fedosenko.taskery.ProjectsRecViewAdapter;
import space.fedosenko.taskery.R;

public class ProjectsMenu extends AppCompatActivity {
    private RecyclerView projectsRecyclerView;
    private Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projects_menu);
        projectsRecyclerView=findViewById(R.id.projectRecView);

        init();
    }

private void init(){



    ArrayList<Project> projects = new ArrayList<>();
    Task task1 = new Task("Task 1");
    Task task2 = new Task("Task 2");
    Task task3 = new Task("Task 3");
    ArrayList<Task> project1 = new ArrayList<>();
    project1.add(task1);
    project1.add(task2);
    project1.add(task3);
    projects.add(new Project("project 1", project1));
    Task task4 = new Task("Task 1 for project 2");
    Task task5 = new Task("Task 2 for project 2");
    Task task6 = new Task("Task 3 for project 2");
    ArrayList<Task> project2 = new ArrayList<>();
    project2.add(task4);
    project2.add(task5);
    project2.add(task6);
    projects.add(new Project("project 2", project2));
    mContext=this;
    ProjectsRecViewAdapter adapter = new ProjectsRecViewAdapter(mContext);
    adapter.setProjects(projects);

    projectsRecyclerView.setAdapter(adapter);
    projectsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

}
}

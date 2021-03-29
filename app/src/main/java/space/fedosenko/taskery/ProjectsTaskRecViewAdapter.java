package space.fedosenko.taskery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;
import space.fedosenko.taskery.Model.Project;

public class ProjectsTaskRecViewAdapter extends RecyclerView.Adapter<ProjectsTaskRecViewAdapter.ViewHolder> {

    private ArrayList<Task> tasks = new ArrayList<>();

    public ProjectsTaskRecViewAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_task_menu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTaskName.setText(tasks.get(position).getName());
        //holder.recyclerView
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTaskName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTaskName = itemView.findViewById(R.id.txtTaskName);


        }
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks= tasks;
        notifyDataSetChanged();
    }
}

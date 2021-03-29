package space.fedosenko.taskery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Project;
import space.fedosenko.taskery.Model.ProjectsMenu;

public class ProjectsRecViewAdapter extends RecyclerView.Adapter<ProjectsRecViewAdapter.ViewHolder> {

    private ArrayList<Project> projects = new ArrayList<>();
    private Context mContext;

    public ProjectsRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_menu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(projects.get(position).getName());
        ProjectsTaskRecViewAdapter adapter = new ProjectsTaskRecViewAdapter();
        adapter.setTasks(projects.get(position).getTasks());

        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            recyclerView = itemView.findViewById(R.id.ProjectTaskRecView);
        }
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
        notifyDataSetChanged();
    }
}

package space.fedosenko.taskery;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.fedosenko.taskery.Model.Helping.Task;

public class TaskRecViewAdapter extends RecyclerView.Adapter<TaskRecViewAdapter.ViewHolder> {
    private static final String TAG = "TaskRecViewAdapter";

    private ArrayList<Task> tasks = new ArrayList<>();
    private Context mContext;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task,parent,false);
        return new ViewHolder(view);
    }

    public TaskRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtName.setText(tasks.get(position).getName());
        if (tasks.get(position).isDone()){
            holder.txtName.setPaintFlags(holder.txtName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.txtName.setPaintFlags(holder.txtName.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }


        holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "Looongpress", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tasks.get(position).changeState();
                notifyDataSetChanged();
                Toast.makeText(mContext, tasks.get(position).getName()+" is selected", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView txtName;
        private ImageView btDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            txtName = itemView.findViewById(R.id.tv_name);
            btDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}

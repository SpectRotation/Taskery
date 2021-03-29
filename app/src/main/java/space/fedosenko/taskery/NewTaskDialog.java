package space.fedosenko.taskery;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import space.fedosenko.taskery.Model.Helping.Task;
import space.fedosenko.taskery.Model.Storage;

import static space.fedosenko.taskery.MainActivity.TASK_KEY;

public class NewTaskDialog extends DialogFragment {

    public interface PassTaskInterface{
        void getPlan(Task task);
    }

    private PassTaskInterface passTaskInterface;
    private Button btnDismiss, btnAdd;
    private TextView tvAdvancedOptions;
    private EditText extTxtTaskName;
    private RelativeLayout optionsLayout;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_task_creation_new,null);
        initViews(view);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Add Task");

        Bundle bundle = getArguments();
        if (null!= bundle){
             final Task task = bundle.getParcelable(TASK_KEY   );
            if (null!=task){

                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO check the fields
                        try {
                            passTaskInterface = (PassTaskInterface) getActivity();
                            passTaskInterface.getPlan(new Task(extTxtTaskName.getText().toString(),"Fast Task"));
                            dismiss();
                        } catch (ClassCastException e){
                            e.printStackTrace();
                            dismiss();
                        }


                    }
                });
                tvAdvancedOptions.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (optionsLayout.getVisibility()==View.GONE){
                            optionsLayout.setVisibility(View.VISIBLE);
                            tvAdvancedOptions.setText("Hide advanced");
                        } else {
                            optionsLayout.setVisibility(View.GONE);
                            tvAdvancedOptions.setText("Advanced options");
                        }

                    }
                });

            }
        }

        return builder.create();
    }

    @SuppressLint("ResourceType")
    private void initViews(View view) {
        btnDismiss = view.findViewById(R.id.bt_dismiss);
        btnAdd = view.findViewById(R.id.bt_add);
        tvAdvancedOptions = view.findViewById(R.id.txt_advanced_options);
        optionsLayout = view.findViewById(R.id.advanced_options_layout);

        extTxtTaskName = view.findViewById(R.id.edtTxtTaskName);

    }
}

package com.example.projecttodolist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.VH> {
    public Context Adapter;


    List<UserModel> Adapter_list;

    public UserAdapter(Context adapter, List<UserModel> adapter_list) {
        Adapter = adapter;
        Adapter_list = adapter_list;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Adapter).inflate(R.layout.recycleview, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        UserModel userAdapter = Adapter_list.get(position);
        String date = userAdapter.getDate();
        String time = userAdapter.getTime();
        String data = userAdapter.getData();
        int periority = userAdapter.getPeriority();
        if (periority == 0) {
            holder.time.setTextColor(Adapter.getResources().getColor(R.color.colorPrimary));
        }
        if (periority == 1) {
            holder.time.setTextColor(Adapter.getResources().getColor(R.color.colorAccent));
        }
        if (periority == 2) {
            holder.time.setTextColor(Adapter.getResources().getColor(R.color.colorPrimaryDark));
        }
        holder.data.setText(data);
        holder.date.setText(date);
        holder.time.setText(time);
        holder.updateclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),taskdata.class);
                view.getContext().startActivity(intent);



            }
        });

    }
    public UserModel getTaskAt(int position){
        return Adapter_list.get(position);
    }
    @Override
    public int getItemCount() {
        return Adapter_list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView date, data, time;
        LinearLayout updateclick;

        public VH(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.task_date);
            data = itemView.findViewById(R.id.task_data);
            time = itemView.findViewById(R.id.task_time);
            updateclick=itemView.findViewById(R.id.updateclick);
        }
    }
}

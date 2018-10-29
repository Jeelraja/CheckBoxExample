package com.app.checkboxdemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.MyViewHolder> {

    AppCompatActivity context;
    public List<RvModel1> model1List;

    public RvAdapter2(AppCompatActivity appCompatActivity, List<RvModel1> model1List) {
        this.context = appCompatActivity;
        this.model1List = model1List;
    }


    @NonNull
    @Override
    public RvAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RvAdapter2.MyViewHolder holder, final int position) {
        final RvModel1 rvModel1 = model1List.get(position);
        holder.tvName.setText(rvModel1.getName());
       /* ((MyViewHolder) holder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* ((MyViewHolder) holder).checkBox.setChecked(
                        !((MyViewHolder) holder).checkBox.isChecked());*//*
                if (((MyViewHolder) holder).checkBox.isChecked()) {
                    onItemCheckListener.onItemCheck(rvModel1);
                } else {
                    onItemCheckListener.onItemUnCheck(rvModel1);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return model1List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public CheckBox checkBox;

        public MyViewHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.checkbox);
            tvName = view.findViewById(R.id.tvName);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            checkBox.setOnClickListener(onClickListener);
        }
    }
}

package com.app.checkboxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private List<RvModel1> model1List = new ArrayList<>();
    private RecyclerView rv;
    private RvAdapter2 mAdapter;
    RecyclerView.LayoutManager mLayoutManager1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        rv = findViewById(R.id.rv);
        Intent intent = getIntent();
        if (intent != null) {
            model1List = intent.getParcelableArrayListExtra("list");
            Toast.makeText(this, "" + model1List.size(), Toast.LENGTH_SHORT).show();
            mAdapter = new RvAdapter2(this, model1List);
            mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(mLayoutManager1);
            rv.setItemAnimator(new DefaultItemAnimator());
            rv.setAdapter(mAdapter);
        }
    }
}

package com.app.checkboxdemo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemCheckListener {

    private RecyclerView rv;
    private Button btnSelected;
    private RvAdapter1 mAdapter;
    private List<RvModel1> model1List = null;
    RecyclerView.LayoutManager mLayoutManager1;
    private List<RvModel1> currentSelectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        rv = findViewById(R.id.rv);
        btnSelected = findViewById(R.id.btnSelected);
        mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        model1List = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            RvModel1 rvModel1 = new RvModel1();
            rvModel1.setName("Demo" + i);
            model1List.add(i, rvModel1);
            mAdapter = new RvAdapter1(this, model1List, this);
            rv.setLayoutManager(mLayoutManager1);
            rv.setItemAnimator(new DefaultItemAnimator());
            rv.setAdapter(mAdapter);

        }


        btnSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) currentSelectedItems);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "" + currentSelectedItems.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemCheck(RvModel1 rvModel1) {
        currentSelectedItems.add(rvModel1);
    }

    @Override
    public void onItemUnCheck(RvModel1 rvModel1) {
        currentSelectedItems.remove(rvModel1);
    }
}

package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.memberareainovindo.adapter.ListOrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

        ArrayList<String> temp = new ArrayList<>();
        temp.add("1");
        temp.add("2");
        temp.add("3");
        temp.add("4");
        temp.add("5");

        recyclerView = findViewById(R.id.rvlistorder);
        recyclerView.setHasFixedSize(false);

        ListOrderAdapter adapter = new ListOrderAdapter(temp);
        recyclerView.setAdapter(adapter);
    }
}
package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.memberareainovindo.Adapter.RiwayatBillAdapter;

import java.util.ArrayList;

public class RiwayatBillActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_bill);

        ArrayList<String> temp = new ArrayList<>();
        temp.add("1");
        temp.add("2");
        temp.add("3");
        temp.add("4");
        temp.add("5");

        recyclerView = findViewById(R.id.rvlistRiwayat);
        recyclerView.setHasFixedSize(false);

        RiwayatBillAdapter adapter = new RiwayatBillAdapter(temp);
        recyclerView.setAdapter(adapter);
    }
}
package com.rujirakongsomran.bubblescrollbaronrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.trendyol.bubblescrollbarlib.BubbleScrollBar;
import com.trendyol.bubblescrollbarlib.BubbleTextProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> listData = new ArrayList<>();

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    BubbleScrollBar scrollBar;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        // View
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        initData();
        Collections.sort(listData);
        myAdapter = new MyAdapter(listData);
        recyclerView.setAdapter(myAdapter);
        //recyclerView.setAdapter(new MyAdapter(listData));
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

        scrollBar = (BubbleScrollBar) findViewById(R.id.bubbleScrollBar);
        scrollBar.attachToRecyclerView(recyclerView);
        scrollBar.setBubbleTextProvider(new BubbleTextProvider() {
            @Override
            public String provideBubbleText(int i) {
                return new StringBuilder(listData.get(i).substring(0, 1)).toString();
            }
        });
    }

    private void initData() {
        listData.add("Biwberry");
        listData.add("Benz");
        listData.add("Bankki");
        listData.add("Cake88");
        listData.add("Emmy");
        listData.add("Notto");
        listData.add("Nun");
        listData.add("Nutta");
        listData.add("Pat");
        listData.add("Tor");
        listData.add("You");
    }
}

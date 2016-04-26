package com.stone.verticalslide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.stone.verticalslide.fragment.ListFragment;
import com.stone.verticalslide.fragment.RecylerFristFragment;
import com.stone.verticalslide.fragment.RecylerSecondFragment;
import com.stone.verticalslide.fragment.ScrollFragment;
import com.stone.verticalslide.fragment.ViewpagerFragment;
import com.stone.verticalslide.fragment.WebFragment;

public class DragActitivy extends AppCompatActivity {


    private String frist;
    private String second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_actitivy);

        Intent intent = getIntent();
        frist = intent.getStringExtra("frist");
        second = intent.getStringExtra("second");

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (frist) {
            case "scrollView":
                ft.add(R.id.first, new ScrollFragment());
                break;
            case "recyclerView":
                ft.add(R.id.first, new RecylerFristFragment());
                break;
        }
        switch (second) {
            case "listView":
                ft.add(R.id.second, new ListFragment());
                break;
            case "webView":
                ft.add(R.id.second, new WebFragment());
                break;
            case "viewpager":
                ft.add(R.id.second, new ViewpagerFragment());
                break;
            case "recyclerView":
                ft.add(R.id.second, new RecylerSecondFragment());
                break;
        }
        ft.commit();
    }
}

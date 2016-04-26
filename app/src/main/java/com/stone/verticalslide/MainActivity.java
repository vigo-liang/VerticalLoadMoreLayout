package com.stone.verticalslide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView toViewpager = (CardView) findViewById(R.id.toViewpager);
        if (toViewpager != null) {
            toViewpager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DragActitivy.class);
                    intent.putExtra("frist", "scrollView");
                    intent.putExtra("second", "viewpager");
                    startActivity(intent);
                }
            });
        }

        CardView toWebView = (CardView) findViewById(R.id.toWebview);
        if (toWebView != null) {
            toWebView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DragActitivy.class);
                    intent.putExtra("frist", "scrollView");
                    intent.putExtra("second", "webView");
                    startActivity(intent);
                }
            });
        }

        CardView toRecylerView = (CardView) findViewById(R.id.toRecylerView);
        if (toRecylerView != null) {
            toRecylerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DragActitivy.class);
                    intent.putExtra("frist", "scrollView");
                    intent.putExtra("second", "recyclerView");
                    startActivity(intent);
                }
            });
        }
        CardView toListView = (CardView) findViewById(R.id.toListView);
        if (toListView != null) {
            toListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DragActitivy.class);
                    intent.putExtra("frist", "scrollView");
                    intent.putExtra("second", "listView");
                    startActivity(intent);
                }
            });
        }
        CardView recylerViewToRecylerView = (CardView) findViewById(R.id.recylerViewToRecylerView);
        if (recylerViewToRecylerView != null) {
            recylerViewToRecylerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DragActitivy.class);
                    intent.putExtra("frist", "recyclerView");
                    intent.putExtra("second", "recyclerView");
                    startActivity(intent);
                }
            });
        }


    }


}

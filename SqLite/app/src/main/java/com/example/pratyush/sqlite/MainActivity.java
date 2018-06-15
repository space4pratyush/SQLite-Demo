package com.example.pratyush.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add, delete, update, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        add=findViewById(R.id.btn_add);
        delete=findViewById(R.id.btn_delete);
        update=findViewById(R.id.btn_update);
        search=findViewById(R.id.btn_search);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_add=new Intent(MainActivity.this,Add.class);
                startActivity(intent_add);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Search.class);
                startActivity(intent);
            }
        });

    }
}

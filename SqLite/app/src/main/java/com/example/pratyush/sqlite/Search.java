package com.example.pratyush.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    EditText searchmobile;
    Button searchdata;
    TextView name, email;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchmobile=findViewById(R.id.et_searchmobile);
        searchdata=findViewById(R.id.btn_searchdata);
        name=findViewById(R.id.tv_namedata);
        email=findViewById(R.id.tv_emaildata);

        databaseHelper=new DatabaseHelper(this);


        searchdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor=databaseHelper.getData(searchmobile.getText().toString());

                name.setText(" ");
                email.setText(" ");

                while (cursor.moveToNext()){
                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }

            }
        });
    }
}

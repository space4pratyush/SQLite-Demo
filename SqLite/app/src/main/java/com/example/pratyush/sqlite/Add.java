package com.example.pratyush.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    EditText name, mobile, email;
    Button save;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseHelper=new DatabaseHelper(this);

        name=findViewById(R.id.et_name);
        mobile=findViewById(R.id.et_mobile);
        email=findViewById(R.id.et_email);
        save=findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result=databaseHelper.insertData(name.getText().toString(), mobile.getText().toString(), email.getText().toString());

                if (result){
                    Toast.makeText(Add.this,"Data inserted successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Add.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

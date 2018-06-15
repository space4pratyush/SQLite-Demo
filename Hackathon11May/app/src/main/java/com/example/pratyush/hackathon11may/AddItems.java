package com.example.pratyush.hackathon11may;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItems extends AppCompatActivity {
    EditText add_Item, add_Quantity;
    Button btn_Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        add_Item=findViewById(R.id.add_Item);
        add_Quantity=findViewById(R.id.add_Quantity);
        btn_Add=findViewById(R.id.btn_Add);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddItems.this,UpdateItem.class);
                startActivity(intent);
                add_Item.setText("");
                add_Quantity.setText("");
            }
        });
    }
}

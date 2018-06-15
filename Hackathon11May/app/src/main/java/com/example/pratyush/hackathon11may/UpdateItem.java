package com.example.pratyush.hackathon11may;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateItem extends AppCompatActivity {

    EditText update_Item, update_Quantity;
    Button btn_Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        update_Item=findViewById(R.id.update_Item);
        update_Quantity=findViewById(R.id.update_Quantity);
        btn_Update=findViewById(R.id.btn_Update);
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UpdateItem.this,AddItems.class);
                startActivity(intent);
                update_Item.setText("");
                update_Quantity.setText("");
            }
        });
    }
}

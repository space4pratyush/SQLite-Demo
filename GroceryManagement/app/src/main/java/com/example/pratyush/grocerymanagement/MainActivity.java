package com.example.pratyush.grocerymanagement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GroceryAdapter mAdapter;
    private SQLiteDatabase mDataBase;
    private EditText et_name;
    private TextView tv_Amount;
    private int amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GroceryDBHelper dbHelper=new GroceryDBHelper(this);
        mDataBase=dbHelper.getWritableDatabase();
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new GroceryAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);
        et_name=findViewById(R.id.et_name);
        tv_Amount=findViewById(R.id.tv_amount);
        Button btn_Increase=findViewById(R.id.btn_increment);
        Button btn_Decrease=findViewById(R.id.btn_decrement);
        Button btn_Add=findViewById(R.id.btn_add);

        btn_Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }

        });

        btn_Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }
    private void increase(){
        amount++;
        tv_Amount.setText(String.valueOf(amount));
    }
    private void decrease(){
        if(amount>0){
            amount--;
            tv_Amount.setText(String.valueOf(amount));
        }
    }
    private void add(){
        if (et_name.getText().toString().trim().length()==0|| amount==0){
            return;
        }
        String name=et_name.getText().toString();
        ContentValues cv=new ContentValues();
        cv.put(GroceryContract.GroceryEntry.COLUMN_NAME,name);
        cv.put(GroceryContract.GroceryEntry.COLUMN_AMOUNT,amount);
        mDataBase.insert(GroceryContract.GroceryEntry.TABLE_NAME,null,cv);
        mAdapter.swapCursor(getAllItems());
        et_name.getText().clear();
    }
    private Cursor getAllItems(){
        return mDataBase.query(
                GroceryContract.GroceryEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                GroceryContract.GroceryEntry.COLUMN_TIMESTAMP+ " DESC"

        );
    }
}

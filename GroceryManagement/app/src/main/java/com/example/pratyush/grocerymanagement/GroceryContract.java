package com.example.pratyush.grocerymanagement;

import android.provider.BaseColumns;

public class GroceryContract {

    //this construction is just for instanciating object
    private GroceryContract() {
    }

    public static final class GroceryEntry implements BaseColumns{
        public static final String TABLE_NAME="groceryList";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_AMOUNT="amount";
        public static final String COLUMN_TIMESTAMP="timestamp";
    }
}

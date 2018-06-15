package com.example.pratyush.grocerymanagement;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.pratyush.grocerymanagement.GroceryContract.*;

public class GroceryDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="grocerylist.db";
    public static final int DATABASE_VERSION=1;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * The database is not actually created or opened until one of
     * {@link #getWritableDatabase} or {@link #getReadableDatabase} is called.
     * <p>
     * <p>Accepts input param: a concrete instance of {@link DatabaseErrorHandler} to be
     * used to handle corruption when sqlite reports database corruption.</p>
     *  @param context      to use to open or create the database
     *
     */
    public GroceryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param mainActivity
     */
  //  public GroceryDBHelper(MainActivity mainActivity) {
   //     super(context, DATABASE_NAME, null, DATABASE_VERSION);
   // }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GROCERYLIST_TABLE="CREATE TABLE "+
                GroceryEntry.TABLE_NAME + "(" +
                GroceryEntry._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GroceryEntry.COLUMN_NAME+ " TEXT NOT NULL, " +
                GroceryEntry.COLUMN_AMOUNT+ " INTEGER NOT NULL, " +
                GroceryEntry.COLUMN_TIMESTAMP+ " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        db.execSQL(SQL_CREATE_GROCERYLIST_TABLE );
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GroceryEntry.TABLE_NAME);
        onCreate(db);

        }
}

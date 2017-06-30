package com.example.visualstudio.simpleactivity.LearnContentProvider;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Visual Studio on 6/29/2017.
 */

public class MySQLDatabaseForContentProvider extends SQLiteOpenHelper{
    private SQLiteDatabase db;
    private static final String DATABASE_NAME ="University";
    private static final String STUDENT_TABLE_NAME = "students";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_DB_STUDENT = "CREATE TABLE"
                                                + STUDENT_TABLE_NAME + "_id INTEGER PRIMARY KEY AUTOINCREMENT";
   /* public MySQLDatabaseForContentProvider(Context context){
        super(context,);

    }*/
    public MySQLDatabaseForContentProvider(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLDatabaseForContentProvider(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

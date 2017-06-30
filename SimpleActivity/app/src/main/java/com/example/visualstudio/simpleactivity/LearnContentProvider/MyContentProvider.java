package com.example.visualstudio.simpleactivity.LearnContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;

/**
 * Created by Visual Studio on 6/29/2017.
 */

public class MyContentProvider extends ContentProvider {
    private static final String PROVIDER_NAME = "com.example.visualstudio.simpleactivity.ContentProvider";
    private static final String URI = "content://"+PROVIDER_NAME+"/students"; // Chỗ này chưa hiểu
    private static Uri CONTENT_URI = Uri.parse(URI);

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";

    private static HashMap<String,String> STUDENT_PROJECTION_MAP;
    private static final int STUDENT = 1;
    private static final int STUDENT_ID = 2;

    private static UriMatcher urMatcher;
    static {
        urMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        urMatcher.addURI(PROVIDER_NAME,"student",STUDENT);
        urMatcher.addURI(PROVIDER_NAME,"student/#",STUDENT_ID); //Chỗ dấu # là sao
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}

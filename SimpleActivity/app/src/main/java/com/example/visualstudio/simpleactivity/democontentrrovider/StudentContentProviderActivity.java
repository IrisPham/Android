package com.example.visualstudio.simpleactivity.democontentrrovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.visualstudio.simpleactivity.R;

public class StudentContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_content_provider);
    }

    public void onClickAddStudent(View view) {
        // Thêm một record sinh viên mới
        ContentValues values = new ContentValues();

        values.put(StudentContentProvider.NAME,
                ((EditText)findViewById(R.id.activity_student_content_provider_edt_namStudent)).getText().toString());

        values.put(StudentContentProvider.ADDRESS,
                ((EditText)findViewById(R.id.activity_student_content_provider_edt_addressStudent)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentContentProvider.CONTENT_URI, values);
        Toast.makeText(this, "Đã thêm thành công!", Toast.LENGTH_SHORT).show();

        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickReturnListStudents(View view) {
       // Đọc các records sinh viên
        String URL = "content://com.example.visualstudio.simpleactivity.LearnContentProvider/students";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");
        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentContentProvider.ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentContentProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentContentProvider.ADDRESS)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }

    public void onClickDeleteListStudents(View view) {
        //while compiling: DELETE FROM students WHERE students=students
        getContentResolver().delete(StudentContentProvider.CONTENT_URI,null , null);
        Toast.makeText(this, "Đã xóa thành công dữ liệu", Toast.LENGTH_SHORT).show();
    }
}

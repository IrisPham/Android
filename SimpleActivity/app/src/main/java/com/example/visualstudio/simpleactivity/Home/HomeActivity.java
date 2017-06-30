package com.example.visualstudio.simpleactivity.Home;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.visualstudio.simpleactivity.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity{
    private GridView gv_ChooserCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gv_ChooserCourse = findViewById(R.id.activity_home_gv_chooserItem);

        Course course = new Course(R.drawable.ic_airplay_black_24dp,"Layout");
        Course course2 = new Course(R.drawable.ic_accessibility_black_24dp,"Activity");
        Course course3 = new Course(R.drawable.ic_content_paste_black_24dp,"Content Provider");
        Course course4 = new Course(R.drawable.ic_local_laundry_service_black_24dp,"Service");
        Course course5 = new Course(R.drawable.ic_network_cell_black_24dp,"Broadcast");

        ArrayList<Course> courseArrayList = new ArrayList<>();
            courseArrayList.add(course);
            courseArrayList.add(course2);
            courseArrayList.add(course3);
            courseArrayList.add(course4);
            courseArrayList.add(course5);
        ArrayAdapter<Course> arrayAdapter = new ArrayAdapter<Course>(this,android.R.layout.simple_list_item_1,courseArrayList);
        gv_ChooserCourse.setAdapter(arrayAdapter);

        gv_ChooserCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = gv_ChooserCourse.getItemAtPosition(i);
                Course course = (Course) o;
                Toast.makeText(HomeActivity.this, "Selected :" + " " + course.getNameCourse(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

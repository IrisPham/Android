package com.example.visualstudio.simpleactivity.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visualstudio.simpleactivity.R;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 6/30/2017.
 */

public class CourseAdapter extends BaseAdapter {
    private ArrayList<Course> courseArrayList;
    private LayoutInflater layoutInflater;
    private Context context;

    public CourseAdapter (Context context,ArrayList<Course> courseArrayList){
        this.context = context;
        this.courseArrayList = courseArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return courseArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CourseViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.activity_home_gv_item_course,null);
            holder = new CourseViewHolder();
            holder.setIamgeViewCouse((ImageView) view.findViewById(R.id.activity_home_gv_item_course_imv_course));
            holder.setNameCouse((TextView) view.findViewById(R.id.activity_home_gv_item_course_tv_nameCourse));
        }
        Course course = this.courseArrayList.get(i);
        CourseViewHolder.nameCouse.setText(course.getNameCourse());
        CourseViewHolder.iamgeViewCouse.setImageResource(course.getImageCourse());
        return view;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}

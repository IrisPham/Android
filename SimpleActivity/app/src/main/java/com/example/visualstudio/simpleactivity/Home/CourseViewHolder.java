package com.example.visualstudio.simpleactivity.Home;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Visual Studio on 6/30/2017.
 */

public class CourseViewHolder {
    static TextView nameCouse;
    static ImageView iamgeViewCouse;

    public CourseViewHolder(){

    }

    public CourseViewHolder(TextView nameCouse, ImageView iamgeViewCouse) {
        this.nameCouse = nameCouse;
        this.iamgeViewCouse = iamgeViewCouse;
    }

    public TextView getNameCouse() {
        return nameCouse;
    }

    public void setNameCouse(TextView nameCouse) {
        this.nameCouse = nameCouse;
    }

    public ImageView getIamgeViewCouse() {
        return iamgeViewCouse;
    }

    public void setIamgeViewCouse(ImageView iamgeViewCouse) {
        this.iamgeViewCouse = iamgeViewCouse;
    }
}

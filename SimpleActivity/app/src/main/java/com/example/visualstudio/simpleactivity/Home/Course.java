package com.example.visualstudio.simpleactivity.Home;

/**
 * Created by Visual Studio on 6/30/2017.
 */

public class Course {
    private Integer imageCourse;
    private String nameCourse;

    public Course(Integer imageCourse, String nameCourse) {
        this.imageCourse = imageCourse;
        this.nameCourse = nameCourse;
    }

    public Integer getImageCourse() {
        return imageCourse;
    }

    public void setImageCourse(Integer imageCourse) {
        this.imageCourse = imageCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }
}

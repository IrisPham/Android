package com.example.visualstudio.canthouniversity.modules.rateMark.models;

import android.widget.TextView;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class ChildMark {
    private String contentMark;
    private String maxMark;
    private int diemKhoaDanhGia;
    private int studentMark;
    private int consultantMark;
    private int finalMark;


    public ChildMark(String contentMark, String maxMark, int diemKhoaDanhGia, int studentMark
            , int consultantMark, int finalMark) {
        this.contentMark = contentMark;
        this.maxMark = maxMark;
        this.diemKhoaDanhGia = diemKhoaDanhGia;
        this.studentMark = studentMark;
        this.consultantMark = consultantMark;
        this.finalMark = finalMark;
    }

    public String getContentMark() {
        return contentMark;
    }


    public String getMaxMark() {
        return maxMark;
    }

    public int getDiemKhoaDanhGia() {
        return diemKhoaDanhGia;
    }


    public int getStudentMark() {
        return studentMark;
    }


    public int getFinalMark() {
        return finalMark;
    }

    public int getConsultantMark() {
        return consultantMark;
    }
}

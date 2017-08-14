package com.example.visualstudio.canthouniversity.modules.rateMark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.visualstudio.canthouniversity.R;
import com.gc.materialdesign.views.ButtonRectangle;

public class rateMarkMainActivity extends AppCompatActivity {
    private ButtonRectangle btnSearch;
    private Spinner listYear,listSemester;
    private ButtonRectangle btnRateMark01, btnRateMark02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_mark_main);
        init();
        setItemSpinnerListYear();
        setItemSpinnerListSemester();
    }
    private void init(){
        btnSearch = (ButtonRectangle) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnSearch();
            }
        });
        listYear = (Spinner) findViewById(R.id.spinner_list_year);
        listSemester = (Spinner) findViewById(R.id.spinner_list_semester);
        btnRateMark01 = (ButtonRectangle) findViewById(R.id.btnViewRateMark01);
        btnRateMark01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnRateMark01();
            }
        });
        btnRateMark02 = (ButtonRectangle) findViewById(R.id.btnViewRateMark02);
        btnRateMark02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnRateMark02();
            }
        });
    }

    private void setItemSpinnerListYear(){
        String arr[] = {"2017-2018"
                ,"2016-2017"
                ,"2015-2016"
                ,"2014-2015"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listYear.setAdapter(adapter);
    }
    private void setItemSpinnerListSemester(){
        String arr[] = {"1"
                ,"2"
                ,"hè"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listSemester.setAdapter(adapter);
    }

    private void onClickBtnSearch(){

       // progress.dismiss();
        //startActivity(new Intent(rateMarkMainActivity.this, TabMarkActivity.class));
    }
    private void onClickBtnRateMark01(){
        //ProgressDialog progress=ProgressDialog.show(rateMarkMainActivity.this,"","Đang tải dữ liệu....!");
        startActivity(new Intent(rateMarkMainActivity.this, TabMarkActivity.class));
    }
    private void onClickBtnRateMark02(){
        startActivity(new Intent(rateMarkMainActivity.this, TabMarkActivity.class));
    }
}

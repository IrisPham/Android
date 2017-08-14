package com.example.visualstudio.canthouniversity.modules.rateMark.viewholder;

import android.support.annotation.IntegerRes;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.rateMark.data.dataMark1;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class ChildMarkViewHolder extends ChildViewHolder {
    private TextView tvTitleMark;
    private TextView tvMaxMark;
    private EditText edtDiemKhoaDanhGia;
    private EditText edtStudentMark;
    private EditText edtConsultantMark;
    private EditText edtFinalMark;
    private View view;

    public ChildMarkViewHolder(View itemView) {
        super(itemView);
        tvTitleMark = itemView.findViewById(R.id.texview_contentMarktest);
        tvMaxMark = itemView.findViewById(R.id.texview_MaxMark);
        edtDiemKhoaDanhGia =  itemView.findViewById(R.id.edt_DiemKhoaDanhGia);
        edtStudentMark = itemView.findViewById(R.id.edt_StudentMark);
        this.view = itemView;
        /*edtStudentMark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() == 2){
                    dataMark1.setDiem(Integer.parseInt(String.valueOf(edtStudentMark.getText())));
                }
            }
        });*/
        edtConsultantMark = itemView.findViewById(R.id.edt_consultantMark);
        edtFinalMark = itemView.findViewById(R.id.edt_FinalMark);
    }

    public TextView getTvTitleMark() {
        return tvTitleMark;
    }

    public TextView getTvMaxMark() {
        return tvMaxMark;
    }


    public EditText getEdtDiemKhoaDanhGia() {
        return edtDiemKhoaDanhGia;
    }


    public EditText getEdtStudentMark() {
        return edtStudentMark;
    }


    public EditText getEdtConsultantMark() {
        return edtConsultantMark;
    }


    public EditText getEdtFinalMark() {
        return edtFinalMark;
    }


}

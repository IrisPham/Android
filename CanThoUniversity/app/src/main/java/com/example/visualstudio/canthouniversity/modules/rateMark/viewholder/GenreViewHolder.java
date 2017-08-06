package com.example.visualstudio.canthouniversity.modules.rateMark.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class GenreViewHolder extends GroupViewHolder {
    private TextView textViewMarkLevel2;

    public GenreViewHolder(View itemView) {
        super(itemView);
        textViewMarkLevel2 = (TextView) itemView.findViewById(R.id.texview_IndexLevel2);
    }
    public void setTextViewMarkLevel1(String data){
        textViewMarkLevel2.setText(data);
    }
}

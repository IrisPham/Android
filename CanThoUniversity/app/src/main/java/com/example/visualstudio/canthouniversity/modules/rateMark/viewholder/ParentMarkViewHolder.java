package com.example.visualstudio.canthouniversity.modules.rateMark.viewholder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visualstudio.canthouniversity.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class ParentMarkViewHolder extends GroupViewHolder {
    private TextView textViewMarkLevel2;
    private ImageView imageViewExpandMore;
    private View view;
    public ParentMarkViewHolder(View itemView) {
        super(itemView);
        textViewMarkLevel2 = itemView.findViewById(R.id.texview_IndexLevel2);
        imageViewExpandMore = itemView.findViewById(R.id.imageView_expand_more);
        this.view = itemView;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    public void setTextViewMarkLevel1(String data) {
        textViewMarkLevel2.setText(data);
    }

    @Override
    public void expand() {
        //animateExpand();1
        imageViewExpandMore.setImageResource(R.drawable.ic_expand_less_black_24dp);

    }

    @Override
    public void collapse() {
        //animateCollapse();
        imageViewExpandMore.setImageResource(R.drawable.ic_expand_more_black_24dp);
    }

}

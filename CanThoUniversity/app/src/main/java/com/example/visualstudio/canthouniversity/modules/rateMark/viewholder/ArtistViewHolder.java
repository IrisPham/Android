package com.example.visualstudio.canthouniversity.modules.rateMark.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class ArtistViewHolder extends ChildViewHolder {
    private TextView MarkLevel2Title;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        MarkLevel2Title = (TextView) itemView.findViewById(R.id.texview_IndexLevel1);
    }
    public void setMarkLevel2Title(String title){
        MarkLevel2Title.setText(title);
    }
}

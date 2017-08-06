package com.example.visualstudio.canthouniversity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;

/**
 * Created by Visual Studio on 7/14/2017.
 */

public class ItemHome extends BaseAdapter {
    private Context mContext;
    private String[] girdViewString;
    private int[] gridViewImage;

    public ItemHome(Context mContext, String[] girdViewString, int[] gridViewImage) {
        this.mContext = mContext;
        this.girdViewString = girdViewString;
        this.gridViewImage = gridViewImage;
    }

    @Override
    public int getCount() {
        return girdViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view  == null){
            gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.item_home,null);
            TextView tv_nameItem = gridView.findViewById(R.id.textview_nameItem);
            ImageView imageView = gridView.findViewById(R.id.image_logo);
            tv_nameItem.setText(girdViewString[i]);
            imageView.setImageResource(gridViewImage[i]);
        }else{
            gridView = (View) view;
        }
        return gridView;
    }
}

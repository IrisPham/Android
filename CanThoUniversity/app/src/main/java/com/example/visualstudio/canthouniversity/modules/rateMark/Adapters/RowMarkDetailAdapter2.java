package com.example.visualstudio.canthouniversity.modules.rateMark.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.Genre;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class RowMarkDetailAdapter2 extends RecyclerView.Adapter<RowMarkDetailAdapter2.MarkViewHolder2> {
    ArrayList<Genre> listGenre;
    Context context;

    public RowMarkDetailAdapter2(ArrayList<Genre> listGenre, Context context) {
        this.listGenre = listGenre;
        this.context = context;
    }

    public class MarkViewHolder2 extends RecyclerView.ViewHolder{
        TextView textViewMarkLevel2;
        public MarkViewHolder2(View itemView) {
            super(itemView);
            textViewMarkLevel2 = itemView.findViewById(R.id.texview_IndexLevel2);
        }
    }
    @Override
    public RowMarkDetailAdapter2.MarkViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.list_item_genre,parent,false);
        return new MarkViewHolder2(itemview);
    }

    @Override
    public void onBindViewHolder(RowMarkDetailAdapter2.MarkViewHolder2 holder, int position) {
        //holder.textViewMarkLevel2.setText(listGenre.get(position).);
    }

    @Override
    public int getItemCount() {
        return listGenre.size();
    }
}

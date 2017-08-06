package com.example.visualstudio.canthouniversity.modules.rateMark.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.Artist;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class RowMarkDetailAdapter extends RecyclerView.Adapter<RowMarkDetailAdapter.MarkViewHolder> {
    ArrayList<Artist> listArtist;
    Context context;

    public RowMarkDetailAdapter(ArrayList<Artist> listArtist, Context context) {
        this.listArtist = listArtist;
        this.context = context;
    }

    public class MarkViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewIndexMarkLevel1;

        public MarkViewHolder(View itemView) {
            super(itemView);
            textViewIndexMarkLevel1 = itemView.findViewById(R.id.texview_IndexLevel1);
        }
    }

    @Override
    public MarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.items_row__mark__detail,parent,false);
        return new MarkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MarkViewHolder holder, int position) {
        holder.textViewIndexMarkLevel1.setText(listArtist.get(position).getIndex1());
    }

    @Override
    public int getItemCount() {
        return listArtist.size();
    }

}

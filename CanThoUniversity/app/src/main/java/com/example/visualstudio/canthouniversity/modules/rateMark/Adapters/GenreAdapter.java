package com.example.visualstudio.canthouniversity.modules.rateMark.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.Artist;
import com.example.visualstudio.canthouniversity.modules.rateMark.viewholder.GenreViewHolder;
import com.example.visualstudio.canthouniversity.modules.rateMark.viewholder.ArtistViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Visual Studio on 8/1/2017.
 */

public class GenreAdapter extends ExpandableRecyclerViewAdapter<GenreViewHolder,ArtistViewHolder> {

    public GenreAdapter(List<? extends ExpandableGroup> groups ){
        super(groups);
    }

    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_genre,parent,false);

        return new GenreViewHolder(view);
    }

    @Override
    public ArtistViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_row__mark__detail,parent,false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ArtistViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Artist artist = (Artist) group.getItems().get(childIndex);
        holder.setMarkLevel2Title(artist.getIndex1());
    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setTextViewMarkLevel1(group.getTitle());
    }
}

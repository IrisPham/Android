package com.example.visualstudio.canthouniversity.modules.rateMark.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.ChildMark;
import com.example.visualstudio.canthouniversity.modules.rateMark.viewholder.ParentMarkViewHolder;
import com.example.visualstudio.canthouniversity.modules.rateMark.viewholder.ChildMarkViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Visual Studio on 8/1/2017.
 */

public class ParentAdapter extends ExpandableRecyclerViewAdapter<ParentMarkViewHolder,ChildMarkViewHolder> {
    private Context mContext;
    public ParentAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentMarkViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_row_mark_parent,parent,false);
        return new ParentMarkViewHolder(view);
    }

    @Override
    public ChildMarkViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_row__mark__detail,parent,false);
        mContext = parent.getContext();
        return new ChildMarkViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildMarkViewHolder holder, int flatPosition, final ExpandableGroup group, final int childIndex) {
        ArrayList<? extends ExpandableGroup> listGrop = new ArrayList<>();
        listGrop = (ArrayList<? extends ExpandableGroup>) group.getItems();
        Toast.makeText(mContext, ""+listGrop.size(), Toast.LENGTH_SHORT).show();
        Toast.makeText(mContext, ""+group.getTitle(), Toast.LENGTH_SHORT).show();
        Toast.makeText(mContext, ""+group.getItems().size(), Toast.LENGTH_SHORT).show();
        ChildMark ctMarkLv2 = (ChildMark) group.getItems().get(childIndex);
        holder.getTvTitleMark().setText(ctMarkLv2.getContentMark());
        final TextView tv = holder.getTvTitleMark();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(mContext, ""+((ChildMark) group.getItems().get(childIndex)).getContentMark(), Toast.LENGTH_SHORT).show();

            }
        });
        holder.getTvMaxMark().setText(ctMarkLv2.getMaxMark());
        holder.getEdtDiemKhoaDanhGia().setText(String.valueOf(ctMarkLv2.getDiemKhoaDanhGia()), TextView.BufferType.EDITABLE);
        holder.getEdtStudentMark().setText(String.valueOf(ctMarkLv2.getStudentMark()), TextView.BufferType.EDITABLE);
        holder.getEdtConsultantMark().setText(String.valueOf(ctMarkLv2.getConsultantMark()), TextView.BufferType.EDITABLE);
        holder.getEdtFinalMark().setText(String.valueOf(ctMarkLv2.getFinalMark()), TextView.BufferType.EDITABLE);
    }

    @Override
    public void onBindGroupViewHolder(ParentMarkViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setTextViewMarkLevel1(group.getTitle());
    }
}

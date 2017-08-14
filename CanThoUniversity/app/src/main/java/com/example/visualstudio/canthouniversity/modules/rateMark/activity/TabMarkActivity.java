package com.example.visualstudio.canthouniversity.modules.rateMark.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.main.fragments.FinalMarkFragment;
import com.example.visualstudio.canthouniversity.modules.rateMark.Adapters.ParentAdapter;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.ChildMark;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.ParentMark;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.StructureMark;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TabMarkActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public ArrayList<StructureMark> structureMarkList = new ArrayList<>();
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = "https://rotatory-religions.000webhostapp.com/getJSONEC.php";
        final RequestQueue requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int  i = 0; i < response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        structureMarkList.add(new StructureMark(jsonObject.getString("idItem")
                                ,jsonObject.getString("itemName")
                                ,jsonObject.getInt("scores")
                                ,jsonObject.getString("describe")
                                ,jsonObject.getString("IDParent")));

                        if(jsonObject.getString("IDParent").equals("")){
                            indexTitle.add(jsonObject.getString("idItem"));
                        }
                    } catch (JSONException e) {
                        Toast.makeText(TabMarkActivity.this, "Không có kết nối mạng! vui lòng thử lại!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
              init();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TabMarkActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.





    }
    public void init(){
        setContentView(R.layout.activity_tab_mark);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * Đây là một Fragment của e khi trả về
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        ArrayList<ParentMark> parentMarksList;
        ArrayList<ChildMark> childMarksList;
        private TextView tvTitle;

        public PlaceholderFragment() {

        }
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber,String itemName,List parentMarksList) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString("itemName",itemName);
            args.putSerializable("parent", (Serializable) parentMarksList);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_mark, container, false);
            tvTitle = (TextView) rootView.findViewById(R.id.section_label);
            //getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER));
            tvTitle.setText(getArguments().getString("itemName"));
            parentMarksList = (ArrayList<ParentMark>) getArguments().getSerializable("parent");

            RecyclerView recyclerView = rootView.findViewById(R.id.RecyclerView);
            //getItem();
            ParentAdapter mAdapter = new ParentAdapter(parentMarksList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            recyclerView.setAdapter(mAdapter);
            Toast.makeText(rootView.getContext(), ""+recyclerView.getChildCount(), Toast.LENGTH_SHORT).show();
            return rootView;
        }
        
    }

    private ArrayList<String> indexTitle = new ArrayList<>();

    /*
    * FragmentPagerAdapter
    * */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //E có sử dụng chỗ này để trả về một Fragment bằng phương thức tĩnh newIntance(....)
        @Override
        public Fragment getItem(int position) {
            List<ParentMark> parentMarksList = new ArrayList<>();
            List<ChildMark> childMarksList = null;
            ArrayList<String> childMarkListTamp = new ArrayList<>();
            String indexParent;
            String itemName = null;
            if(position == indexTitle.size() - 1){
                return FinalMarkFragment.newIntance("Tổng điểm các điều");
            }else{
                indexParent = indexTitle.get(position);
                Log.e("TAG",indexParent);
                Log.e("TAG",String.valueOf(position));
                for(int i = 0; i < structureMarkList.size(); i++) {
                    /*Dòng if này lấy ra các Điều 4 , 5 , 6,...*/
                    if (structureMarkList.get(i).getIdItem().equals(indexParent)) {
                        itemName = structureMarkList.get(i).getItemName();
                        Log.e("TAG", itemName);
                        break;
                    }
                }
                for(int i = 0; i < structureMarkList.size(); i++) {
                    /*Dòng if này lấy ra các điều con của Điều 4,5 => I.a, I.b...*/
                    if (structureMarkList.get(i).getIDParent().equals(indexParent)) {
                        childMarkListTamp.add(structureMarkList.get(i).getIdItem());
                    }
                }

                for(int i = 0; i < childMarkListTamp.size(); i++) {
                    String idItemTamp = childMarkListTamp.get(i);
                    //I.a
                    childMarksList = new ArrayList<>();
                    for(int j = 0; j < structureMarkList.size(); j++){
                        /*Dòng if này lấy ra các điều con của I.a, I.b */
                        if (structureMarkList.get(j).getIDParent().equals(idItemTamp)) {
                            childMarksList.add(new ChildMark(structureMarkList.get(j).getItemName()
                                    ,String.valueOf(structureMarkList.get(j).getScores()),0,0,0,0));
//                            for(int y = 0; y < structureMarkList.size(); y++){
//                                if(structureMarkList.get(y).getIDParent().equals()){
//
//                                }
//                            }
                        }
                    }
                    /*Dòng if này lấy ra các điều con của Điều 4,5 => I.a, I.b...*/
                    for(int x = 0; x < structureMarkList.size(); x++){
                        if (structureMarkList.get(x).getIdItem().equals(idItemTamp)) {
                            parentMarksList.add(new ParentMark(structureMarkList.get(x).getItemName(),childMarksList));
                        }
                    }

                }
            }
            return PlaceholderFragment.newInstance(position + 1,itemName,parentMarksList);

        }

        @Override
        public int getCount() {
            return indexTitle.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == indexTitle.size() - 1){
                return "Tổng điểm các điều";
            }
             return "Mục :"+ indexTitle.get(position);
        }
    }
}

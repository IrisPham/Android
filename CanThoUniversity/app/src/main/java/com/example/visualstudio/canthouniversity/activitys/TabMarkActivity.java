package com.example.visualstudio.canthouniversity.activitys;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.rateMark.Adapters.GenreAdapter;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.Artist;
import com.example.visualstudio.canthouniversity.modules.rateMark.models.Genre;

import java.util.ArrayList;
import java.util.List;

public class TabMarkActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_mark);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        List<Genre> genres;
        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String sectionIndexMark) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_NUMBER, sectionIndexMark);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_mark, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER))
            textView.setText(getArguments().getString(ARG_SECTION_NUMBER));

            RecyclerView recyclerView = rootView.findViewById(R.id.RecyclerView);
            getItem();
            GenreAdapter mAdapter = new GenreAdapter(genres);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            recyclerView.setAdapter(mAdapter);

            return rootView;
        }
        public void getItem(){
            genres = new ArrayList<>();
            List<Artist> markLevel2ss = new ArrayList<>();
            markLevel2ss.add(new Artist("- Đi học đầy đủ" +
                        ", đúng giờ, nghiêm túc trong giờ học (Mỗi môn bị cấm thi trừ 03 điểm)"));
            List<Artist> markLevel2sss = new ArrayList<>();
            markLevel2sss.add(new Artist("- Có tham gia đề tài NCKH của sinh viên hoặc của Khoa và cấp tương đương" +
                    ", có xác nhận của Chủ nhiệm đề tài (Không tính bài tập, tiểu luận, đồ án môn học, luận văn...)"));
            markLevel2sss.add(new Artist("- Có giấy khen về NCKH"));
            markLevel2sss.add(new Artist("- Có tham gia đề tài NCKH của sinh viên hoặc của Khoa và cấp tương đương" +
                    ", có xác nhận của Chủ nhiệm đề tài (Không tính bài tập, tiểu luận, đồ án môn học, luận văn...)"));
            genres.add(new Genre("Ý thức và thái độ trong học tập.", markLevel2ss));

            genres.add(new Genre("Ý thức và thái độ tham gia các câu lạc bộ học thuật" +
                    ", các hoạt động học thuật" +
                    ", hoạt động ngoại khóa" +
                    ", hoạt động nghiên cứu khoa học.", markLevel2sss));
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        ArrayList<String> dataIndexMark = new ArrayList<>();
        ArrayList<String> dataIndexMarkDetail = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            //set data IndexMark
            dataIndexMark.add("Mục I: Điều 4");
            dataIndexMark.add("Mục II: Điều 5");
            dataIndexMark.add("Mục II: Điều 6");
            dataIndexMark.add("Mục IV: Đièu 7");
            dataIndexMark.add("Mục V: Điều 8");
            dataIndexMark.add("Tổng điểm của các điều");

            //set data IndexMarkDetail
            dataIndexMarkDetail.add("Đánh giá về ý thức tham gia học tập (Điểm tối đa mục này là 20)");
            dataIndexMarkDetail.add("Đánh giá về ý thức và kết quả chấp hành nội quy" +
                    ", quy chế, quy định trong nhà trường");
            dataIndexMarkDetail.add("Đánh giá về ý thức tham gia các hoạt động chính trị" +
                    ", xã hội" +
                    ", văn hóa" +
                    ", văn nghệ" +
                    ", thể thao" +
                    ", phòng chống tội phạm và các tệ nạn xã hộip");
            dataIndexMarkDetail.add("Đánh giá về ý thức công dân trong quan hệ cộng đồng");
            dataIndexMarkDetail.add("Đánh giá về ý thức và kết quả khi tham gia công tác cán bộ lớp" +
                    ", các đoàn thể" +
                    ", tổ chức trong nhà trường hoặc người học đạt được thành tích đặc biệt trong học tập" +
                    ", rèn luyện.");

        }

        @Override
        public Fragment getItem(int position) {
            //Gọi clas Fragment
            return PlaceholderFragment.newInstance(dataIndexMarkDetail.get(position));
        }


        @Override
        public int getCount() {
            return dataIndexMark.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return dataIndexMark.get(position);
        }
    }
}

package com.example.visualstudio.canthouniversity.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.adapters.ContentMarkAdapter;
import com.example.visualstudio.canthouniversity.model.contentMarkModel;

import java.util.ArrayList;

public class contentMark extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mark);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<contentMarkModel> contentMarksList = new ArrayList<>();

        contentMarksList.add(new contentMarkModel("Mục I: Điều 4. Đánh giá về ý thức tham gia học tập"));
        contentMarksList.add(new contentMarkModel("Mục II: Điều 5. Đánh giá về ý thức và kết quả chấp hành nội quy, quy chế, quy định trong nhà trường"));
        contentMarksList.add(new contentMarkModel("Mục III: Điều 6. Đánh giá về ý thức tham gia các hoạt động chính trị, xã hội, văn hóa, văn nghệ, thể thao, phòng chống tội phạm và các tệ nạn xã hội"));
        contentMarksList.add(new contentMarkModel("Mục IV: Điều 7. Đánh giá về ý thức công dân trong quan hệ cộng đồng"));
        contentMarksList.add(new contentMarkModel("Mục V: Điều 8. Đánh giá về ý thức và kết quả khi tham gia công tác cán bộ lớp, các đoàn thể, tổ chức trong nhà trường hoặc người học đạt được thành tích đặc biệt trong học tập, rèn luyện."));

        ContentMarkAdapter  contentMarkAdapter = new ContentMarkAdapter(contentMarksList,getApplicationContext());

        recyclerView.setAdapter(contentMarkAdapter);

    }

}

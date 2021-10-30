package com.example.newsfargmenttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.newsfargmenttest.fragment.NewsContentFragment;

public class NewsContentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String title=this.getIntent().getStringExtra("news_title");
        String content=this.getIntent().getStringExtra("news_content");
        if (title!=null && content!=null){
            FragmentManager fragmentManager=this.getSupportFragmentManager();
            NewsContentFragment fragment= (NewsContentFragment) fragmentManager.findFragmentById(R.id.newsContentFrag);
            fragment.refresh(title,content);
        }
    }

    public static void actionStart(Context context, String title,String content){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);
    }
}

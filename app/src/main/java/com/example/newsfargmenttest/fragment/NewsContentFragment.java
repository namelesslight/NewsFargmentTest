package com.example.newsfargmenttest.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newsfargmenttest.R;

public class NewsContentFragment extends Fragment {
    LinearLayout contentLayout=null;
    TextView newTitle=null;
    TextView newContent=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_content_frag,container,false);
    }



    @SuppressLint("ResourceAsColor")
    public void refresh(String title, String content){
        contentLayout=this.getActivity().findViewById(R.id.contentLayout);
        newTitle=this.getActivity().findViewById(R.id.newTitle);
        newContent=this.getActivity().findViewById(R.id.newContent);
        contentLayout.setVisibility(View.VISIBLE);
        newTitle.setText(title);
        newContent.setText(content);
    }
}

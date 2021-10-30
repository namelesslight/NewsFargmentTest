package com.example.newsfargmenttest.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsfargmenttest.NewsContentActivity;
import com.example.newsfargmenttest.R;
import com.example.newsfargmenttest.pojo.New;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {
    private  boolean isTwoPane=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_title_frag,container,false);
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        List<New> newsList;

        public NewsAdapter(List list){
            this.newsList=list;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            TextView newsTitle;
            public ViewHolder(View view){
                super(view);
                this.view=view;
                newsTitle=view.findViewById(R.id.newsTitle);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.news_item,parent,false);
            System.out.println(view);
            ViewHolder holder=new ViewHolder(view);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    New news=newsList.get(holder.getAdapterPosition());
                    if (isTwoPane){
                        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                        NewsContentFragment fragment= (NewsContentFragment) fragmentManager.findFragmentById(R.id.newsContentFrag);
                        fragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        NewsContentActivity.actionStart(parent.getContext()
                                ,news.getTitle()
                                ,news.getContent());
                    }
                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            New news=newsList.get(position);
            holder.newsTitle.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity=this.getActivity();
        isTwoPane=(activity.findViewById(R.id.contentLayout)!=null);
        RecyclerView recyclerView=activity.findViewById(R.id.newsTitleRecyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter=new NewsAdapter(getNews());
        recyclerView.setAdapter(adapter);
    }

    public List<New> getNews(){
        ArrayList<New> newsList=new ArrayList<>();
        for(int i=0;i<50;i++){
            New news=new New("This is news title"+i,getRandomLengthString("This is news title"+i));
            newsList.add(news);
        }
        return newsList;

    }

    public String getRandomLengthString(String str){
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<10;i++){
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}

package com.example.newsfargmenttest.pojo;


public class New {
    private String title;
    private String content;

    public New(String title,String content){
        this.title=title;
        this.content=content;
    }

    public New() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.example.plantsearching.Model;

import java.io.Serializable;

public class Article implements Serializable {
    private String banner;
    private String title;
    private  String tag;
    private String content;
    private String date_post;
    private  String userAvatar;
    private  String userName;

    public Article(String banner, String title, String tag, String content, String date_post, String userAvatar, String userName) {
        this.tag = tag;
        this.banner = banner;
        this.title = title;
        this.content = content;
        this.date_post = date_post;
        this.userAvatar = userAvatar;
        this.userName = userName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate_post() {
        return date_post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Article(){

    }
}

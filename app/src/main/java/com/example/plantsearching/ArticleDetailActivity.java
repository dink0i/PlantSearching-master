package com.example.plantsearching;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.plantsearching.Model.Article;

public class ArticleDetailActivity extends AppCompatActivity {

    ImageView back;
    ConstraintLayout article_banner;
    ImageView article_avatar;
    TextView article_title;
    TextView article_username;
    TextView article_date;
    TextView article_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);


        back = findViewById(R.id.back);
        article_banner = findViewById(R.id.article_banner);
        article_avatar = findViewById(R.id.article_avatar);
        article_title = findViewById(R.id.article_title);
        article_username = findViewById(R.id.article_username);
        article_date = findViewById(R.id.article_date);
        article_content = findViewById(R.id.article_content);


        Article article = (Article)getIntent().getBundleExtra("value").getSerializable("article");

        Glide.with(this).load(article.getUserAvatar()).into(article_avatar);
        Glide.with(this)
                .load(article.getBanner())
                .centerCrop()
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        article_banner.setBackground(resource);
                    }
                });
        article_content.setText(article.getContent());
        article_title.setText(article.getTitle());
        article_username.setText(article.getUserName());
        article_content.setText(article.getContent());
        article_date.setText(article.getDate_post());

        addEvents();
    }

    private void addEvents() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
package com.example.plantsearching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.plantsearching.Adapter.ArticleAdapter;
import com.example.plantsearching.Adapter.PhotographyAdapter;
import com.example.plantsearching.Model.Article;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ArticleActivity extends AppCompatActivity {
    ArrayList<Article> data = new ArrayList<Article>();
    ArticleAdapter adapter;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    RecyclerView rcyArticle;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        back = findViewById(R.id.back);
        rcyArticle = findViewById(R.id.lsv_article);
        firestore.collection("article").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    for(DocumentSnapshot document : queryDocumentSnapshots){
                        Article value = new Article();
                        value.setBanner(document.getString("banner"));
                        value.setContent(document.getString("content"));
                        value.setDate_post(document.getString("date_post"));
                        value.setUserAvatar(document.getString("user_avatar"));
                        value.setTitle(document.getString("title"));
                        value.setUserName(document.getString("user_name"));
                        value.setTag(document.getString("tag"));
                        data.add(value);
                    }
                    rcyArticle.setLayoutManager(new LinearLayoutManager(ArticleActivity.this, LinearLayoutManager.VERTICAL, false));
                    adapter = new ArticleAdapter(ArticleActivity.this,data);
                    rcyArticle.setAdapter(adapter);
                }
            }
        });

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
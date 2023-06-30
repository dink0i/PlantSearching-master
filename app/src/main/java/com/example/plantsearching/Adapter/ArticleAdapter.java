package com.example.plantsearching.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.plantsearching.ArticleDetailActivity;
import com.example.plantsearching.Model.Article;
import com.example.plantsearching.R;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Article> data;
    LayoutInflater layoutInflater;


    public ArticleAdapter(Context context, ArrayList<Article>data){
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.listview_article_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(data.get(position).getBanner())
                .into(holder.article_banner);
        Glide.with(context)
                .load(data.get(position).getUserAvatar())
                .into(holder.article_avatar);
        holder.article_title.setText(data.get(position).getTitle());
        holder.article_username.setText(data.get(position).getUserName());
        holder.article_date.setText(data.get(position).getDate_post());
        holder.setArticle(data.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArticleDetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("article",holder.article);
                intent.putExtra("value",bundle);

                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView article_banner;
        ImageView article_avatar;
        TextView article_title;
        TextView article_username;
        TextView article_date;

        Article article;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            article_banner = itemView.findViewById(R.id.article_banner);
            article_avatar = itemView.findViewById(R.id.article_avatar);
            article_title = itemView.findViewById(R.id.article_title);
            article_username = itemView.findViewById(R.id.article_username);
            article_date = itemView.findViewById(R.id.article_date);


        }

        public void setArticle(Article article) {
            this.article = article;
        }
    }
}

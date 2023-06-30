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
import com.example.plantsearching.Model.Species;

public class PlantDetailActivity extends AppCompatActivity {

    TextView title;
    TextView kingdom;
    TextView family;
    TextView description;
    ConstraintLayout image;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        title = findViewById(R.id.title);
        kingdom = findViewById(R.id.kingdom);
        family = findViewById(R.id.family);
        description = findViewById(R.id.description);
        image = findViewById(R.id.image);
        back = findViewById(R.id.back);

        Species species = (Species) getIntent().getBundleExtra("value").getSerializable("plant");
        title.setText(species.getTitle());
        kingdom.setText(species.getKingdom());
        family.setText(species.getFamily());
        description.setText(species.getDescription());

        Glide.with(this)
                .load(species.getImage())
                .centerCrop()
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        image.setBackground(resource);
                    }
                });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
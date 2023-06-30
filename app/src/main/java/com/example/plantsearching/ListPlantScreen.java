package com.example.plantsearching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantsearching.Adapter.ArticleAdapter;
import com.example.plantsearching.Adapter.PlantAdapter;
import com.example.plantsearching.Model.Article;
import com.example.plantsearching.Model.Species;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListPlantScreen extends AppCompatActivity {

    ArrayList<Species> data = new ArrayList<Species>();
    TextView big_text_view;
    PlantAdapter adapter;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    RecyclerView lsv_plants;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_plant_screen);

        back = findViewById(R.id.back);
        big_text_view = findViewById(R.id.big_text_view);
        lsv_plants = findViewById(R.id.lsv_plants);
        String type = getIntent().getStringExtra("type");
        big_text_view.setText(type);
        firestore.collection("species").document(type).collection("detail").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    for(DocumentSnapshot document : queryDocumentSnapshots){
                        Species value = new Species();
                        value.setTitle(document.getString("title"));
                        value.setDescription(document.getString("description"));
                        value.setFamily(document.getString("family"));
                        value.setKingdom(document.getString("kingdom"));
                        value.setImage(document.getString("image"));
                        data.add(value);
                    }
                    lsv_plants.setLayoutManager(new LinearLayoutManager(ListPlantScreen.this, LinearLayoutManager.VERTICAL, false));
                    adapter = new PlantAdapter(ListPlantScreen.this,data);
                    lsv_plants.setAdapter(adapter);
                }
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
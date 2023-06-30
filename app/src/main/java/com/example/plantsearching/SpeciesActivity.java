package com.example.plantsearching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.plantsearching.Adapter.SpeciesAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SpeciesActivity extends AppCompatActivity {
    ListView lsvSpecies;
    ArrayList<String> data;
    ImageView back;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species);
        lsvSpecies = findViewById(R.id.lsvSpecies);
        back = findViewById(R.id.back);

        data = new ArrayList<>();
        firestore.collection("species").orderBy("type", Query.Direction.ASCENDING).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty()){
                    for(DocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                        data.add(documentSnapshot.getString("type"));
                    }
                    SpeciesAdapter adapter = new SpeciesAdapter(SpeciesActivity.this,data);
                    adapter.setOnItemClickListener(new SpeciesAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(String item) {
                            Intent intent = new Intent(SpeciesActivity.this, ListPlantScreen.class);
                            intent.putExtra("type",item);
                            startActivity(intent);
                        }
                    });
                    lsvSpecies.setAdapter(adapter);
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
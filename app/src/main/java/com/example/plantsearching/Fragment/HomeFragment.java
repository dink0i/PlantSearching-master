package com.example.plantsearching.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.plantsearching.Adapter.PhotographyAdapter;
import com.example.plantsearching.ArticleActivity;
import com.example.plantsearching.CameraActivity;
import com.example.plantsearching.R;
import com.example.plantsearching.SpeciesActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFragment extends Fragment {

    CardView btn_to_article;
    CardView linkToSpecies,linkToCamera;
    RecyclerView lsvPhotography;
    ArrayList<String> photographyData = new ArrayList<String>();
    PhotographyAdapter adapter;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    public HomeFragment() {

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_to_article = view.findViewById(R.id.btn_to_article);
        lsvPhotography = view.findViewById(R.id.lsvPhotography);
        linkToSpecies = view.findViewById(R.id.linkToSpecies);
        linkToCamera = view.findViewById(R.id.linkToCamera);
        loadData();



        addEvents();

        return view;
    }

    private void loadData() {
        firestore.collection("photography").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    QuerySnapshot queryDocumentSnapshot = task.getResult();
                    if(!queryDocumentSnapshot.isEmpty()){
                        for(DocumentSnapshot document : queryDocumentSnapshot){
                            photographyData.add(document.getString("source"));
                        }
                        lsvPhotography.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        adapter = new PhotographyAdapter(getActivity(),photographyData);
                        lsvPhotography.setAdapter(adapter);
                    }
                }
            }
        });
    }

    private void addEvents() {
        btn_to_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ArticleActivity.class);
                startActivity(intent);
            }
        });
        linkToSpecies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SpeciesActivity.class);
                startActivity(intent);
            }
        });

        linkToCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.ratmstudents.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratmstudents.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {
    RecyclerView placementsRecycler,visitRecycler,workRecycler,otherRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        placementsRecycler = view.findViewById(R.id.placementsRecycler);
        visitRecycler = view.findViewById(R.id.visitRecycler);
        workRecycler = view.findViewById(R.id.workRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);


        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getPlaceImage();
        getVisitImage();
        getWorkImage();
        getOtherImage();

        return view;
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                  String data = (String) dataSnapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }



    private void getWorkImage() {
        reference.child("Workshop").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(),imageList);
                workRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                workRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }




    private void getVisitImage() {
        reference.child("Visits").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(),imageList);
                visitRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                visitRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }




    private void getPlaceImage() {
        reference.child("Placement").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(),imageList);
                placementsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                placementsRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }


}

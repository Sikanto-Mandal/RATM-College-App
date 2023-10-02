package com.example.ratmstudents.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratmstudents.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {
    private RecyclerView mcaDepartment, mbaDepartment,bscDepartment,bcaDepartment,bbaDepartment,bedDepartment, medDepartment,tpDepartment;
    private LinearLayout mcaNoData, mbaNoData, bscNoData, bcaNoData, bbaNoData, bedNoData,medNoData,tpNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8;

    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);


        mcaDepartment = view.findViewById(R.id.mcaDepartment);
        mbaDepartment = view.findViewById(R.id.mbaDepartment);
        bscDepartment = view.findViewById(R.id.bscDepartment);
        bcaDepartment = view.findViewById(R.id.bcaDepartment);
        bbaDepartment = view.findViewById(R.id.bbaDepartment);
        bedDepartment = view.findViewById(R.id.bedDepartment);
        medDepartment = view.findViewById(R.id.medDepartment);
        tpDepartment = view.findViewById(R.id.tpDepartment);

        mcaNoData = view.findViewById(R.id.mcaNoData);
        mbaNoData = view.findViewById(R.id.mbaNoData);
        bscNoData = view.findViewById(R.id.bscNoData);
        bcaNoData = view.findViewById(R.id.bcaNoData);
        bbaNoData = view.findViewById(R.id.bbaNoData);
        bedNoData = view.findViewById(R.id.bedNoData);
        medNoData = view.findViewById(R.id.medNoData);
        tpNoData = view.findViewById(R.id.tpNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Teacher");

        mcaDepartment();
        mbaDepartment();
        bscDepartment();
        bcaDepartment();
        bbaDepartment();
        bedDepartment();
        medDepartment();
        tpDepartment();

        return view;

    }

    private void mcaDepartment() {
        dbRef = reference.child("MCA Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    mcaNoData.setVisibility(View.VISIBLE);
                    mcaDepartment.setVisibility(View.GONE);
                } else{
                    mcaNoData.setVisibility(View.GONE);
                    mcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    mcaDepartment.setHasFixedSize(true);
                    mcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    mcaDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mbaDepartment() {
        dbRef = reference.child("MBA Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    mbaNoData.setVisibility(View.VISIBLE);
                    mbaDepartment.setVisibility(View.GONE);
                } else{
                    mbaNoData.setVisibility(View.GONE);
                    mbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mbaDepartment.setHasFixedSize(true);
                    mbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    mbaDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bscDepartment() {
        dbRef = reference.child("BSc Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                    bscNoData.setVisibility(View.VISIBLE);
                    bscDepartment.setVisibility(View.GONE);
                } else{
                    bscNoData.setVisibility(View.GONE);
                    bscDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    bscDepartment.setHasFixedSize(true);
                    bscDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    bscDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bcaDepartment() {
        dbRef = reference.child("BCA Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    bcaNoData.setVisibility(View.VISIBLE);
                    bcaDepartment.setVisibility(View.GONE);
                } else{
                    bcaNoData.setVisibility(View.GONE);
                    bcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    bcaDepartment.setHasFixedSize(true);
                    bcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    bcaDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bbaDepartment() {
        dbRef = reference.child("BBA Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if(!snapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bbaDepartment.setVisibility(View.GONE);
                } else{
                    bbaNoData.setVisibility(View.GONE);
                    bbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    bbaDepartment.setHasFixedSize(true);
                    bbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    bbaDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bedDepartment() {
        dbRef = reference.child("BEd Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if(!snapshot.exists()){
                    bedNoData.setVisibility(View.VISIBLE);
                    bedDepartment.setVisibility(View.GONE);
                } else{
                    bedNoData.setVisibility(View.GONE);
                    bedDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    bedDepartment.setHasFixedSize(true);
                    bedDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6,getContext());
                    bedDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void medDepartment() {
        dbRef = reference.child("MEd Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                if(!snapshot.exists()){
                    medNoData.setVisibility(View.VISIBLE);
                    medDepartment.setVisibility(View.GONE);
                } else{
                    medNoData.setVisibility(View.GONE);
                    medDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    medDepartment.setHasFixedSize(true);
                    medDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7,getContext());
                    medDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void tpDepartment() {
        dbRef = reference.child("TP Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list8 = new ArrayList<>();
                if(!snapshot.exists()){
                    tpNoData.setVisibility(View.VISIBLE);
                    tpDepartment.setVisibility(View.GONE);
                } else{
                    tpNoData.setVisibility(View.GONE);
                    tpDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot :snapshot.getChildren() ){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    tpDepartment.setHasFixedSize(true);
                    tpDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list8,getContext());
                    tpDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error ) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

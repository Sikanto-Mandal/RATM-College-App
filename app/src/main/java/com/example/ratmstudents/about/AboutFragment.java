package com.example.ratmstudents.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.ratmstudents.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ImageView map;
    private TextView textMap ,number;
    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel>list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_computer,"MCA Department","For the MCA intake sheet in 1st year is 60 students."));
        list.add(new CourseModel(R.drawable.ic_mba,"MBA Department","For the MBA intake sheet in 1st year is 120 students."));
        list.add(new CourseModel(R.drawable.ic_math,"BSc Department","For the MBA intake sheet in 1st year is 120 students."));
        list.add(new CourseModel(R.drawable.ic_computer,"BCA Department","For the MBA intake sheet in 1st year is 120 students."));

        adapter = new CourseAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        map = view.findViewById(R.id.map);
        textMap = view.findViewById(R.id.textMap);
        number = view.findViewById(R.id.number);

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDial();
            }
        });

        textMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2Fclg.jpg?alt=media&token=04ae7a73-6daf-480f-9ec8-aa16dd45958f")
                .into(imageView);


        return  view;
    }
    private void openDial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:99997596633"));
        startActivity(intent);
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Rajiv Academy for Technology and Management");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
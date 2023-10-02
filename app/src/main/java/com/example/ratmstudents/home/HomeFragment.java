package com.example.ratmstudents.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;
import com.example.ratmstudents.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private ImageView map;
    private TextView textMap ,number;


    private AutoImageSlider autoImageSlider;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);



        ArrayList<ImageSlidesModel> autoImageList = new ArrayList<>();
        autoImageSlider = view.findViewById(R.id.autoImageSlider);

        try {
            autoImageList.add(new ImageSlidesModel("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2Fclg.jpg?alt=media&token=04ae7a73-6daf-480f-9ec8-aa16dd45958f", ImageScaleType.FIT));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2Fimages.jpg?alt=media&token=a8d01386-2345-4a3b-ad09-eab54769655b", ImageScaleType.FIT));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2Frajiv-academy-for-technology-management-mathura-247389.jpg?alt=media&token=89b25003-04df-442e-90f5-22d4157b1952", ImageScaleType.FIT));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2Frajiv-academy-for-technology-management-mathura-247390.jpg?alt=media&token=bfcadba3-ee6c-42e3-ae2b-2bde58c92552", ImageScaleType.FIT));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2F1586543267rajiv12.webp?alt=media&token=d13256b1-c94a-4154-8d33-90a825e30931", ImageScaleType.FIT));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        try {
            autoImageList.add(new ImageSlidesModel("https://firebasestorage.googleapis.com/v0/b/ratm-app.appspot.com/o/PHOTOS%2Fimages%20(1).jpg?alt=media&token=721ac0df-22b1-4b01-a67e-0ae85997f491", ImageScaleType.FIT));
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT);

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



        return view;
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
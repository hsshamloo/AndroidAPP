package com.ps.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.zip.Inflater;


/**
 * Created by UserPc on 5/9/2015.
 */
public class FragmentViewIcon extends Fragment {

    public ImageButton imgaboutus, imgfaculties, imgphysicians, imgservices, imgnews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.icon_view_fragment, container, false);
        imgaboutus = (ImageButton) view.findViewById(R.id.imgaboutus);
        imgfaculties = (ImageButton) view.findViewById(R.id.imgfaculties);
        imgphysicians = (ImageButton) view.findViewById(R.id.imgphysicians);
        imgservices = (ImageButton) view.findViewById(R.id.imgservices);
        imgnews = (ImageButton) view.findViewById(R.id.imgnews);

        imgaboutus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                imgAboutUsClick(v);
            }
        });



        return view;


    }


    public void imgAboutUsClick(View v) {
        //Toast.makeText(getActivity(),"This is message",Toast.LENGTH_SHORT);
         startActivity(new Intent(getActivity(),AboutUsActivity.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}

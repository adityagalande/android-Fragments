package com.covidupdate.androidme;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.covidupdate.androidme.data.AndroidmageAssets;

import java.util.ArrayList;
import java.util.List;

public class LegPartFragment extends Fragment {
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = "LegFragment";
    private List<Integer> LegImageId;
    private int LegListIndex;


    public LegPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            LegImageId = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            LegListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //To get referance to the image view in fragment layout
        View rootView = inflater.inflate(R.layout.fragment_leg_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.leg_part_image_view);
        if (LegImageId != null){
            imageView.setImageResource(LegImageId.get(LegListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(LegListIndex < LegImageId.size()-1){
                        LegListIndex++;
                    }else{
                        LegListIndex=0;
                    }
                    imageView.setImageResource(LegImageId.get(LegListIndex));
                }
            });

        }else {
            Log.v(TAG,"Leg Fragment Null!!");
        }
        return rootView;
    }

    public void setLegImageId(List<Integer> legImageId){
        LegImageId = legImageId;
    }

    public void setLegListIndex(int legListIndex){
        LegListIndex = legListIndex;
    }

    @Override
    public void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        savedInstanceState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) LegImageId);
        savedInstanceState.putInt(LIST_INDEX, LegListIndex);
    }
}

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

public class BodyPartFragment extends Fragment {
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = "BodyFragment";
    private List<Integer> BodyImageId;
    private int BodyListIndex;

    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            BodyImageId = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            BodyListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //To get referance to the image view in fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);
        if (BodyImageId != null){
            imageView.setImageResource(BodyImageId.get(BodyListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(BodyListIndex < BodyImageId.size()-1){
                        BodyListIndex++;
                    }else{
                        BodyListIndex=0;
                    }
                    imageView.setImageResource(BodyImageId.get(BodyListIndex));
                }
            });

        }else {
            Log.v(TAG,"Leg Fragment Null!!");
        }
        return rootView;
    }

    public void setBodyImageId(List<Integer> bodyImageId){
        BodyImageId = bodyImageId;
    }

    public void setBodyListIndex(int bodyListIndex){
        BodyListIndex = bodyListIndex;
    }

    @Override
    public void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        savedInstanceState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) BodyImageId);
        savedInstanceState.putInt(LIST_INDEX, BodyListIndex);
    }

}

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

import java.util.ArrayList;
import java.util.List;

public class HeadPartFragment extends Fragment {
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = "HeadFragment";
    private List<Integer> HeadImageId;
    private int HeadListIndex;


    public HeadPartFragment(){
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            HeadImageId = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            HeadListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //To get referance to the image view in fragment layout
        View rootView = inflater.inflate(R.layout.fragment_head_part, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.head_part_image_view);
        if(HeadImageId != null){
            imageView.setImageResource(HeadImageId.get(HeadListIndex));
//            imageView.setImageResource(AndroidmageAssets.getHeads().get(0));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(HeadListIndex < HeadImageId.size()-1){
                        HeadListIndex++;
                    }else{
                        HeadListIndex=0;
                    }
                    imageView.setImageResource(HeadImageId.get(HeadListIndex));
                }
            });

        }else {
            Log.v(TAG,"This Fragment is Null!!");
        }
        return rootView;
    }

    public void setHeadImageId(List<Integer> imageId){
        HeadImageId = imageId;
    }

    public void setHeadIndexId(int indexId){
        HeadListIndex = indexId;
    }

    @Override
    public void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        savedInstanceState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) HeadImageId);
        savedInstanceState.putInt(LIST_INDEX, HeadListIndex);
    }
}

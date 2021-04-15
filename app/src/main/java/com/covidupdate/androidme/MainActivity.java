package com.covidupdate.androidme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.covidupdate.androidme.data.AndroidmageAssets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            HeadPartFragment headFragment = new HeadPartFragment();
            headFragment.setHeadImageId(AndroidmageAssets.getHeads());
            headFragment.setHeadIndexId(4);
            FragmentManager HeadFragmentManager = getSupportFragmentManager();
            HeadFragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();

            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setBodyImageId(AndroidmageAssets.getBodies());
            bodyPartFragment.setBodyListIndex(4);
            FragmentManager BodyFragmentManager = getSupportFragmentManager();
            BodyFragmentManager.beginTransaction().add(R.id.body_container, bodyPartFragment).commit();

            LegPartFragment legPartFragment = new LegPartFragment();
            legPartFragment.setLegImageId(AndroidmageAssets.getLegs());
            legPartFragment.setLegListIndex(4);
            FragmentManager LegFragmentManager = getSupportFragmentManager();
            LegFragmentManager.beginTransaction().add(R.id.leg_container, legPartFragment).commit();
        }
    }
}
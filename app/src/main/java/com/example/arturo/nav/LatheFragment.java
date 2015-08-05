package com.example.arturo.nav;

/**
 * Created by arturo on 7/22/15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by Admin on 04-06-2015.
 */
public class LatheFragment extends Fragment{


    LinearLayout mLinearLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lathe_fragment, container, false);
        //textView = (TextView) v.findViewById(R.id.testview);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.content_frament_layout);


        return v;

    }








}
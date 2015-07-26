package com.example.arturo.nav;

/**
 * Created by arturo on 7/22/15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends Fragment {

    EditText dia;
    EditText sfm;
    EditText rpm;
    EditText numTeeth;
    EditText chipload;
    EditText feedRate;
    TextView textView;


    public Double mDia;
    public Double mSfm;
    public Double mRpm;
    public Double mNumTeeth;
    public Double mChipload;
    public Double mFeedrate;

    LinearLayout mLinearLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment, container, false);
        dia = (EditText) v.findViewById(R.id.mill_dia);
        sfm = (EditText) v.findViewById(R.id.mill_sfm);
        rpm = (EditText) v.findViewById(R.id.mill_rpm);
        numTeeth = (EditText) v.findViewById(R.id.mill_num_teeth);
        chipload = (EditText) v.findViewById(R.id.mill_chipload);
        feedRate = (EditText) v.findViewById(R.id.mill_feed);
        //textView = (TextView) v.findViewById(R.id.testview);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.content_frament_layout);



        dia.addTextChangedListener(new ReturnValueFromEditText(dia, sfm, rpm));
        sfm.addTextChangedListener(new SurfaceFoot(dia,sfm, rpm));
        rpm.addTextChangedListener(new GetRpm(dia,sfm, rpm));



        return v;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        double pretendNum = .2 * .5 * 300;
        String total2 = String.valueOf(pretendNum);
        Snackbar.make(mLinearLayout, total2 , Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


}
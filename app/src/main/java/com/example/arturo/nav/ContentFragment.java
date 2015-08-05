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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;


/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {

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
    private Double calculatedSfm;
    private Double calculatedRpm;
    private double calculatedChipload;
    private Double calculatedFeedrate;
    private Double calculatedResults;
    private double tmpChip;
    DecimalFormat numberFormat = new DecimalFormat("#.00000");

    LinearLayout mLinearLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment, container, false);
        //textView = (TextView) v.findViewById(R.id.testview);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.content_frament_layout);
        Button b = (Button) v.findViewById(R.id.calButton);
        Button r = (Button) v.findViewById(R.id.ResetButton);
        r.setOnClickListener(this);
        b.setOnClickListener(this);



        return v;

    }

    @Override
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.calButton:

               calculateRpm();

                break;
            case R.id.ResetButton:

                resetFields();
                //v.clearFocus();
                break;
        }

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        double pretendNum = .2 * .5 * 300;
        String total2 = String.valueOf(pretendNum);
        Snackbar.make(mLinearLayout, total2 , Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }



    private void calculateRpm (){
        dia = (EditText) getActivity().findViewById(R.id.mill_dia);
        sfm = (EditText) getActivity().findViewById(R.id.mill_sfm);
        rpm = (EditText) getActivity().findViewById(R.id.mill_rpm);
        numTeeth = (EditText) getActivity().findViewById(R.id.mill_num_teeth);
        chipload = (EditText) getActivity().findViewById(R.id.mill_chipload);
        feedRate = (EditText) getActivity().findViewById(R.id.mill_feed);


        mDia = getDouble(dia);
        mSfm = getDouble(sfm);
        mRpm = getDouble(rpm);
        mNumTeeth = getDouble(numTeeth);
        mChipload = getDouble(chipload);
        mFeedrate = getDouble(feedRate);

        if(mRpm <= 0) {
            calculatedRpm = mSfm / mDia * 3.82;
            rpm.setText("" + calculatedRpm);



        }

        if(mSfm <= 0) {
            calculatedSfm= .262 * mRpm * mDia;
            sfm.setText("" + calculatedSfm);
        }

        if(mChipload <= 0 && mNumTeeth != 0.0){


            if(mRpm <= 0.0){
                calculatedRpm = mSfm / mDia * 3.82;
            }else{
                calculatedRpm = mRpm;
            }



            calculatedChipload =calculatedRpm * mNumTeeth;
            calculatedChipload = mFeedrate / calculatedChipload;

            //double factor = 1e5; // = 1 * 10^5 = 100000.
            //calculatedChipload = Math.round(calculatedChipload *factor)/factor;



            chipload.setText("" + tmpChip);
        }



        if(mFeedrate <= 0 && mNumTeeth != 0.0){

            if(mRpm <= 0.0){
                calculatedRpm = mSfm / mDia * 3.82;
            }else{
                calculatedRpm = mRpm;
            }



            calculatedFeedrate = mNumTeeth * mChipload * mRpm;

            feedRate.setText("" + calculatedFeedrate);
        }

    }

    public void resetFields(){

        if(dia != null) {


            dia.setText(null);
            sfm.setText(null);
            rpm.setText(null);
            numTeeth.setText(null);
            chipload.setText(null);
            feedRate.setText(null);
        }

    }

    public double getDouble(EditText e) {
        //Get the value from the corresponding EditText
        String tmpString = String.valueOf(e.getText());

        //Check if the field is blank, if it is make it equal to zero
        if (tmpString.length() > 0) {

            if (Character.isDigit(tmpString.charAt(0))) {

                tmpString = String.valueOf(e.getText());

            } else {
                tmpString = "0" + String.valueOf(e.getText());

            }

        } else {
            tmpString = "0.0";
        }

        Double tmpDouble = Double.valueOf(tmpString);

        return tmpDouble;

    }


}
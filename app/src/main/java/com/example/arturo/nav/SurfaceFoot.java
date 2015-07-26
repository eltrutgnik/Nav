package com.example.arturo.nav;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by arturocastro on 7/23/15.
 */
public class SurfaceFoot implements TextWatcher {


    public Double mSfm;

    private String mSfmString;
    private EditText mEditText;
    private EditText mEditTexttwo;
    private EditText mEditTextthree;
    public Double mDia;
    private String mDiaString;
    public double calculatedRPM;


    public  SurfaceFoot(EditText d, EditText e, EditText s){

        mEditText = e;
        mEditTexttwo = s;
        mEditTextthree = d;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {


        //check if is string length is 0
        if (s.length() == 0) {
            //if its 0 make it equal to 0
            mSfmString = "0";

        } else {


            //pass the value of EditText into sfmtest
            mSfmString = String.valueOf(mEditText.getText());
            mDiaString = String.valueOf(mEditTextthree.getText());

            //check if sfmtest begins with a number
            if (Character.isDigit(mSfmString.charAt(0))) {
                mSfmString = String.valueOf(mEditText.getText());
            } else {
                mSfmString = "0" + String.valueOf(mEditText.getText());
            }

            if (Character.isDigit(mDiaString.charAt(0))) {
                mDiaString = String.valueOf(mEditTextthree.getText());
            } else {
                mDiaString = "0" + String.valueOf(mEditTextthree.getText());
            }


            mSfm = Double.valueOf(mSfmString);
            mDia = Double.valueOf(mDiaString);


            calculatedRPM = mSfm / mDia * 3.82;
            //mEditTexttwo.setText("hi");
            mEditTexttwo.setText("" + calculatedRPM);


        }


    }
}






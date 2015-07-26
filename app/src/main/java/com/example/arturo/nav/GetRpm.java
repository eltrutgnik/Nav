package com.example.arturo.nav;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by arturo on 7/26/15.
 */
public class GetRpm implements TextWatcher {

    private EditText mEditText;
    private EditText mEditTexttwo;
    private EditText mEditTextthree;

    private Double mDia;
    private Double mSfm;
    private Double mRpm;

    private String mDiaString;
    private String mSfmString;
    private String mRpmString;


    public double calculatedSfm;

    public GetRpm(EditText d, EditText s, EditText r){
        mEditText = d;
        mEditTexttwo = s;
        mEditTextthree = r;


    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if (s.length() == 0) {
            //if its 0 make it equal to 0
            mRpmString = "0";
        }else{

            //pass the value of EditText into sfmtest
            mDiaString = String.valueOf(mEditText.getText());
            mRpmString = String.valueOf(mEditTextthree.getText());

            if(mDiaString.length() != 0 ){

                //check if sfmtest begins with a number
                if (Character.isDigit(mRpmString.charAt(0))) {
                    mRpmString = String.valueOf(mEditTextthree.getText());
                } else {
                    mRpmString = "0" + String.valueOf(mEditTextthree.getText());
                }

                if (Character.isDigit(mDiaString.charAt(0))) {
                    mDiaString = String.valueOf(mEditText.getText());
                } else {
                    mDiaString = "0" + String.valueOf(mEditText.getText());
                }


                mRpm = Double.valueOf(mRpmString);
                mDia = Double.valueOf(mDiaString);


                calculatedSfm = .262 * mRpm * mDia;
                mEditTexttwo.setText("" + calculatedSfm);


            }

        }

    }
}

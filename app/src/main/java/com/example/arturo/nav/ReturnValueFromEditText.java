package com.example.arturo.nav;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by arturocastro on 7/23/15.
 */
public class ReturnValueFromEditText implements TextWatcher {

    private Double mDia;
    private Double mSfm;
    private Double mRpm;
    public double calculatedRPM;

    private String mDiaString;
    private String mSfmString;
    private String mRpmString;

    private EditText mEditText;
    private EditText mEditTextTwo;
    private EditText mEditTextThree;


    public ReturnValueFromEditText(EditText e, EditText s, EditText r) {

        mEditText = e;
        mEditTextTwo = s;
        mEditTextThree = r;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        //check if is string length is 0
        if (s.length() == 0) {
            //if its 0 make it equal to 0
            mDiaString = "0";

        } else {

            //pass the value of EditText into mDia
            mDiaString = String.valueOf(mEditText.getText());
            mSfmString = String.valueOf(mEditTextTwo.getText());
            mRpmString = String.valueOf(mEditTextThree.getText());



            if(mSfmString.length() != 0){
                mSfmString = String.valueOf(mEditTextTwo.getText());
                mRpmString = "0";

                //check if mDia begins with a number
                if (Character.isDigit(mDiaString.charAt(0))) {
                    mDiaString = String.valueOf(mEditText.getText());
                } else {
                    mDiaString = "0" + String.valueOf(mEditText.getText());
                }

                //check if mDia begins with a number
                if (Character.isDigit(mSfmString.charAt(0))) {
                    mSfmString = String.valueOf(mEditTextTwo.getText());
                } else {
                    mSfmString = "0" + String.valueOf(mEditTextTwo.getText());
                }

                //check if mDia begins with a number


                mDia = Double.valueOf(mDiaString);
                mSfm = Double.valueOf(mSfmString);
                //mRpm = Double.valueOf(mRpmString);

                calculatedRPM = mSfm / mDia * 3.82;
                //mEditTexttwo.setText("hi");

                if(calculatedRPM > 100000.00){
                    mEditTextThree.setText("0.0");

                }else {
                    mEditTextThree.setText("" + calculatedRPM);
                }



            }



        }

        //mDia = Double.valueOf(mDiaString);
        ///textView.setText("You have entered : " + sfm);
    }



}
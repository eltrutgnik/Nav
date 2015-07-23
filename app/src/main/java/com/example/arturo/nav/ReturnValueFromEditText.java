package com.example.arturo.nav;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by arturocastro on 7/23/15.
 */
public class ReturnValueFromEditText implements TextWatcher {
    private Context mContext;
    public EditText dia;
    public TextView textView;
    String sfmtest;
    public Double sfm;

    public ReturnValueFromEditText(EditText edittextview) {
        //super();
        //this.mContext = context;
        this.dia= edittextview;

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
            sfmtest = "0";

        } else {

            //pass the value of EditText into sfmtest
            sfmtest = String.valueOf(dia.getText());

            //check if sfmtest begins with a number
            if (Character.isDigit(sfmtest.charAt(0))) {
                sfmtest = String.valueOf(dia.getText());
            } else {
                sfmtest = "0" + String.valueOf(dia.getText());
            }

        }

        sfm = Double.valueOf(sfmtest);

        textView.setText("You have entered : " + sfm);


    }



}
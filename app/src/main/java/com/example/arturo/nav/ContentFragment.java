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
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends Fragment {

    public EditText dia;
    public TextView textView;
    String sfmtest;
    public Double sfm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment, container, false);
        dia = (EditText) v.findViewById(R.id.mill_dia);

        dia.addTextChangedListener(new ReturnValueFromEditText( dia));
        textView = (TextView) v.findViewById(R.id.testview);


        /*




        dia.addTextChangedListener(new TextWatcher() {
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
        });*/


        return v;

    }



}
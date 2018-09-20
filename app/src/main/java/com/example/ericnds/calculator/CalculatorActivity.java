package com.example.ericnds.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView numview;
    private String num="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview=findViewById(R.id.currentnum);
        numview.setText(num);
    }
    public void onClickDigit(View view){
        Button b=(Button)view;
        num+=b.getText().toString().charAt(0);
        numview.setText(num);

    }
    public void onClickOper(View view){

    }
    public void onClickEquals(View view){

    }
    public void onClickDot(View view){

    }
}

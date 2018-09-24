package com.example.ericnds.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class CalculatorActivity extends AppCompatActivity {

    private TextView numview;
    private String num="", currentOperator="";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview=findViewById(R.id.currentnum);
        numview.setText(num);
    }
    private void displayScreen(){
        numview.setText(num);
    }
    public void onClickDigit(View view){
        if(result != ""){
            clear();
            displayScreen();
        }
        Button b=(Button)view;
        num+=b.getText();
        displayScreen();

    }
    private boolean isOperator(char op) {
        switch (op) {
            case '+':
            case '-':
            case '*':
            case '/': return true;
            default: return false;

        }
    }
    public void onClickOper(View view){
        if(num=="")return;
        Button b= (Button)view;
        if(result != ""){
            num=result;
            result="";
            currentOperator="";
        }
        if(currentOperator != ""){
            Log.d("CalcX",""+num.charAt(numview.length()-1));
            if(isOperator(num.charAt(numview.length()-1))){

                num.replace(num.charAt(num.length()-1), b.getText().charAt(0));
            }
            else{
                getResult();
                num=result;
                result="";
            }
            currentOperator= b.getText().toString();
        }

        num+=b.getText();
        currentOperator = b.getText().toString();
        displayScreen();
    }

    private boolean getResult(){
        if(currentOperator=="")return false;
        String[] operation=num.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1], currentOperator));
        return true;
    }

    public void onClickEquals(View view){
        if(num=="")return;
    if(!getResult())return;
       numview.setText(num + "\n" + String.valueOf(result));
    }
    public void onClickDot(View view){


    }

    public double operate(String a, String b, String opc){

        switch(opc) {
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "*":
                return Double.valueOf(a) * Double.valueOf(b);
            case "/": try {
                    return Double.valueOf(a) / Double.valueOf(b);
                }catch (Exception e) {

                Log.d("Calc", e.getMessage());
            }
            default: return -1;
        }
    }


    public void onClickDeleteAll(View view) {
        clear();
        displayScreen();
    }
    private void clear(){
        num="";
        currentOperator="";
        result="";

    }


}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.PrintStream;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String temp;
    String topr;
    String str1;
    String str2;
    String opr;
    double res;
    double mem;
    boolean ans;


    TextView textfd1;
    Button seven;
    Button eight;
    Button nine;
    Button plus;
    Button minus;
    Button divide;
    Button multiply;
    Button C;
    Button dot;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button zero;
    Button equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str1 = "";
        str2 = "";
        opr = "";
        temp = "";
        topr = "";
        ans = false;
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        divide = findViewById(R.id.divide);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        dot = findViewById(R.id.dot);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        equal = findViewById(R.id.equal);
        C = findViewById(R.id.C);
        textfd1 = findViewById(R.id.textView2);
        textfd1.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        C.setOnClickListener(this);
        multiply.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        dot.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button bt = (Button)v;
        if(str1 == "Can not divide by zero.")
        {
            str1 = str2 = opr = "";
        }


        if(v.getId() == R.id.dot)
        {
            if(str1 == "")
            {
                str1 = "0.";
            }
            else if(opr == "")
            {
                if(str1.contains("."))
                {}
                else
                {str1 = str1 + "."; }
            }
            else if(str2 == "")
            {
                str2 = "0.";
            }
            else if(opr != "" && str2 !="")
            {
                if(str2.contains("."))
                {}
                else{
                    str2 = str2 + ".";}
            }
        }
        if(opr != "")
        {
            if(v.getId() == R.id.dot || v.getId() == R.id.equal || v.getId() == R.id.plus || v.getId() == R.id.minus|| v.getId() == R.id.multiply|| v.getId() == R.id.divide)
            {

            }
            else{
                str2 = str2 + bt.getText().toString();
            }
        }
        if(v.getId() == R.id.plus || v.getId() == R.id.minus|| v.getId() == R.id.multiply|| v.getId() == R.id.divide)
        {
            if(str1 == "")
            {
                str1 = "0";
            }
            if(str2 == ""){
                if(v.getId() == R.id.plus)
                {
                    opr = "+";
                }
                else if(v.getId() == R.id.minus)
                {
                    opr = "-";
                }
                else if(v.getId() == R.id.multiply)
                {
                    opr = "*";
                }
                else if(v.getId() == R.id.divide)
                {
                    opr = "/";
                }

            }
        }
        if(opr == "")
        {

            if(v.getId() == R.id.equal || v.getId() == R.id.dot)
            {
                if(v.getId() == R.id.dot)
                {
                    str1 = "0.";
                    ans = false;
                }
                if(v.getId() == R.id.equal && ans == true)
                {
                    str2 = temp;
                    opr = topr;
                }
            }
            else {
                if(ans == true)
                {
                    str1 = "";
                    ans = false;
                }
                str1 = str1 + bt.getText().toString();
            }
        }
        if(v.getId() == R.id.C)
        {
            str1 = str2 = opr = "";
        }
        if(v.getId() == R.id.equal || v.getId() == R.id.plus || v.getId() == R.id.minus|| v.getId() == R.id.multiply|| v.getId() == R.id.divide)
        {
            if(v.getId() != R.id.equal && str2 != "")
            {
                if(opr == "+")
                {
                    str1 = add(str1,str2);
                    str2 = "";
                }
                else if(opr == "-")
                {
                    str1 = minus(str1,str2);
                    str2 = "";
                }
                else if(opr == "/")
                {
                    str1 = divide(str1,str2);
                    str2  = "";
                }
                else if(opr == "*")
                {
                    str1 = multiply(str1,str2);
                    str2  = "";
                }
                if(v.getId() == R.id.plus)
                {
                    opr = "+";
                }
                else if(v.getId() == R.id.minus)
                {
                    opr = "-";
                }
                else if(v.getId() == R.id.multiply)
                {
                    opr = "*";
                }
                else if(v.getId() == R.id.divide)
                {
                    opr = "/";
                }
            }
            if(v.getId() == R.id.equal)
            {
                if(str1 == "")
                {
                    str1 = "0";
                }
                if(opr == "")
                {
                    if(Float.parseFloat(str1) == 0)
                    {
                        str1 = "0";
                        ans = true;
                    }
                }
                else{
                    if(opr != "" && str2 == "")
                    {
                        str2 = str1;
                    }
                    if(opr == "+")
                    {
                        str1 = add(str1,str2);
                    }
                    else if(opr == "-")
                    {
                        str1 = minus(str1,str2);
                    }
                    else if(opr == "/")
                    {
                        str1 = divide(str1,str2);
                    }
                    else if(opr == "*")
                    {
                        str1 = multiply(str1,str2);

                    }
                    temp = str2;
                    topr = opr;
                    str2 = opr = "";
                    ans = true;
                }

            }
        }

        //DriverManager.println(bt.getText().toString());
        textfd1.setText(str1 + opr + str2);
    }
    public String add(String first,String second)
    {
        float str1 = Float.parseFloat(first);
        float str2 = Float.parseFloat(second);
        str1 = str1 + str2;
        String sum = Float.toString(str1);
        return sum;
    }
    public String minus(String first,String second)
    {
        float str1 = Float.parseFloat(first);
        float str2 = Float.parseFloat(second);
        str1 = str1 - str2;
        String ans = Float.toString(str1);
        return ans;
    }
    public String multiply(String first,String second)
    {
        float str1 = Float.parseFloat(first);
        float str2 = Float.parseFloat(second);
        str1 = str1 * str2;
        String ans = Float.toString(str1);
        return ans;
    }
    public String divide(String first,String second)
    {
        if(Float.parseFloat(first) == 0)
        {
            return "0";
        }
        if(Float.parseFloat(second) == 0)
        {
            return "Can not divide by zero.";
        }
        float str1 = Float.parseFloat(first);
        float str2 = Float.parseFloat(second);
        str1 = str1 / str2;
        String ans = Float.toString(str1);
        return ans;
    }




}
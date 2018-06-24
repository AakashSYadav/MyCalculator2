
package com.blogspot.phonespex.www.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.fingerprintAuthDrawable;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

//    private AdView adView;

    private LinearLayout l1;
    private TextView output;
    private TextView outputa;
    private TextView outputb;
    private TextView opper;

    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;

    private Button num7;
    private Button num8;
    private Button num9;
    private Button clear;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button plus;
    private Button minus;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button multiply;
    private Button divide;
    private Button num0;
    private Button backspace;
    private Button equal;
    private Button dot;
    private Button RightBracket;
    private Button LeftBracket;

    private double operator = 0;
    private double value1 = 0;
    private double value2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        initializeLogic();
    }

    private void  initialize() {
        l1 = (LinearLayout) findViewById(R.id.l1);
        output = (TextView) findViewById(R.id.output);
        outputa = (TextView) findViewById(R.id.outputa);
        outputb = (TextView) findViewById(R.id.outputb);
        opper = (TextView) findViewById(R.id.opper);

        l2 = (LinearLayout) findViewById(R.id.l2);
        l3 = (LinearLayout) findViewById(R.id.l3);
        l4 = (LinearLayout) findViewById(R.id.l4);
        l5 = (LinearLayout) findViewById(R.id.l5);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        clear = (Button) findViewById(R.id.clear);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        num0 = (Button) findViewById(R.id.num0);
        backspace = (Button) findViewById(R.id.backspace);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);
        RightBracket = (Button) findViewById(R.id.RightBracket);
        LeftBracket = (Button) findViewById(R.id.LeftBracket);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(1);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(2);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(3);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(4);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(5);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(6);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(7);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(8);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(9);
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(0);
            }
        });
        /*dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _displayNumber(.);
            }
        });*/
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                if (operator == 0) {
                    value1 = value1 / 10;
                    outputa.setText(String.valueOf((long)(value1)));
                }
                else {
                    value2 = value2 / 10;
                    outputb.setText(String.valueOf((long)(value2)));
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _clear();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                if (operator > 0) {
                    _calc();
                }
                operator = 1;
                opper.setText("+");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                if (operator > 0) {
                    _calc();
                }
                operator = 3;
                opper.setText("*");

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
               //2 _displayNumber('/');
                if (operator > 0) {
                    _calc();
                }
                operator = 4;
                opper.setText("/");

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                if (operator > 0) {
                    _calc();
                }
                operator = 2;
                opper.setText("-");

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                _calc();
            }
        });
    }

    private void  initializeLogic() {
        _clear();
    }


    private void _clear () {
        output.setText("0");
        outputa.setText("0");
        outputb.setText("0");
        operator = 0;
        value1 = 0;
        value2 = 0;
    }
    private void _displayNumber (final double _num) {
        String strLong="";
        String strLongb;

        if (operator == 0) {
            value1 = (value1 * 10) + _num;
            strLong = Double.toString(value1);

            outputa.setText(String.valueOf((long)(value1)));
//            output.setText(strLong);

        }
        else {
            value2 = (value2 * 10) + _num;
            strLongb = Double.toString(value1);
            outputb.setText(String.valueOf((long)(value2)));

//            output.setText(strLongb);
        }
    }
    private void _calc () {
        if (operator == 1) {
            value1 = value1 + value2;
            output.setText(Double.toString(value1));
        }
        if (operator == 2) {
            value1 = value1 - value2;
            output.setText(Double.toString(value1));

        }
        if (operator == 3) {
            value1 = value1 * value2;
            output.setText(Double.toString(value1));

        }
        if (operator == 4) {
            if (value2 == 0)
                output.setText("Error!");

            else{
            value1 = value1 / value2;
                output.setText(Double.toString(value1));
            }
        }
//        if (operator > 0) {
//            value2 = 0;
//            operator = 0;
//            if(value1==129906){
//                Intent intent = new Intent(this, Main2Activity.class);
//                startActivity(intent);
//            }
//            output.setText(String.valueOf((long) (value1)));
//        }
    }



}

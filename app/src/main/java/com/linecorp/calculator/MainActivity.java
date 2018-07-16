package com.linecorp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.*;         // double형의 곱셈과 나눗셈을 위한 import

public class MainActivity extends AppCompatActivity {

    /*
    double FirstNumber;
    double SecondNumber;
    double ResultNumber;
    */
    private EditText in1;               // 꼭 여기에 정의 안하고 바로 EditText in1 = (EditText) findView... 하면 안되나
    private EditText in2;               // 그렇게하면 OnClick 함수에서는 인식이 안되나!
    private TextView out;               // 객체지향언어이므로, 접근범위를 설정해주어야 안전하다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in1 = (EditText) findViewById(R.id.input1);
        in2 = (EditText) findViewById(R.id.input2);
        out = (TextView) findViewById(R.id.result);

        findViewById(R.id.plus).setOnClickListener(mClickListener);      // ClickListener 사용에 익숙해지자
        findViewById(R.id.minus).setOnClickListener(mClickListener);
        findViewById(R.id.multi).setOnClickListener(mClickListener);
        findViewById(R.id.div).setOnClickListener(mClickListener);

    }

        Button.OnClickListener mClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float FirstNumber = (Float) Float.parseFloat(in1.getText().toString());
                Float SecondNumber = (Float) Float.parseFloat(in2.getText().toString());
                Float ResultNumber;

                switch(view.getId()) {
                    case R.id.plus:
                        ResultNumber = FirstNumber + SecondNumber;
                        out.setText(Float.toString(ResultNumber));
                        break;

                    case R.id.minus:
                        ResultNumber = FirstNumber - SecondNumber;
                        out.setText(Float.toString(ResultNumber)); // toString(2) -> 2진수로 보이기
                        break;

                    case R.id.multi:                // Double 에서 BigDecimal로 바꿔도 곱하기와 나누기 오류...
                        ResultNumber = FirstNumber * SecondNumber;
                        out.setText(Float.toString(ResultNumber));

                    case R.id.div:
                        ResultNumber = FirstNumber / SecondNumber;
                        out.setText(Float.toString(ResultNumber));
                        /*out.setText(ResultNumber.toString(), 2, BigDecimal.ROUND_UP);*/ //오류났었다

                    default :                                        // ResultNumber = null은 문법적으로 틀린가?
                        Toast.makeText(getApplicationContext(), "잘못된 입력", Toast.LENGTH_LONG).show();
                }
            }
        };
    }

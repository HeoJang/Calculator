package com.linecorp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText in1;
    private EditText in2;
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
            Double FirstNumber = (Double) Double.parseDouble(in1.getText().toString());
            Double SecondNumber = (Double) Double.parseDouble(in2.getText().toString());
            Double ResultNumber;

            switch(view.getId()) {
                case R.id.plus:
                    ResultNumber = FirstNumber + SecondNumber;
                    out.setText(String.valueOf(ResultNumber));
                    break;

                case R.id.minus:
                    ResultNumber = FirstNumber - SecondNumber;
                    out.setText(String.valueOf(ResultNumber));
                    break;

                case R.id.multi:
                    ResultNumber = FirstNumber * SecondNumber;
                    out.setText(String.valueOf(ResultNumber));
                    break;

                case R.id.div:
                    if(SecondNumber == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show();
                        break;
                    }
                    else {
                        ResultNumber = FirstNumber / SecondNumber;
                        out.setText(String.valueOf(ResultNumber));
                        break;
                    }
                default :
                    Toast.makeText(getApplicationContext(), "잘못된 입력", Toast.LENGTH_LONG).show();
            }
        }
    };
}


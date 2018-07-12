package com.linecorp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double FirstNumber;
    double SecondNumber;
    double ResultNumber;
    EditText in1;               // 꼭 여기에 정의 안하고 바로 EditText in1 = (EditText) findView... 하면 안되나
    EditText in2;               // 그렇게하면 OnClick 함수에서는 인식이 안되나!
    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in1 = (EditText) findViewById(R.id.editText1); // 이렇게 일일이 찾아보면서 하다보면 문법이 익숙해지겠지
        in2 = (EditText) findViewById(R.id.editText2);
        out = (TextView) findViewById(R.id.textView2);

        findViewById(R.id.button1).setOnClickListener(mClickListener);      // ClickListener 사용에 익숙해지자
        findViewById(R.id.button2).setOnClickListener(mClickListener);
        findViewById(R.id.button3).setOnClickListener(mClickListener);
        findViewById(R.id.button4).setOnClickListener(mClickListener);

    }

        Button.OnClickListener mClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstNumber = Double.parseDouble(in1.getText().toString());
                SecondNumber = Double.parseDouble(in2.getText().toString());

                switch(view.getId()) {
                    case R.id.button1:
                        ResultNumber = FirstNumber + SecondNumber;
                        break;

                    case R.id.button2:
                        ResultNumber = FirstNumber - SecondNumber;
                        break;

                    case R.id.button3:
                        ResultNumber = FirstNumber * SecondNumber;

                    case R.id.button4:
                        ResultNumber = FirstNumber / SecondNumber;

                    default :
                        Toast.makeText(getApplicationContext(), "잘못된 입력", Toast.LENGTH_LONG).show();
                }


                out.setText(Double.toString(ResultNumber));     // warning?
            }
        };
    }

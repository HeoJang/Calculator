package com.linecorp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linecorp.calculator.R;

public class MainActivity extends AppCompatActivity {

    private EditText ResultText;
    private int FirstNumber = 0;
    private int SecondNumber = 0;
    private int ResultNumber = 0;
    private int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResultText = (EditText) findViewById(R.id.Result);

        findViewById(R.id.plus).setOnClickListener(mClickListener);
        findViewById(R.id.minus).setOnClickListener(mClickListener);
        findViewById(R.id.multi).setOnClickListener(mClickListener);
        findViewById(R.id.div).setOnClickListener(mClickListener);
        findViewById(R.id.clear).setOnClickListener(mClickListener);
        findViewById(R.id.equal).setOnClickListener(mClickListener);


        /* 이부분이 앱실행오류
        for(int i=0; i<15; i++) {
            String buttonID = "n" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            findViewById(resID).setOnClickListener(mClickListener);
        }
        */

        findViewById(R.id.n0).setOnClickListener(mClickListener);
        findViewById(R.id.n1).setOnClickListener(mClickListener);
        findViewById(R.id.n2).setOnClickListener(mClickListener);
        findViewById(R.id.n3).setOnClickListener(mClickListener);
        findViewById(R.id.n4).setOnClickListener(mClickListener);
        findViewById(R.id.n5).setOnClickListener(mClickListener);
        findViewById(R.id.n6).setOnClickListener(mClickListener);
        findViewById(R.id.n7).setOnClickListener(mClickListener);
        findViewById(R.id.n8).setOnClickListener(mClickListener);
        findViewById(R.id.n9).setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.n0:
                    if (ResultText != null) {
                        ResultText.append("0");  // append 붙이다
                    }
                    else {
                        ResultText.setText("0");
                    }
                    break;

                case R.id.n1:
                    if (ResultText != null) {
                        ResultText.append("1");
                    }
                    else {
                        ResultText.setText("1");
                    }
                    break;

                case R.id.n2:
                    if (ResultText != null) {
                        ResultText.append("2");
                    }
                    else {
                        ResultText.setText("2");
                    }
                    break;

                case R.id.n3:
                    if (ResultText != null) {
                        ResultText.append("3");
                    }
                    else {
                        ResultText.setText("3");
                    }
                    break;

                case R.id.n4:
                    if (ResultText != null) {
                        ResultText.append("4");
                    }
                    else {
                        ResultText.setText("4");
                    }
                    break;

                case R.id.n5:
                    if (ResultText != null) {
                        ResultText.append("5");
                    }
                    else {
                        ResultText.setText("5");
                    }
                    break;

                case R.id.n6:
                    if (ResultText != null) {
                        ResultText.append("6");
                    }
                    else {
                        ResultText.setText("6");
                    }
                    break;

                case R.id.n7:
                    if (ResultText != null) {
                        ResultText.append("7");
                    }
                    else {
                        ResultText.setText("7");
                    }
                    break;

                case R.id.n8:
                    if (ResultText != null) {
                        ResultText.append("8");
                    }
                    else {
                        ResultText.setText("8");
                    }
                    break;

                case R.id.n9:
                    if (ResultText != null) {
                        ResultText.append("9");
                    }
                    else {
                        ResultText.setText("9");
                    }
                    break;

                case R.id.plus:
                    //FistNumber에 연산자 이전의 숫자를 문자열로 변환하여 저장
                    FirstNumber = Integer.parseInt(ResultText.getText().toString());
                    ResultText.setText("");
                    index = 0;
                    break;

                case R.id.minus:
                    FirstNumber = Integer.parseInt(ResultText.getText().toString());
                    ResultText.setText("");
                    index = 1;
                    break;

                case R.id.multi:
                    FirstNumber = Integer.parseInt(ResultText.getText().toString());
                    ResultText.setText("");
                    index = 2;
                    break;

                case R.id.div:
                    FirstNumber = Integer.parseInt(ResultText.getText().toString());
                    ResultText.setText("");
                    index = 3;
                    break;

                case R.id.equal:
                    SecondNumber = Integer.parseInt(ResultText.getText().toString());

                    if(index == 0) {
                        ResultNumber = FirstNumber + SecondNumber;
                    }

                    else if(index == 1) {
                        ResultNumber = FirstNumber - SecondNumber;
                    }

                    else if(index == 2) {
                        ResultNumber = FirstNumber * SecondNumber;
                    }

                    else if(index == 3) {
                        ResultNumber = FirstNumber / SecondNumber;
                    }

                    ResultText.setText(Integer.toString(ResultNumber));
                    break;

                case R.id.clear:
                    ClearALL();
                    break;

                default :
                    Toast.makeText(getApplicationContext(), "잘못된 입력", Toast.LENGTH_LONG).show();
            }

        }
        // 초기화 메소드
        public void ClearALL(){
            FirstNumber = 0;
            SecondNumber = 0;
            ResultText.setText("");
        }
    };
}

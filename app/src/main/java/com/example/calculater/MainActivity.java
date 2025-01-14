package com.example.calculater;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView num1,num2;
    EditText answer;
    TextView calcf,calct;
    int t=0,f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.n1);
        num2=findViewById(R.id.n2);
        answer=findViewById(R.id.answer);
        calcf=findViewById(R.id.calcf);
        calct=findViewById(R.id.calct);
    }

    public void level1(View view) {
        num1.setText(String.valueOf(random(0,11)));
        num2.setText(String.valueOf(random(0,11)));
    }

    public void level2(View view) {
        num1.setText(String.valueOf(random(0,11)));
        num2.setText(String.valueOf(random(10,101)));
    }

    public void level3(View view) {
        num1.setText(String.valueOf(random(10,101)));
        num2.setText(String.valueOf(random(10,101)));
    }

    public int random (int n1,int n2){
        Random ra = new Random();
        return ra.nextInt((n2 - n1) + 1) + n1;
    }

    public void ch_answer(View view) {
        if (!(num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty() || answer.getText().toString().isEmpty())) {
            double userAnswer = Double.parseDouble(answer.getText().toString());
            double correctAnswer = Integer.parseInt(num1.getText().toString())*Integer.parseInt(num2.getText().toString());
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            if (userAnswer==correctAnswer) {
                Toast.makeText(this, "أحسنت", Toast.LENGTH_SHORT).show();
                t++;
                calct.setText(String.valueOf(t));
            } else {
                Toast.makeText(this, "خطأ", Toast.LENGTH_SHORT).show();
                f++;
                calct.setText(String.valueOf(f));
            }
        }
        else
            Toast.makeText(this, "يجب ادخال الاجابة وتوليد ارقام", Toast.LENGTH_SHORT).show();
    }
}
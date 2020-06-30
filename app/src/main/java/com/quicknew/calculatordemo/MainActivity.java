package com.quicknew.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button openCalculatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCalculatorBtn = findViewById(R.id.open_calculator_btn);

        openCalculatorBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.open_calculator_btn:
                openCalculator();
                break;
            default:
                break;
        }
    }

    private void openCalculator() {
        Intent intent = new Intent(this,CalculatorActivity.class);
        startActivityForResult(intent,10);
    }
}

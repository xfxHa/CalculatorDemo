package com.quicknew.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    /**
     * 按鈕
     */
    private Button oneBtn, twoBtn, threeBtn, addBtn, subBtn, mulBtn, divBtn, resultBtn, backBtn, cBtn;

    private TextView cacheTv;
    private String fuhao;
    private int cache = 0;
    private int shangUp = 0;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.one_btn:
                    caheNumber(1);
                    break;
                case R.id.two_btn:
                    caheNumber(2);
                    break;
                case R.id.three_btn:
                    caheNumber(3);
                    break;
                case R.id.add_btn:
                    //判断是否第一次加减
                    if (fuhao==null){
                        shangUp=cache;
                        cache=0;
                        fuhao="+";
                    }else {
                        calculatorChar(fuhao);
                        fuhao="+";
                    }
                    break;
                case R.id.sub_btn:
                    if (fuhao==null){
                        fuhao="-";
                    }else {
                        calculatorChar(fuhao);
                        fuhao="-";
                    }
                    break;
                case R.id.mul_btn:
                    if (fuhao==null){
                        fuhao="×";
                    }else {
                        calculatorChar(fuhao);
                        fuhao="×";
                    }
                    break;
                case R.id.div_btn:
                    if (fuhao==null){
                        fuhao="÷";
                    }else {
                        calculatorChar(fuhao);
                        fuhao="÷";
                    }
                    break;
                case R.id.result_btn:
                    if (fuhao==null){

                    }else {
                        calculatorChar(fuhao);
                        fuhao=null;
                        cache=0;
                        shangUp=0;
                    }
                    break;
                //退格
                case R.id.back_btn:
                    back();
                    break;
                //归零
                case R.id.c_btn:
                    toC();
                    break;
                default:
                    break;
            }
        }
    };

    private void calculatorChar(String cha) {
        switch (cha) {
            case "+":
                shangUp=shangUp+cache;
                cache=0;
                cacheTv.setText(String.valueOf(shangUp));
                break;
            case "-":
                shangUp=shangUp-cache;
                cache=0;
                cacheTv.setText(String.valueOf(shangUp));
                break;
            case "×":

                break;
            case "÷":

                break;

        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initViews();

        initListener();
    }

    /**
     * 初始化View
     */
    private void initViews() {
        cacheTv = findViewById(R.id.cache_tv);
        oneBtn = findViewById(R.id.one_btn);
        twoBtn = findViewById(R.id.two_btn);
        threeBtn = findViewById(R.id.three_btn);
        addBtn = findViewById(R.id.add_btn);
        subBtn = findViewById(R.id.sub_btn);
        mulBtn = findViewById(R.id.mul_btn);
        divBtn = findViewById(R.id.div_btn);
        resultBtn = findViewById(R.id.result_btn);
        backBtn = findViewById(R.id.back_btn);
        cBtn = findViewById(R.id.c_btn);
    }

    /**
     * 初始化事件監聽
     */
    private void initListener() {
        oneBtn.setOnClickListener(onClickListener);
        twoBtn.setOnClickListener(onClickListener);
        threeBtn.setOnClickListener(onClickListener);
        addBtn.setOnClickListener(onClickListener);
        subBtn.setOnClickListener(onClickListener);
        mulBtn.setOnClickListener(onClickListener);
        divBtn.setOnClickListener(onClickListener);
        resultBtn.setOnClickListener(onClickListener);
        backBtn.setOnClickListener(onClickListener);
        cBtn.setOnClickListener(onClickListener);
    }

    /**
     * 保存输入的数字
     *
     * @param number 输入的数字
     */
    private void caheNumber(int number) {
        cache = cache * 10 + number;
        cacheTv.setText(String.valueOf(cache));
    }

    /**
     * 退格
     */
    private void back() {
        cache = cache / 10;
        cacheTv.setText(String.valueOf(cache));
    }

    private void toC() {
        cache = 0;
        fuhao=null;
        shangUp = 0;
        cacheTv.setText("0");
    }
}
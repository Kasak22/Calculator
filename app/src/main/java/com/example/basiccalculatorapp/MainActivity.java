package com.example.basiccalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private double operand1 = Double.NaN;
    private double operand2;
    private char currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void onDigit(View view) {
        Button button = (Button) view;
        editText.append(button.getText().toString());
    }

    public void onOperator(View view) {
        Button button = (Button) view;
        if (!Double.isNaN(operand1)) {
            operand2 = Double.parseDouble(editText.getText().toString());
            editText.setText(null);
            calculate();
            currentOperator = button.getText().toString().charAt(0);
        } else {
            operand1 = Double.parseDouble(editText.getText().toString());
            currentOperator = button.getText().toString().charAt(0);
            editText.setText(null);
        }
    }

    public void onEqual(View view) {
        operand2 = Double.parseDouble(editText.getText().toString());
        calculate();
        editText.setText(String.valueOf(operand1));
        operand1 = Double.NaN;
    }

    public void onClear(View view) {
        editText.setText(null);
        operand1 = Double.NaN;
        operand2 = Double.NaN;
    }

    private void calculate() {
        if (!Double.isNaN(operand1)) {
            switch (currentOperator) {
                case '+':
                    operand1 = operand1 + operand2;
                    break;
                case '-':
                    operand1 = operand1 - operand2;
                    break;
                case '*':
                    operand1 = operand1 * operand2;
                    break;
                case '/':
                    operand1 = operand1 / operand2;
                    break;
            }
        }
    }
}

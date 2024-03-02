package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText number1, number2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_linear_layout);

//        listener interface
        findViewById(R.id.DifferenceNumber).setOnClickListener(this);

//        listener in variable + Inline anonymous bind
        findViewById(R.id.QuotientNumber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorActivity.this.onClick(v);
            }
        });

//        listener in class
        findViewById(R.id.DivisorNumber).setOnClickListener(new DivisorNumberButtonClickListener());

//        sub classing

        Log.i("CalculatorActivity", "CalculatorActivity is created");
    }

    public boolean checkingValidInput() {
        number1 = findViewById(R.id.inputSoA);
        number2 = findViewById(R.id.inputSoB);
        result = findViewById(R.id.resultValue);

        if (number1.getText().toString().isEmpty() || number2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    public void SumClick(View view) {
        Log.i("CalculatorActivity", "Sum button is clicked");
        if (checkingValidInput()) {
            return;
        }

        number1 = findViewById(R.id.inputSoA);
        number2 = findViewById(R.id.inputSoB);
        result = findViewById(R.id.resultValue);

        int number1Int = Integer.parseInt(number1.getText().toString());
        int number2Int = Integer.parseInt(number2.getText().toString());

        int sum = number1Int + number2Int;
        result.setText(String.valueOf(sum));
    }

//  Inline anonymous class initialization for DifferenceNumber button
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.DifferenceNumber) {
            Log.i("CalculatorActivity", "Difference button is clicked");
            if (checkingValidInput()) {
                return;
            }

            number1 = findViewById(R.id.inputSoA);
            number2 = findViewById(R.id.inputSoB);
            result = findViewById(R.id.resultValue);

            int number1Int = Integer.parseInt(number1.getText().toString());
            int number2Int = Integer.parseInt(number2.getText().toString());

            int difference = number1Int - number2Int;
            result.setText(String.valueOf(difference));
        }
        else if (v.getId() == R.id.ProductNumber) {
            Log.i("CalculatorActivity", "Product button is clicked");
            if (checkingValidInput()) {
                return;
            }

            number1 = findViewById(R.id.inputSoA);
            number2 = findViewById(R.id.inputSoB);
            result = findViewById(R.id.resultValue);

            int number1Int = Integer.parseInt(number1.getText().toString());
            int number2Int = Integer.parseInt(number2.getText().toString());

            int product = number1Int * number2Int;
            result.setText(String.valueOf(product));
        }
        else if (v.getId() == R.id.QuotientNumber) {
            Log.i("CalculatorActivity", "Quotient button is clicked");
            if (checkingValidInput()) {
                return;
            }

            number1 = findViewById(R.id.inputSoA);
            number2 = findViewById(R.id.inputSoB);
            result = findViewById(R.id.resultValue);

            int number1Int = Integer.parseInt(number1.getText().toString());
            int number2Int = Integer.parseInt(number2.getText().toString());

            if (number2Int == 0) {
                Toast.makeText(this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }

            int quotient = number1Int / number2Int;
            result.setText(String.valueOf(quotient));
        }
        else if (v.getId() == R.id.DivisorNumber) {
            Log.i("CalculatorActivity", "Divisor button is clicked");
            if (checkingValidInput()) {
                return;
            }

            number1 = findViewById(R.id.inputSoA);
            number2 = findViewById(R.id.inputSoB);
            result = findViewById(R.id.resultValue);

            int number1Int = Integer.parseInt(number1.getText().toString());
            int number2Int = Integer.parseInt(number2.getText().toString());

            if (number2Int == 0) {
                Toast.makeText(this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }

            int divisor = number1Int % number2Int;
            result.setText(String.valueOf(divisor));
        }
    }
    private class DivisorNumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//           greatest common divisor
            Log.i("CalculatorActivity", "Divisor button is clicked");
            if (checkingValidInput()) {
                return;
            }

            number1 = findViewById(R.id.inputSoA);
            number2 = findViewById(R.id.inputSoB);
            result = findViewById(R.id.resultValue);

            int number1Int = Integer.parseInt(number1.getText().toString());
            int number2Int = Integer.parseInt(number2.getText().toString());

            if (number2Int == 0) {
                Toast.makeText(CalculatorActivity.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }

            int divisor = number1Int % number2Int;
            result.setText(String.valueOf(divisor));
        }
    }
}


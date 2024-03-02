package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class TempConvertActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText FahrenheitInput;
    private EditText CelsiusInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_convert_layout);

        Button btnCel = findViewById(R.id.btnCel);
        Button btnFar = findViewById(R.id.btnFar);
        Button btnClear = findViewById(R.id.btnClear);

        btnCel.setOnClickListener(this);
        btnFar.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        Log.i("TempConvertActivity", "TempConvertActivity is created");
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnFar) {
            FahrenheitInput = findViewById(R.id.FahrenheitInput);
            CelsiusInput = findViewById(R.id.CelsiusInput);
            String fahrenheit = FahrenheitInput.getText().toString();
            if (fahrenheit.isEmpty()) {
                CelsiusInput.setText("");
            } else {
                double f = Double.parseDouble(fahrenheit);
                double c = (f - 32) * 5 / 9;
                CelsiusInput.setText(String.valueOf(c));
            }
        } else if (view.getId() == R.id.btnCel) {
            FahrenheitInput = findViewById(R.id.FahrenheitInput);
            CelsiusInput = findViewById(R.id.CelsiusInput);
            String celsius = CelsiusInput.getText().toString();
            if (celsius.isEmpty()) {
                FahrenheitInput.setText("");
            } else {
                double c = Double.parseDouble(celsius);
                double f = c * 9 / 5 + 32;
                FahrenheitInput.setText(String.valueOf(f));
            }
        } else if (view.getId() == R.id.btnClear) {
            FahrenheitInput = findViewById(R.id.FahrenheitInput);
            CelsiusInput = findViewById(R.id.CelsiusInput);
            FahrenheitInput.setText("");
            CelsiusInput.setText("");
        }
    }
}
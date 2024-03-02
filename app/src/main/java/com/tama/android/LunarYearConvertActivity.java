package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LunarYearConvertActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunar_year_convert_layout);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
//            checking the input
            EditText year = findViewById(R.id.yearInput);
            EditText lunarYear = findViewById(R.id.lunarYearInput);

            String input = year.getText().toString();
            String lunarInput = lunarYear.getText().toString();
            if (input.isEmpty()) {
                if (!lunarInput.isEmpty()) {
                    String solar = SolarYearConverter(lunarInput);
                    if (!solar.equals("Invalid year")) {
                        year.setText(solar);
                        return;
                    }
                } else {
                    Toast.makeText(this, "Please enter a year", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            int yearParse = Integer.parseInt(input);
            if (yearParse < 1900 || yearParse > 2100) {
                Toast.makeText(this, "Please enter a year between 1900 and 2100", Toast.LENGTH_SHORT).show();
                return;
            }
//            converting the year
            String lunar = LunarYearConverter(yearParse);

//            showing the result
            lunarYear.setText(lunar);
        }
    }

    public String LunarYearConverter(int year) {
        if (year < 1900 || year > 2100) {
            return "Invalid year";
        }
        String[] Can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        String[] Chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

        return Can[year % 10] + " " + Chi[year % 12];
    }

    public String SolarYearConverter(String lunarYear) {
        String[] Can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        String[] Chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

        String[] lunar = lunarYear.split(" ");
        int canIndex = -1;
        int chiIndex = -1;
        for (int i = 0; i < Can.length; i++) {
            if (Can[i].equals(lunar[0])) {
                canIndex = i;
                break;
            }
        }
        for (int i = 0; i < Chi.length; i++) {
            if (Chi[i].equals(lunar[1])) {
                chiIndex = i;
                break;
            }
        }
        if (canIndex == -1 || chiIndex == -1) {
            return "Invalid year";
        }
        int year = canIndex + 1900;
        if (year % 10 != chiIndex) {
            return "Invalid year";
        }
        return Integer.toString(year);
    }
}
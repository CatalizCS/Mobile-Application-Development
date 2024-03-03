package com.tama.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
* LoginActivity đang sử dụng dạng OnclickListener interface để xử lý sự kiện click của button login và register
*/
public class LoginActivity extends Activity implements View.OnClickListener {
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_linear_layout);

        findViewById(R.id.btn_login_submit).setOnClickListener(this);
        findViewById(R.id.btn_login_signup).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_login_submit) {
            EditText username = (EditText) findViewById(R.id.username);
            EditText password = (EditText) findViewById(R.id.password);

            String usernameStr = username.getText().toString();
            String passwordStr = password.getText().toString();

            if (usernameStr.equals("admin") && passwordStr.equals("admin")) {
                Toast.makeText(this, "You clicked Login button that proof your username and password corrected!!", Toast.LENGTH_SHORT).show();
                startActivity(new android.content.Intent(this, UsersActivity.class));
            } else {
                Toast.makeText(this, "Username and password are incorrect or empty!!", Toast.LENGTH_SHORT).show();
            }

        }
        else if (view.getId() == R.id.btn_login_signup) {
            Toast.makeText(this, "You clicked Register button!!", Toast.LENGTH_SHORT).show();
            try {
                Toast.makeText(this, "timeout 3s before change to new activity", Toast.LENGTH_SHORT).show();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Start SignupActivity
            startActivity(new android.content.Intent(this, SignupActivity.class));
        }
    }

    public void TestAlertDialog(View view) {
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {
            public void onClick(android.content.DialogInterface dialog, int id) {
                LoginActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new android.content.DialogInterface.OnClickListener() {
            public void onClick(android.content.DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    public void TestCalculator(View view) {
        startActivity(new android.content.Intent(this, CalculatorActivity.class));
    }

    public void TestTempConvert(View view) {
        startActivity(new android.content.Intent(this, TempConvertActivity.class));
    }

    public void TestLoginAlert(View view) {
        startActivity(new android.content.Intent(this, LoginAlertActivity.class));
    }

    public void TestLunarYearConvert(View view) {
        startActivity(new android.content.Intent(this, LunarYearConvertActivity.class));
    }

    public void TestInfomationAdd(View view) {
        startActivity(new android.content.Intent(this, InfomationAddActivity.class));
    }

    public void TestListView(View view) {
        startActivity(new android.content.Intent(this, ListViewActivity.class));
    }
}

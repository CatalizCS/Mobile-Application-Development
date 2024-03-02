package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class LoginAlertActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_alert_layout);

        findViewById(R.id.btnexit).setOnClickListener(this);

//        get checkedbox
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(LoginAlertActivity.this, "chào mừng bạn đăng nhập hệ thống, bạn đã lưu thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginAlertActivity.this, "chào mừng bạn đăng nhập hệ thống, bạn không lưu thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnexit) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {
                public void onClick(android.content.DialogInterface dialog, int id) {
                    LoginAlertActivity.this.finish();
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
    }
}
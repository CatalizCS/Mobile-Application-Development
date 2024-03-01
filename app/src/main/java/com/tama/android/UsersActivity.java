package com.tama.android;

import android.app.Activity;
import android.widget.Toast;

public class UsersActivity extends Activity {
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_table_layout);

        findViewById(R.id.btn_exit).setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
//              Toast makeText+show
                Toast.makeText(UsersActivity.this, "You clicked Exit button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

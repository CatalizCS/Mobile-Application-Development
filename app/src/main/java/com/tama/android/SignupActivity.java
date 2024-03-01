package com.tama.android;

import android.app.Activity;
import android.view.View;

public class SignupActivity extends Activity {
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_relative_layout);

//        setOnclickListener
//        findViewById(R.id.btn_signup_submit).setOnClickListener(SignupActivity.this::SignupSubmit);

//      inline anonymous class initialization
        findViewById(R.id.btn_signup_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupSubmit(v);
            }
        });
    }

    public void SignupSubmit(android.view.View view) {
        android.widget.Toast.makeText(this, "You clicked Register button", android.widget.Toast.LENGTH_SHORT).show();
        ReturnLoginActivity(view);
    }


    public void ReturnLoginActivity(android.view.View view) {
        startActivity(new android.content.Intent(this, LoginActivity.class));
    }
}

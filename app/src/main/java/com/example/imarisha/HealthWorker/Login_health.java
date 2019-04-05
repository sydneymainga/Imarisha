package com.example.imarisha.HealthWorker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.imarisha.R;

/**
 * A login screen that offers login via email/password.
 */
public class Login_health extends AppCompatActivity implements OnClickListener {
    private ProgressBar login_progress;
    private EditText email;
    private EditText password;
    private AppCompatButton email_sign_in_button;
    private ScrollView login_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_health);
        initView();
    }

    private void initView() {
        login_progress = (ProgressBar) findViewById(R.id.login_progress);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        email_sign_in_button =  findViewById(R.id.email_sign_in_button);

        email_sign_in_button.setOnClickListener(this);
        login_form = (ScrollView) findViewById(R.id.login_form);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String emailString = email.getText().toString().trim();
        if (TextUtils.isEmpty(emailString)) {
           email.setError("The Email is required");
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
           password.setError("The Password is required try again");
            return;
        }

        //Show progress bar

        login_progress.setVisibility(View.VISIBLE);

        login_form.setVisibility(View.GONE);
        // TODO validate success, do something

        //Emulate login Process
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Login_health.this,ReportCase.class));
            }
        }, 500);


    }
}


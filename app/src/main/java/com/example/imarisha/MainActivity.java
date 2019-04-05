package com.example.imarisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imarisha.Data.UserType;
import com.example.imarisha.HealthWorker.Login_health;
import com.example.imarisha.HealthWorker.ReportCase;
import com.mrgames13.jimdo.splashscreen.App.SplashScreenBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashScreenBuilder.getInstance(this)
                .setVideo(R.raw.splash_animation)
                .setImage(R.drawable.app_icon)
                .skipImage(true)
                .show();

        ImageView imageview1 = findViewById(R.id.button_leader);
        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start the leader activity
                Intent i = new Intent(getApplicationContext(), Login_health.class);
                startActivity(i);

            }
        });
        ImageView button_worker = findViewById(R.id.button_health);
        button_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start the Health worker activity
                Intent i = new Intent(getApplicationContext(), Login_leader.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SplashScreenBuilder.SPLASH_SCREEN_FINISHED) {
            if(resultCode == RESULT_OK) {

            } else if(resultCode == RESULT_CANCELED) {

            }
            UserType userType = new UserType(MainActivity.this);
            if(userType.isNurse()){
                Intent i = new Intent(getApplicationContext(), ReportCase.class);
                startActivity(i);
                //No coming back here in future
                finish();
            }

        }

    }
}

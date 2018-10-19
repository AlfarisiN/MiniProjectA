package com.android.mobilemarcom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.utility.Constanta;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {
    private Context context = this;
    TextView textVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textVersion = (TextView) findViewById(R.id.textVersion);
        getAppVersion();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, Constanta.SPLASH_DELAY_TIME);
    }

    public void getAppVersion(){
        String version = Constanta.WELCOME_APP_NAME+" "+ getResources().getString(R.string.app_name);
        textVersion.setText(version);

        Toast.makeText(context,version,Toast.LENGTH_LONG).show();
    }
}

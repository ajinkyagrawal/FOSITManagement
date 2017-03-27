package fos.com.atos.fositmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import fos.com.atos.fositmanagement.R;


/**
 * Created by undav on 26-01-2017.
 */

public class SplashActivity extends Activity
{

    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        }, SPLASH_TIME_OUT);
    }

}
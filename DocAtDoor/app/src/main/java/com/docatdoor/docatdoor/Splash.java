package com.docatdoor.docatdoor;

import android.app.Activity;
import android.content.Intent;
import android.os.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Splash extends Activity
{
    private static  int splash_timer=2500;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(Splash.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        },splash_timer);
    }
}

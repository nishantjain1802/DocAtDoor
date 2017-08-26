package com.docatdoor.docatdoor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile_frag extends Activity
{
    EditText e1,e2,e3,e4,e5,e6;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_frag);

        String value = getIntent().getExtras().getString("key");
        String[] starr = value.split(",");
        e1 = (EditText) findViewById(R.id.pe1);
        e2 = (EditText) findViewById(R.id.pe2);
        e3 = (EditText) findViewById(R.id.pe3);
        e4 = (EditText) findViewById(R.id.pe4);
        e5 = (EditText) findViewById(R.id.pe5);
        e6 = (EditText) findViewById(R.id.pe6);
        b1 = (Button) findViewById(R.id.pb);

        e1.setText(starr[1]);
        e2.setText(starr[2]);
        e3.setText(starr[3]);
        e4.setText(starr[6]);
        e5.setText(starr[21]);
        e6.setText(starr[33]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profile_frag.this, AfterLogin.class);
                startActivity(i);
            }
        });
    }
        @Override
        public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }
                }).setNegativeButton("No", null).show();


    }

}

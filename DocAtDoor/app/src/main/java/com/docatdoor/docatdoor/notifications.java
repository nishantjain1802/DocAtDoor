package com.docatdoor.docatdoor;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class notifications extends Activity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        t1=(TextView)findViewById(R.id.textViewNoti);

        Intent in = getIntent();
        t1.setText("* "+in.getStringExtra("name"));
    }

}

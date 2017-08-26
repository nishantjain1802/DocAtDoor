package com.docatdoor.docatdoor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class finding_doctor extends Activity implements View.OnClickListener {
    Button b1;
    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_doctor);
        Firebase.setAndroidContext(this);

        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
        et3 = (EditText) findViewById(R.id.e3);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                // String E=loginemail.getText().toString();
                Firebase ref1 = new Firebase("https://docatdoor-e59db.firebaseio.com/hospitalName");

                //if(E.isEmpty()){ loginemail.setError("Enter Registered Email Id");  }

                //else{

                //loginemail.setError(null)
                ref1.child("aura/DoctorsAvailable").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.getValue() != null) {
                            String s = snapshot.getValue().toString();

                            //Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
                            if (s.equals("yes")) {
                                Firebase ref2 = new Firebase("https://docatdoor-e59db.firebaseio.com/hospitalName");
                                ref2.child("aura").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String s2 = dataSnapshot.getValue().toString();
                                        String[] s3=new String[3];
                                        s3=s2.split(",");
                                        Toast.makeText(getBaseContext(),s3[0]+"::"+s3[1]+"::"+s3[2], Toast.LENGTH_LONG).show();

                                        et1.setText(s3[0]);
                                        et2.setText(s3[1]);
                                        et3.setText(s3[2]);

                                        Intent i = new Intent(finding_doctor.this, notifications.class);
                                        PendingIntent pending = PendingIntent.getActivity(getBaseContext(), 0, i, 0);
                                        Notification.Builder n = new Notification.Builder(getBaseContext());

                                        n.setStyle(new Notification.BigTextStyle().bigText("Notifications"));
                                        n.setContentTitle("message from DocAtDoor");
                                        n.setContentText(s2);
                                        n.setSmallIcon(R.drawable.findingdoc);

                                        Notification notif = n.build();
                                        notif.flags = notif.flags | Notification.FLAG_AUTO_CANCEL;
                                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                        nm.notify(1, notif);

                                    }

                                    @Override
                                    public void onCancelled(FirebaseError firebaseError) {

                                    }
                                });

                            } else {

                                Firebase ref14 = new Firebase("https://docatdoor-e59db.firebaseio.com/hospitalName");

                                //if(E.isEmpty()){ loginemail.setError("Enter Registered Email Id");  }

                                //else{

                                //loginemail.setError(null)
                                ref14.child("sms/DoctorsAvailable").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String s = dataSnapshot.getValue().toString();

                                        if (s.equals("yes")) {
                                            Firebase ref2 = new Firebase("https://docatdoor-e59db.firebaseio.com/hospitalName");
                                            ref2.child("sms").addListenerForSingleValueEvent(new ValueEventListener() {


                                                @Override

                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    String s2 = dataSnapshot.getValue().toString();
                                                    String[] s3=new String[3];
                                                    s3=s2.split(",");
                                                    Toast.makeText(getBaseContext(),s3[0]+"::"+s3[1]+"::"+s3[2], Toast.LENGTH_LONG).show();

                                                    et1.setText(s3[0]);
                                                    et2.setText(s3[1]);
                                                    et3.setText(s3[2]);



                                                    Intent i = new Intent(finding_doctor.this, notifications.class);
                                                    PendingIntent pending = PendingIntent.getActivity(getBaseContext(), 0, i, 0);
                                                    Notification.Builder n = new Notification.Builder(getBaseContext());

                                                    n.setStyle(new Notification.BigTextStyle().bigText("Notifications"));
                                                    n.setContentTitle("message from DocAtDoor");
                                                    n.setContentText(s2);
                                                    n.setSmallIcon(R.drawable.findingdoc);

                                                    Notification notif = n.build();
                                                    notif.flags = notif.flags | Notification.FLAG_AUTO_CANCEL;
                                                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                                    nm.notify(1, notif);

                                                }

                                                @Override
                                                public void onCancelled(FirebaseError firebaseError) {

                                                }
                                            });

                                        } else {
                                            Firebase ref2 = new Firebase("https://docatdoor-e59db.firebaseio.com/hospitalName");
                                            ref2.child("fortis").addListenerForSingleValueEvent(new ValueEventListener() {


                                                @Override

                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    String s2 = dataSnapshot.getValue().toString();
                                                    String[] s3=new String[3];
                                                    s3=s2.split(",");
                                                    Toast.makeText(getBaseContext(),s3[0]+"::"+s3[1]+"::"+s3[2], Toast.LENGTH_LONG).show();

                                                    et1.setText(s3[0]);
                                                    et2.setText(s3[1]);
                                                    et3.setText(s3[2]);
                                                    Intent i = new Intent(finding_doctor.this, notifications.class);
                                                    PendingIntent pending = PendingIntent.getActivity(getBaseContext(), 0, i, 0);
                                                    Notification.Builder n = new Notification.Builder(getBaseContext());

                                                    n.setStyle(new Notification.BigTextStyle().bigText("Notifications"));
                                                    n.setContentTitle("message from DocAtDoor");
                                                    n.setContentText(s3[0]+"::"+s3[1]+"::"+s3[2]);
                                                    n.setSmallIcon(R.drawable.findingdoc);

                                                    Notification notif = n.build();
                                                    notif.flags = notif.flags | Notification.FLAG_AUTO_CANCEL;
                                                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                                    nm.notify(1, notif);

                                                    Intent in = new Intent(getBaseContext(), notifications.class);
                                                    in.putExtra("name", s2);
                                                    startActivity(in);


                                                }

                                                @Override
                                                public void onCancelled(FirebaseError firebaseError) {

                                                }
                                            });
                                        }
                                    }
                                    @Override
                                    public void onCancelled(FirebaseError firebaseError) {

                                    }
                                });
                            }
                        }




                        else
                        {
                            //user does not exist, do something else
                            Toast.makeText(getBaseContext(), "Sorry..!! No hospital is available near you", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError arg) {
                    }
                });

        }
    }
    @Override
    public void onBackPressed()
    {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to go back to previous page?")
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





 /*   //on back button press
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

}*/
package com.docatdoor.docatdoor;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LoginActivity extends Activity implements OnClickListener {
    public EditText e1;
    public Button b1;
    public String s1 = null;
    String url = "https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/hofAndMember/ForApp/" + s1 + "?client_id=ad7288a4-7764-436d-a727-783a977f1fe1";
    protected String my_app_id;
    protected String my_api_key;
    protected String my_host;
    protected Context my_context;


    public void setAuthentication(Context ctx, String app_id, String api_key)
    {

        my_context = ctx;
        my_app_id = app_id;
        my_api_key = api_key;
        my_host = "http://api.kairos.com/";

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = (EditText) findViewById(R.id.loginBox);
        b1 = (Button) findViewById(R.id.ButtonLogin);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ButtonLogin) {
            s1=e1.getText().toString();
            url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/hofAndMember/ForApp/" + s1 + "?client_id=ad7288a4-7764-436d-a727-783a977f1fe1";
             try {
                Requestprocess(s1);
            } catch (JSONException e) {
            } catch (Exception e) {
            }
        }
    }


    public void Requestprocess(String st) throws JSONException, UnsupportedEncodingException {
        AsyncHttpClient client = new AsyncHttpClient();
        AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onStart()
            {
              //    Toast.makeText(getBaseContext(), "start", Toast.LENGTH_LONG).show();   // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response)
            {

                String responseString = new String(response);
                //Toast.makeText(getBaseContext(),responseString,Toast.LENGTH_SHORT).show();
                if(responseString.length()>=100)
                {
                    Toast.makeText(getBaseContext(), "success", Toast.LENGTH_LONG).show();
                    String responseCode = String.valueOf(statusCode);
                    String respnse = String.valueOf(response);
                    //String json = EntityUtils.toString(response.getEntity());
                    requesting(responseString);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"ID not Found..!!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error)
            {
                Toast.makeText(getBaseContext(), "fail", Toast.LENGTH_LONG).show();
            }

        };

    /*
    my_context = ctx;
    my_app_id = app_id;
    my_api_key = api_key;
    my_host = "http://api.kairos.com/";
    */
        RequestParams requestParams=new RequestParams();
        JSONObject jsonParams = new JSONObject();
        /*jsonParams.put("bhamshah_id","WDYYYGG");
        jsonParams.put("app_key","ad7288a4-7764-436d-a727-783a977f1fe1");
        StringEntity entity = new StringEntity(jsonParams.toString());
        */
        requestParams.put("bhamshah_id","WDYYYGG");
        requestParams.put("app_key","ad7288a4-7764-436d-a727-783a977f1fe1");
        //client.addHeader("bhamshah_id","WDYYYGG");
        //client.addHeader("app_key","ad7288a4-7764-436d-a727-783a977f1fe1");
       // Toast.makeText(getBaseContext(),"API hit",Toast.LENGTH_SHORT);
        client.get(my_context,url,requestParams,responseHandler);
      //  Toast.makeText(getBaseContext(),"----"+url,Toast.LENGTH_SHORT).show();
    }


    public void requesting(String str)
    {
        Intent i=new Intent(LoginActivity.this,profile_frag.class);
        i.putExtra("key",str);
        startActivity(i);
    }
}


package com.hitachi_tstv.samsen.tunyaporn.proofpfdelivery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passEditText;
    private TextView errorTextView;
    private String userString, passString, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyConstant myConstant = new MyConstant();

        url = myConstant.getUrlJSONUser();

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.txtUser);
        passEditText = (EditText) findViewById(R.id.txtPass);
        errorTextView = (TextView) findViewById(R.id.txtError);


    }

    private class SyncUser extends AsyncTask<Void, Void, String> {

        //Explicit
        private ProgressDialog progressDialog;
        private String userString, passString, urlString;
        private Boolean aBoolean;
        private Context context;

        public SyncUser(String userString, String passString, String urlString, Context context) {
            this.userString = userString;
            this.passString = passString;
            this.urlString = urlString;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            Log.d("Tag", "JSON ==> " + s);

            try {
                JSONObject obj = new JSONObject(s);
                aBoolean = obj.getBoolean("flag");

                Log.d("Tag", "Boolean ==> " + aBoolean);

                if (aBoolean) {
                    Intent intent = new Intent(MainActivity.this, JobListActivity.class);
                    intent.putExtra("username", userString);
                    Toast.makeText(context, "Login Successful!!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }
                else {
                    errorTextView.setText("Invalid Username or Password!!!");
                    //Toast.makeText(context, "User/Pass is wrong", Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                Log.d("Tag", "e onPost ==> " + e);
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder().add("username",userString).add("password",passString).add("isAdd","true").build();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlString).post(requestBody).build();
                Response response = okHttpClient.newCall(request).execute();

                return response.body().string();
            } catch (IOException e) {
                Log.d("Tag", "e doInBackground ==> " + e);
                e.printStackTrace();
            }
            return null;
        }
    }


    public void clickSignIn(View view) {

        //Set Value to Variable
        userString = userEditText.getText().toString();
        passString = passEditText.getText().toString();

        Log.d("Tag", "User ==> " + userString + " :: Pass ==> " + passString);
        SyncUser syncUser = new SyncUser(userString,passString,url,MainActivity.this);
        syncUser.execute();
    }
}

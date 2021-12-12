package com.example.saramobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class signup extends AppCompatActivity {
    EditText user,  phone,email,age,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.num);
        email = (EditText) findViewById(R.id.email);
        age = (EditText) findViewById(R.id.age);
        password = (EditText) findViewById(R.id.password);
    }



    public void qoute(View view) {

        Signingup task = new Signingup();
        String link = "http://192.168.0.106/sara_project/signup1.php?username="
                + user.getText().toString() + "&phone=" + Integer.parseInt(phone.getText().toString()) + "&email="
                + email.getText().toString() + "&age="
                + Integer.parseInt(age.getText().toString()) + "&password=" + password.getText().toString();

        task.execute(link);

    }




    public class Signingup extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int data = reader.read();
                while (data != -1) {

                    result = result + reader.readLine();
                    data = reader.read();
                }
                //Toast.makeText(MainActivity.this,"reached 1", Toast.LENGTH_LONG).show();

                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                //JSONObject json = new JSONObject(s);
                JSONArray jsonarray = new JSONArray("[{"+s+"]");
//                JSONArray arr1 = new JSONArray("ERROR");

                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String access = jsonobject.getString("result");

                    if (access.equalsIgnoreCase("inserted")) {
                        Intent intent = new Intent(signup.this,QuoteActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(signup.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                    }
                }

            } catch(JSONException jsonException){
                jsonException.printStackTrace();
            }
        }

    }
}
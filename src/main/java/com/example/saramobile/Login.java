package com.example.saramobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {
    EditText u, p;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        u = (EditText) findViewById(R.id.editTextTextPersonName6);
        p = (EditText) findViewById(R.id.editTextTextPersonName7);
        b = (Button) findViewById(R.id.button);

    }

            public void qoute(View view) {

                Loginmethod task = new Loginmethod();
                String link = "http://192.168.0.106/sara_project/users.php?username="+u.getText().toString()+"&password="+p.getText().toString();
                task.execute(link);

            }

    public class Loginmethod extends AsyncTask<String, Void, String> {

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
                JSONObject obj = new JSONObject(s);

                JSONArray jArray = obj.getJSONArray("th");

                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                        String log=json_data.getString("login");


                    if (log.equalsIgnoreCase(u.getText().toString())) {
                        Intent intent = new Intent(Login.this, QuoteActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "denied", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
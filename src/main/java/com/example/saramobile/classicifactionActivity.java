package com.example.saramobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class classicifactionActivity extends AppCompatActivity {
    TextView t;

    Button dep,sui,hope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classicifaction);
        t=(TextView) findViewById(R.id.textView15);
        dep=(Button)findViewById(R.id.dep);
        sui=(Button)findViewById(R.id.sui);
        hope=(Button)findViewById(R.id.hope);



    }
    public void depression(View v){
        String type="depression";
        Qoutegenerator(type);
    }
    public void suicide(View v){
        String type="suicide";
        Qoutegenerator(type);
    }
    public void hope(View v){
        String type="hope";
        Qoutegenerator(type);
    }

    public void Qoutegenerator(String type){

        Qoute task = new Qoute();
        String link = "http://192.168.0.106/sara_project/qoutes.php?type="+type;
                ;
        task.execute(link);

    }
    public class Qoute extends AsyncTask<String, Void, String> {

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
                    String q=json_data.getString("qoute");
                    t.setText(q);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
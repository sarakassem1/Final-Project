package com.example.saramobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Psych extends AppCompatActivity {
TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psych);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        getpsych task = new getpsych();
        String link = "http://192.168.0.106/sara_project/psych.php";
        task.execute(link);
    }


    public class getpsych extends AsyncTask<String, Void, String> {

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
                JSONArray jsonarray = new JSONArray("["+s+"]");

                for(int i=0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String name = jsonobject.getString("name");
                    String email = jsonobject.getString("email");
                    String available_time = jsonobject.getString("available_time");
                    String phone = jsonobject.getString("phone");

                    String info=name+"\n"+email+"\ntime available:"+available_time+"\n"+phone;
                    if(i==0){
                        t1.setText(info);
                    }
                    if(i==1){
                        t2.setText(info);

                    }
                    else{
                        t3.setText(info);

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
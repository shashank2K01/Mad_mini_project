package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class apifetch extends AppCompatActivity {
    JSONArray res;
    int counter =0;
    JSONObject question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apifetch);
        Bundle b = getIntent().getExtras();
        String cat = b.getString("cat");

        String dif = b.getString("dif");
        TextView heading = findViewById(R.id.heading);
        TextView questionplace = findViewById(R.id.question);
        heading.setText("Catagory: "+cat);


        String category="";

        String difficulty="";


        RequestQueue requestQueue;
        if(cat.equals("General Knowledge") ){
            category = "&category=9";
        }
        else if(cat.equals("Computer Science") ){
            category ="&category=18";
        }

        if(dif.equals("Easy")){
            difficulty = "&difficulty=easy";
        }

        else if(dif.equals("Medium")) {
            difficulty = "&difficulty=medium";
        }

        else
            difficulty ="&difficulty=hard";


        String url = "https://opentdb.com/api.php?amount=10&type=boolean";
        if(category.length()>0)
            url =url + category;
        if(difficulty.length()>0)
            url = url +difficulty;
        requestQueue = Volley.newRequestQueue(this);





        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                res = response.optJSONArray("results");

                try {
                     question = res.getJSONObject(0);

                    String Question = question.optString("question").toString();
                    Question =Question.replace("&quot;","\"\"");
                    Question =Question.replace("&#039;","'");
                    questionplace.setText(Question);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //Toast.makeText(MainActivity.this, res.toString(), Toast.LENGTH_SHORT).show();
                //check.append(res.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "something went wrong");
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
    public void True_clicked(View v) throws JSONException {
        String answer = question.optString("correct_answer").toString();
        if(answer.equals("True")){
            TextView questionplace = findViewById(R.id.question);
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
            counter++;
            if(counter==10){
                //Intent j = new Intent(this,MainActivity.class);
                //Toast.makeText(this, "you win", Toast.LENGTH_SHORT).show();
                //startActivity(j);
                Intent j = new Intent(this,final_Activity.class);
                Bundle b = new Bundle();
                //String message="You win. Your score is ";//+String.valueOf(counter);
                b.putString("txt", "You won");
                j.putExtras(b);
                startActivity(j);
            }else {
                question = res.getJSONObject(counter);
                String Question = question.optString("question").toString();
                Question = Question.replace("&quot;", "\"\"");
                Question = Question.replace("&#039;", "'");
                questionplace.setText(Question);
            }
            
        }
        else{
            //Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
            Intent j = new Intent(this,final_Activity.class);
            Bundle b = new Bundle();
            b.putString("txt","You lose. Your Score is "+String.valueOf(counter));
            //b.putString("finid","Better luck next time. Your score is "+String.valueOf(counter));
            //Toast.makeText(this, "you lose, You're score = "+counter, Toast.LENGTH_SHORT).show();
            j.putExtras(b);
            startActivity(j);
        }
    }

    public void False_clicked(View v) throws JSONException {
        String answer = question.optString("correct_answer").toString();
        if(answer.equals("False")){
            TextView questionplace = findViewById(R.id.question);
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
            counter++;
            if(counter==10){
               // Intent j = new Intent(this,MainActivity.class);
                //Toast.makeText(this, "you win", Toast.LENGTH_SHORT).show();
                //startActivity(j);
                Intent j = new Intent(this,final_Activity.class);
                Bundle b = new Bundle();
                //String message="You win. Your score is ";//+String.valueOf(counter);
                b.putString("txt", "You won");
                j.putExtras(b);
                startActivity(j);
            }else {
                question = res.getJSONObject(counter);
                String Question = question.optString("question").toString();
                Question = Question.replace("&quot;", "\"\"");
                Question = Question.replace("&#039;", "'");
                questionplace.setText(Question);
            }

        }
        else{
            /*Toast.makeText(this, "you lose, You're score = "+counter, Toast.LENGTH_SHORT).show();
            Intent j = new Intent(this,MainActivity.class);

            startActivity(j);*/
            Intent j = new Intent(this,final_Activity.class);
            Bundle b = new Bundle();
            b.putString("txt","You lose. Your Score is "+String.valueOf(counter));
            //b.putString("finid","Better luck next time. Your score is "+String.valueOf(counter));
            //Toast.makeText(this, "you lose, You're score = "+counter, Toast.LENGTH_SHORT).show();
            j.putExtras(b);
            startActivity(j);
        }

    }







}
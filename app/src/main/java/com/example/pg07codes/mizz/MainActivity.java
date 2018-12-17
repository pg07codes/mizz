package com.example.pg07codes.mizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tweet;
    Button post;
    ListView tweets;
    ArrayList<String> tweetArray;
    ArrayAdapter<String> tweetAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaring vars here
        tweet=findViewById(R.id.tweet);
        post=findViewById(R.id.post);
        tweets=findViewById(R.id.tweets);
        tweetArray = new ArrayList<String>();
        tweetAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tweetArray);

        tweets.setAdapter(tweetAdapter);
    }

    public void addTweet(View v){
        String x=tweet.getText().toString();
        add(x);
    }

    public void add(String t){
        tweetArray.add(t);
        tweetAdapter.notifyDataSetChanged();
    }
}

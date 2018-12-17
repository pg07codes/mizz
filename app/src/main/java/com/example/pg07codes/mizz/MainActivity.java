package com.example.pg07codes.mizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        tweets.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {
                tweetArray.remove(tweets.getItemAtPosition(index).toString());
                Toast.makeText(MainActivity.this,"ITEM DELETED", Toast.LENGTH_SHORT).show();
                tweetAdapter.notifyDataSetChanged();
                return true;
            }
        });

        tweets.setLongClickable(true);
    }

    public void addTweet(View v){
        String x=tweet.getText().toString();
        if(x.equals("")){
            Toast.makeText(this, "empty tweet",Toast.LENGTH_SHORT).show();
        }else{
            add(x);
            tweet.setText("");
        }

    }

    public void add(String t){
        tweetArray.add(t);
        tweetAdapter.notifyDataSetChanged();
    }


}

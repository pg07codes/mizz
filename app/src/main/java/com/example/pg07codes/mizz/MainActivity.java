package com.example.pg07codes.mizz;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    SeekBar timerBar;
    TextView time;
    Button play;
    TextView timerText;
    LinearLayout playArea;
    TextView question;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        time=findViewById(R.id.time);
        timerBar=findViewById(R.id.timerBar);
        play=findViewById(R.id.play);
        timerText=findViewById(R.id.timer);
        playArea=findViewById(R.id.playArea);
        question=findViewById(R.id.question);

        // setting initial time
        time.setText(timerBar.getProgress()*20+"seconds");

        // initially playarea is not showing up
        playArea.setVisibility(View.INVISIBLE);


        timerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress == 0) {
                    play.setEnabled(false);
                } else {
                    play.setEnabled(true);
                }

                time.setText(Integer.toString(progress*20)+"seconds");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playArea.setVisibility(View.VISIBLE);
                //refreshPlayArea();
                setTimer(Integer.parseInt(time.getText().toString().replace("seconds","")));
                play.setEnabled(false);

            }
        });



    }


//    public void refreshPlayArea(){
//        question.setText(getQuestion());
//
//
//    }


    public void setTimer(int time){

        CountDownTimer timer=new CountDownTimer(time*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerText.setText("Seconds Left: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerText.setText("TIME IS UP !!!");
            }
        };

        timer.start();

    }


    public String getQuestion(){
        String ques;
        int x=(int)(Math.random()*200);
        int y=(int)(Math.random()*150);
        ques=x+"+"+y;
        return ques;
    }




}

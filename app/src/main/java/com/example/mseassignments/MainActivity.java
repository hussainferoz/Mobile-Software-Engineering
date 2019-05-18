package com.example.mseassignments;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private Button reset;
    private TextView watch;
    public boolean isRunning = false;
    public int hours = 0;
    public  int minutes = 0;
    public int seconds = 0;
    //public int milliseconds = 0;
    Handler handler;

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            seconds++;

            if (seconds == 60){
                minutes++;
                seconds = 0;

                if (minutes == 60){
                    hours++;
                    minutes = 0;
                }
            }

            watch.setText("" + String.format("%02d", hours) + ":"
                    + String.format("%02d", minutes) + ":"
                    + String.format("%02d", seconds));

            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.btnStart);
        stop = (Button)findViewById(R.id.btnStop);
        reset = (Button)findViewById(R.id.btnReset);
        watch = (TextView)findViewById(R.id.txtWatch);
        handler = new Handler();



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Start Button", Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable, 1000);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Stop Button", Toast.LENGTH_LONG).show();
                handler.removeCallbacks(runnable);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reset Button", Toast.LENGTH_LONG).show();
                handler.removeCallbacks(runnable);
                hours = 0;
                minutes = 0;
                seconds = 0;
                //milliseconds = 0;
                watch.setText("00:00:00");
                isRunning = false;

            }
        });
    }
}

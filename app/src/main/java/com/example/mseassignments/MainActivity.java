package com.example.mseassignments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Button secondActivity;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String humidity;
    private String pressure;
    private String windSpeed;
    private String windDirection;
    private String weather = "Clear";
    private String minTemp;
    private String maxTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondActivity = (Button) findViewById(R.id.weatherActivity);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humidity = "60";
                pressure = "971";
                windSpeed = "53";
                windDirection = "SE";
                minTemp = "15";
                maxTemp = "25";

                Intent weatherIntent = new Intent(MainActivity.this, SecondActivity.class);

                weatherIntent.putExtra("humidity", humidity);
                weatherIntent.putExtra("pressure", pressure);
                weatherIntent.putExtra("windSpeed", windSpeed);
                weatherIntent.putExtra("windDirection", windDirection);
                weatherIntent.putExtra("weather", weather);
                weatherIntent.putExtra("minTemp", minTemp);
                weatherIntent.putExtra("maxTemp", maxTemp);

                startActivity(weatherIntent);
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) findViewById(checkedId);

                switch(radioButton.getId()){
                    case R.id.radioClear: {
                        weather = "Clear";
                    }
                    break;

                    case R.id.radioClouds: {
                        weather = "Clouds";
                    }
                    break;

                    case R.id.radioLClouds: {
                        weather = "Light Clouds";
                    }
                    break;

                    case R.id.radioFog: {
                        weather = "Fog";
                    }
                    break;

                    case R.id.radioRain: {
                        weather = "Rain";
                    }
                    break;

                    case R.id.radioLRain: {
                        weather = "Light Rain";
                    }
                    break;

                    case R.id.radioSnow: {
                        weather = "Snow";
                    }
                    break;

                    case R.id.radiostorm: {
                        weather = "Storm";
                    }
                    break;
                }
            }
        });

    }
}
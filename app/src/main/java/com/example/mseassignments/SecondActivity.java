package com.example.mseassignments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView weather;
    private TextView minTemp;
    private TextView maxTemp;
    private ImageView image;
    private String condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        humidity = (TextView) findViewById(R.id.humidityValue);
        pressure = (TextView) findViewById(R.id.pressureValue);
        wind = (TextView) findViewById(R.id.windValue);
        weather = (TextView) findViewById(R.id.weather);
        minTemp = (TextView) findViewById(R.id.min);
        maxTemp = (TextView) findViewById(R.id.max);
        image = (ImageView) findViewById(R.id.image);

        humidity.setText(getIntent().getStringExtra("humidity") + " %");
        pressure.setText(getIntent().getStringExtra("pressure") + " hpa");
        wind.setText(getIntent().getStringExtra("windSpeed") + " km/h " + getIntent().getStringExtra("windDirection"));
        //weather.setText(getIntent().getStringExtra("weather"));
        minTemp.setText(getIntent().getStringExtra("minTemp") + "\u2103");
        maxTemp.setText(getIntent().getStringExtra("maxTemp") + "\u2103");

        condition = getIntent().getStringExtra("weather");
        weather.setText(condition);

        switch (condition){
            case "Clear":{
                image.setImageResource(R.mipmap.art_clear);
            }
            break;

            case "Clouds":{
                image.setImageResource(R.mipmap.art_clouds);
            }
            break;

            case "Light Clouds":{
                image.setImageResource(R.mipmap.art_light_clouds);
            }
            break;

            case "Fog":{
                image.setImageResource(R.mipmap.art_fog);
            }
            break;

            case "Rain":{
                image.setImageResource(R.mipmap.art_rain);
            }
            break;

            case "Light Rain":{
                image.setImageResource(R.mipmap.art_light_rain);
            }
            break;

            case "Snow":{
                image.setImageResource(R.mipmap.art_snow);
            }
            break;

            case "Storm":{
                image.setImageResource(R.mipmap.art_storm);
            }
            break;
        }
    }
}

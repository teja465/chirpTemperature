package com.example.chirptemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnSumbmit;
    TextView tvResults;
    public static int getTempInFarFromChirps(String chirpsCount){
        int count = Integer.parseInt(chirpsCount);
        return count+40;

    }
    public static int getTempInCelsiusFromChirps(String chirpsCount){

        int count = Integer.parseInt(chirpsCount);
        return (count/3)+4;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSumbmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        etNumber = findViewById(R.id.etNumber);
        btnSumbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String userInput = etNumber.getText().toString().trim();
             Log.d("UserInput",userInput);
             Log.d("UserInput.length",String.valueOf(userInput.length()));
             if (userInput.length()==0){
                 tvResults.setText("Please give an input greater than 0");
                 return;
             }
             int tempCelsius = getTempInCelsiusFromChirps(userInput);

             tvResults.setText("temperature is : "+tempCelsius+" deg Celsius or "
                     +getTempInFarFromChirps(userInput)+" fh");

            }
        });
    }
}
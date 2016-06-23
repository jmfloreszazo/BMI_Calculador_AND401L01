package com.jmfloreszazo.bmi_calculator_and401l01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float height;
    private float weight;
    private float BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bComputeBMI = (Button) findViewById(R.id.bComputeBMI);
        final EditText height_value = (EditText) findViewById(R.id.etHeight);
        final EditText weight_value = (EditText) findViewById(R.id.etWeight);
        final TextView result = (TextView) findViewById(R.id.tvResult);
        bComputeBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height_value.getText().length()>0 && weight_value.getText().length()>0){
                    weight = Float.parseFloat(weight_value.getText().toString());
                    height = Float.parseFloat(height_value.getText().toString());
                    BMI = calculateBMI(weight, height);
                    String result_text = "Your BMI: " + BMI + " (";
                    if (BMI<16) {
                        result_text += "Severely underweight";
                    } else if (BMI < 18.5) {
                        result_text += "Underweight";
                    } else if (BMI < 25) {
                        result_text += "Normal";
                    } else if (BMI < 30) {
                        result_text += "Overweight";
                    } else {
                        result_text += "Obese";
                    }
                    result_text += ")";
                    result.setText(result_text);
                }

            }
        });

    }
    private float calculateBMI(float weight, float height) {
        height = (height/100);
        return (float) (weight/(height*height));
    }
}


package com.example.bmicalculator;  // package declaration

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // Class variables - global scope, also called fields
    TextView res;
    RadioButton rMale, rFemale;
    EditText age, feet, inches, weight;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViews(); // will assign the class variables

        extracted();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void findViews() {
        res = findViewById(R.id.text_view_result);

        rMale = findViewById(R.id.radio_button_male);
        rFemale = findViewById(R.id.radio_button_female);

        age = findViewById(R.id.edit_text_age);
        feet = findViewById(R.id.edit_text_ft);
        inches = findViewById(R.id.edit_text_inches);
        weight = findViewById(R.id.edit_text_weight);

        calculate = findViewById(R.id.button_calculate);
    }

    private void extracted() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmi = calculateBMI();
                String age_text = age.getText().toString();
                int age = Integer.parseInt(age_text);
                if (age > 18)
                    displayBMI(bmi);
                else
                    displayGuidance(bmi);

                Toast.makeText(MainActivity.this, "this button works!!", Toast.LENGTH_LONG).show();
            }

        });
    }

    private void displayGuidance(double bmi) {
        if (rMale.isChecked()) {
            String res = "BMI: " + bmi + " As you are under 18, consult your GP for the healthy range for boys.";
        } else if (rFemale.isChecked()) {
            String res = "BMI: " + bmi + " As you are under 18, consult your GP for the healthy range for girls.";
        } else {
            String res = "BMI: " + bmi + " As you are under 18, consult your GP for healthy range for children.";
        }
    }

    private double calculateBMI() {

        String feet_text = feet.getText().toString();
        String inches_text = inches.getText().toString();
        String weight_text = weight.getText().toString();

        int inches = Integer.parseInt(feet_text);
        inches *= 12;
        inches += Integer.parseInt(inches_text);
        double height_m = inches * 0.0254;

        int weight = Integer.parseInt(weight_text);


        //  bmi = weight/ height in metres square
        return weight / (height_m * height_m);

    }

    private void displayBMI(double bmi) {
        DecimalFormat formatted_bmi = new DecimalFormat("0.00");
        String bmi_res = formatted_bmi.format(bmi);

        String comment;

        if (bmi < 18.5) {
            comment = "Underweight";
        } else if (bmi > 25) {
            comment = "Overweight";
        } else {
            comment = "Healthy";
        }

        String full_comment = "You are: " + comment + " BMI: " + bmi_res;
        res.setText(full_comment);
    }


}

package com.example.portfolioapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Project[] projects = {
                new Project("First App","Default 'hello world' App", R.drawable.first),
                new Project("Motivational Quote App","App that shares motivational quotes", R.drawable.quote),
                new Project("BMI Calculator","Working BMI Calulator with i/p and calculation", R.drawable.calculator),
                new Project("Kitty Mukbang","Mukbang menu with starters, mains and desserts", R.drawable.mukbang),
                new Project("Tourist App","Solo travel guide app", R.drawable.tourist)
        };


        RecyclerView list = findViewById(R.id.recycler_view);
        ProjectsAdapter adapter = new ProjectsAdapter(projects);
        list.setAdapter(adapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycler_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package com.example.bucketlist;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private BucketListItem[] thingsToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_things);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Data for Melody's bucket list
        thingsToDo = new BucketListItem[]{
                new BucketListItem("Learn to Play Piano", "Master playing 'Claire de Lune' by Debussy", R.drawable.piano, 4.0f),
                new BucketListItem("Write a Novel", "Complete a 50,000-word fantasy novel about underwater adventures", R.drawable.book, 3.5f),
                new BucketListItem("Learn Scuba Diving", "Get certified and explore the Great Barrier Reef", R.drawable.scuba, 5.0f)
        };

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view_things);
        adapter = new ItemAdapter(thingsToDo);
        recyclerView.setAdapter(adapter);

        // Set up Floating Action Button
        FloatingActionButton fab = findViewById(R.id.fab_add_thing);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddItemDialog();
            }
        });
    }

    private void showAddItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_item, null);
        builder.setView(dialogView);

        final AlertDialog dialog = builder.create();

        // Get references to dialog views
        EditText titleEdit = dialogView.findViewById(R.id.edit_text_title);
        EditText descriptionEdit = dialogView.findViewById(R.id.edit_text_description);
        RatingBar ratingBar = dialogView.findViewById(R.id.rating_bar_input);
        Button selectImageButton = dialogView.findViewById(R.id.button_select_image);
        Button cancelButton = dialogView.findViewById(R.id.button_cancel);
        Button saveButton = dialogView.findViewById(R.id.button_save);

        // Set up button click listeners
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThingsActivity.this, "Image selection coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEdit.getText().toString().trim();
                String description = descriptionEdit.getText().toString().trim();
                float rating = ratingBar.getRating();

                if (title.isEmpty()) {
                    Toast.makeText(ThingsActivity.this, "Title is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create new item with rating
                BucketListItem newItem = new BucketListItem(title, description, R.drawable.icon, rating);
                
                // Add to the array 
                BucketListItem[] newArray = new BucketListItem[thingsToDo.length + 1];
                System.arraycopy(thingsToDo, 0, newArray, 0, thingsToDo.length);
                newArray[thingsToDo.length] = newItem;
                thingsToDo = newArray;

                // Update adapter
                adapter = new ItemAdapter(thingsToDo);
                recyclerView.setAdapter(adapter);

                Toast.makeText(ThingsActivity.this, "Thing added successfully!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
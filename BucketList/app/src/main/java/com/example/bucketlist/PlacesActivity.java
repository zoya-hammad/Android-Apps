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

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private BucketListItem[] placesToGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_places);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Data for Melody's bucket list
        placesToGo = new BucketListItem[]{
                new BucketListItem("Visit Japan", "Explore Tokyo, Kyoto, and see cherry blossoms in spring", R.drawable.japan, 4.5f),
                new BucketListItem("Swim with Dolphins", "Experience swimming with dolphins in Hawaii", R.drawable.dolphins, 5.0f),
                new BucketListItem("Visit the Great Wall", "Walk on the Great Wall of China and take amazing photos", R.drawable.wall, 4.0f)
        };

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view_places);
        adapter = new ItemAdapter(placesToGo);
        recyclerView.setAdapter(adapter);

        // Set up Floating Action Button
        FloatingActionButton fab = findViewById(R.id.fab_add_place);
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
                Toast.makeText(PlacesActivity.this, "Image selection coming soon!", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(PlacesActivity.this, "Title is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create new item with rating
                BucketListItem newItem = new BucketListItem(title, description, R.drawable.icon, rating);
                
                // Add to the array 
                BucketListItem[] newArray = new BucketListItem[placesToGo.length + 1];
                System.arraycopy(placesToGo, 0, newArray, 0, placesToGo.length);
                newArray[placesToGo.length] = newItem;
                placesToGo = newArray;

                // Update adapter
                adapter = new ItemAdapter(placesToGo);
                recyclerView.setAdapter(adapter);

                Toast.makeText(PlacesActivity.this, "Place added successfully!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
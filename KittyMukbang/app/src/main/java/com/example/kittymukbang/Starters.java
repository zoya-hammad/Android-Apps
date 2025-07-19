package com.example.kittymukbang;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Starters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_starters);

        ListView startersList = findViewById(R.id.list_view_starters);
//        Dish dish1 = new Dish("Dumplings","Steamed or fried parcels filled with savory chicken or veggies.",550);
//        Dish dish2 = new Dish("Chicken Tenders", "Crispy golden-fried chicken strips served with dip.", 600);
//        Dish dish3 = new Dish("Mozzarella Sticks", "Breaded cheese sticks with a molten mozzarella center.", 550);
//        Dish dish4 = new Dish("Nachos", "Corn tortilla chips topped with cheese, salsa, and jalapeños.", 500);
//        Dish dish5 = new Dish("Chicken Nachos", "Loaded nachos with grilled chicken, cheese, and sauces.", 650);
//        Dish dish6 = new Dish("Mac and Cheese Balls", "Deep-fried mac & cheese bites with a cheesy crunch.", 550);
//        Dish dish7 = new Dish("Fried Prawns", "Crispy battered prawns served with tangy dip.", 750);
//        Dish dish8 = new Dish("Prawn Tempura", "Lightly battered prawns fried to golden perfection.", 800);
//        Dish dish9 = new Dish("Caesar Salad", "Classic Caesar with lettuce, croutons, parmesan, and dressing.", 500);
//        Dish dish10 = new Dish("Pomegranate Salad", "Fresh greens tossed with pomegranate, feta, and nuts.", 550);
//        Dish dish11 = new Dish("Tortellini", "Stuffed pasta served with your choice of creamy or tomato sauce.", 700);
//        Dish dish12 = new Dish("Chicken Wrap", "Grilled chicken wrapped in tortilla with fresh veggies and sauce.", 600);
//        Dish dish13 = new Dish("Quesadilla", "Grilled tortilla with cheesy chicken or veggie filling.", 650);
//        Dish dish14 = new Dish("Fries", "Classic salted fries, crispy and golden.", 300);
//        Dish dish15 = new Dish("Tornado Fries", "Spiral-cut seasoned fries on a stick.", 350);
//        Dish dish16 = new Dish("Cheese Fries", "Fries topped with gooey melted cheese.", 400);
//        Dish dish17 = new Dish("Loaded Fries", "Topped with cheese, sauces, jalapeños, and bits of chicken.", 550);
//        Dish dish18 = new Dish("Spicy Loaded Fries", "Loaded fries with a fiery kick.", 570);
//        Dish dish19 = new Dish("Drumsticks", "Juicy fried chicken drumsticks with a crispy coating.", 600);
//        Dish dish20 = new Dish("Chicken Wings", "Choice of buffalo, BBQ, or spicy wings.", 650);

        Dish[] dishes = {
                new Dish("Dumplings", "Steamed or fried parcels filled with savory chicken or veggies.", 550),
                new Dish("Chicken Tenders", "Crispy golden-fried chicken strips served with dip.", 600),
                new Dish("Mozzarella Sticks", "Breaded cheese sticks with a molten mozzarella center.", 550),
                new Dish("Nachos", "Corn tortilla chips topped with cheese, salsa, and jalapeños.", 500),
                new Dish("Chicken Nachos", "Loaded nachos with grilled chicken, cheese, and sauces.", 650),
                new Dish("Mac and Cheese Balls", "Deep-fried mac & cheese bites with a cheesy crunch.", 550),
                new Dish("Fried Prawns", "Crispy battered prawns served with tangy dip.", 750),
                new Dish("Prawn Tempura", "Lightly battered prawns fried to golden perfection.", 800),
                new Dish("Caesar Salad", "Classic Caesar with lettuce, croutons, parmesan, and dressing.", 500),
                new Dish("Pomegranate Salad", "Fresh greens tossed with pomegranate, feta, and nuts.", 550),
                new Dish("Tortellini", "Stuffed pasta served with your choice of creamy or tomato sauce.", 700),
                new Dish("Chicken Wrap", "Grilled chicken wrapped in tortilla with fresh veggies and sauce.", 600),
                new Dish("Quesadilla", "Grilled tortilla with cheesy chicken or veggie filling.", 650),
                new Dish("Fries", "Classic salted fries, crispy and golden.", 300),
                new Dish("Tornado Fries", "Spiral-cut seasoned fries on a stick.", 350),
                new Dish("Cheese Fries", "Fries topped with gooey melted cheese.", 400),
                new Dish("Loaded Fries", "Topped with cheese, sauces, jalapeños, and bits of chicken.", 550),
                new Dish("Spicy Loaded Fries", "Loaded fries with a fiery kick.", 570),
                new Dish("Drumsticks", "Juicy fried chicken drumsticks with a crispy coating.", 600),
                new Dish("Chicken Wings", "Choice of buffalo, BBQ, or spicy wings.", 650),
        };
//        String[] appetisers = {
//                "dumplings",
//                "chicken tenders",
//                "mozzarella sticks",
//                "nachos",
//                "chicken nachos",
//                "mac and cheese balls",
//                "fried prawns",
//                "prawn tempura",
//                "caesar salad",
//                "pomegranate salad",
//                "tortellini",
//                "chicken wrap",
//                "quesadilla",
//                "fries",
//                "tornado fries",
//                "cheese fries",
//                "loaded fries",
//                "spicy loaded fries",
//                "drumsticks",
//                "chicken wings"
//        };

//        ArrayAdapter<String> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appetisers );
//        startersList.setAdapter(dishesAdapter);

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        startersList.setAdapter(dishesAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
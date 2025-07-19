package com.example.kittymukbang;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainCourses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_courses);

        ListView mainCoursesList = findViewById(R.id.list_view_main_courses);
        Dish[] dishes = {
                new Dish("Korean Fried Chicken", "Crispy double-fried chicken glazed in spicy-sweet gochujang sauce.", 850),
                new Dish("Cheesy Ramen Bowl", "Creamy instant ramen loaded with mozzarella and spicy toppings.", 700),
                new Dish("Chicken Katsu Curry", "Crispy breaded chicken served with Japanese curry and rice.", 900),
                new Dish("Samyang Fire Noodles", "Extremely spicy Korean noodles topped with sesame and seaweed.", 650),
                new Dish("Spicy Rice Cakes (Tteokbokki)", "Chewy rice cakes in a fiery red chili sauce with fish cake.", 750),
                new Dish("Kimchi Fried Rice", "Savory fried rice tossed with kimchi, egg, and scallions.", 650),
                new Dish("Beef Bulgogi Bowl", "Marinated grilled beef served with sticky rice and veggies.", 950),
                new Dish("Hot Pot Bowl", "A steaming bowl of meat, noodles, and vegetables in spicy broth.", 1000),
                new Dish("Seafood Ramen", "Brothy noodles topped with prawns, squid, egg, and nori.", 950),
                new Dish("Loaded Ramen Platter", "Ramen with eggs, sausage, cheese, and fried chicken bites.", 1000),
                new Dish("Korean Corn Dogs", "Mozzarella and sausage battered, deep-fried, and sugar-dusted.", 600),
                new Dish("Giant Sushi Roll", "Oversized sushi roll filled with chicken, veggies, and spicy mayo.", 800),
                new Dish("Volcano Noodles", "Spicy saucy noodles served with grilled chicken and fried egg.", 750),
                new Dish("Mala Chicken Platter", "Szechuan-style spicy chicken with peppers and garlic.", 900),
                new Dish("Spicy Garlic Butter Shrimp", "Jumbo prawns tossed in garlic, chili, and butter.", 950),
                new Dish("Korean BBQ Platter", "Mix of grilled meats, kimchi, rice, and dipping sauces.", 1100),
                new Dish("Creamy Carbonara Ramen", "Fusion ramen in creamy carbonara sauce with egg and bacon.", 800),
                new Dish("Crispy Chicken Burger", "Thick fried chicken fillet with spicy sauce in a soft bun.", 650),
                new Dish("Giant Mozzarella Ramen Dog", "Cheesy ramen-coated corn dog with spicy drizzle.", 700),
                new Dish("Nashville Hot Chicken Sandwich", "Fiery fried chicken stacked with pickles and slaw.", 700)
        };

        ArrayAdapter<Dish> mainsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        mainCoursesList.setAdapter(mainsAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_view_main_courses), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
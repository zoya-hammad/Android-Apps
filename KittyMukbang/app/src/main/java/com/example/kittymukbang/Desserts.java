package com.example.kittymukbang;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Desserts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_desserts);

        ListView dessertsList = findViewById(R.id.list_view_desserts);
        Dish[] dishes = {
                new Dish("Molten Lava Cake", "Warm chocolate cake with a gooey molten center.", 550),
                new Dish("Lotus Biscoff Cheesecake", "Creamy cheesecake layered with Lotus Biscoff spread and crumbs.", 650),
                new Dish("Churros with Chocolate Dip", "Crispy cinnamon sticks served with thick chocolate sauce.", 500),
                new Dish("Korean Bingsoo", "Shaved milk ice topped with fruit, condensed milk, and syrup.", 750),
                new Dish("Brownie Sundae", "Fudgy brownie topped with vanilla ice cream and hot fudge.", 600),
                new Dish("Strawberry Shortcake Jar", "Layers of cream, sponge, and fresh strawberries in a jar.", 500),
                new Dish("Fried Ice Cream", "Ice cream scoop coated and flash-fried for a crunchy shell.", 550),
                new Dish("Nutella Pancake Stack", "Fluffy pancakes drizzled with Nutella and topped with fruits.", 650),
                new Dish("Chocolate Fondue Platter", "Assorted dippers with warm, melted chocolate for dipping.", 800),
                new Dish("Matcha Tiramisu", "A green tea twist on the classic layered Italian dessert.", 700),
                new Dish("Banana Split", "Classic banana boat with scoops of ice cream and toppings.", 600),
                new Dish("Oreo Madness", "Crushed Oreos in a creamy parfait with chocolate drizzle.", 550),
                new Dish("Crepe Roll", "Sweet crepes filled with cream and fruit, rolled to perfection.", 500),
                new Dish("Honey Butter Toast", "Thick toast topped with honey butter, ice cream, and almonds.", 650),
                new Dish("Milk Cake (Tres Leches)", "Sponge soaked in three kinds of milk, rich and moist.", 600),
                new Dish("Caramel Custard", "Smooth and creamy flan with caramel glaze.", 500),
                new Dish("Chocolate Mousse Cup", "Airy, rich chocolate mousse in a dessert glass.", 550),
                new Dish("Donuts", "Chocolate and plain glazed donuts.", 700),
                new Dish("Donut Platter", "Mini donuts with assorted toppings and dips.", 650),
                new Dish("Waffle Explosion", "Waffle topped with ice cream, sauces, fruits, and nuts.", 750)
        };

        ArrayAdapter<Dish> dessertsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        dessertsList.setAdapter(dessertsAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_view_desserts), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
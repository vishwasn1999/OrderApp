package com.example.orderapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton cart;
    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating an arraylist
        cart = (FloatingActionButton) findViewById(R.id.btnCart);

        modelList = new ArrayList<>();
        modelList.add(new Model("Green Tea", "Loaded with antioxidants & nutrients that have powerful effects on the body like improved brain function & fat loss", R.drawable.greentea ));
        modelList.add(new Model("Latte","Our Latte is a classic coffee drink made with espresso and steamed milk. It is best enjoyed with our almond biscuit.", R.drawable.late));
        modelList.add(new Model("Orange Smoothie", "Best Orange Smoothie Cookbook Ever For Beginners [Matcha Recipes, Smoothie Bowl Recipe, Tropical Drink Recipes, Vegetable And Fruit Smoothie Recipes]", R.drawable.orange));
        modelList.add(new Model("Orange Vanilla", " Pure Agglomerated Instant Coffee, Natural Identical Flavours", R.drawable.orangevanilla));
        modelList.add(new Model("Cappucino","Our Cappuccino is a traditionally made espresso-based coffee drink prepared with steamed milk foam.", R.drawable.cappcunio));
        modelList.add(new Model("Thai Tea", "Spiced with anise seed, our native – grown black Tea is havested from the lush mountain of Chiang Mai and blended with milk and natural cane sugar. ", R.drawable.thaitea));
        modelList.add(new Model("Tea", "Elaichi, Tulsi patra, Sonth, Kali mirch, Dalchini, Mulethi, Babool,Jai Phal, Arjun, Tejptra, Khadir,Lavang, Amal Tas, Pippali & Majishtha.", R.drawable.tea));
        modelList.add(new Model("Bubble Tea", "It contain a tea base mixed/shaken with fruit or milk, to which chewy tapioca balls and fruit jellies are often added", R.drawable.milk));
        modelList.add(new Model("Matcha", "Matcha is a finely ground Green Tea powder made from the young and nutrient rich leaves of the tea plant.", R.drawable.match));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);


//      cart
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SummaryActivity.class);
                startActivity(intent);
            }
        });

    }
}
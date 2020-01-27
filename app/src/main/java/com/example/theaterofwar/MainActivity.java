package com.example.theaterofwar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listHeroes;
    ListHeroesAdapter listHeroesAdapter;
    ArrayList<String> heroes;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listHeroes = findViewById(R.id.rv_list_heroes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listHeroes.setLayoutManager(linearLayoutManager);
        listHeroes.setHasFixedSize(true);
        heroes = new ArrayList<>();
        createListOfHeroes(heroes);

        listHeroesAdapter = new ListHeroesAdapter(this, heroes);
        listHeroes.setAdapter(listHeroesAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String s = intent.getStringExtra("hero");
                System.out.println(s);
            }
        }
    }

    protected ArrayList<String> createListOfHeroes(ArrayList<String> list) {
        list.add("Elf");
        list.add("Dwarf");
        list.add("Old mage");
        return list;
    }
}

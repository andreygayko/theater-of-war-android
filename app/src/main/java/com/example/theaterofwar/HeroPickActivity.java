package com.example.theaterofwar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theaterofwar.heroes.Dwarf;
import com.example.theaterofwar.heroes.Elf;
import com.example.theaterofwar.heroes.Hero;
import com.example.theaterofwar.heroes.OldMage;

public class HeroPickActivity extends AppCompatActivity {

    TextView heroName;
    TextView heroPicture;
    TextView heroParams;
    Hero hero;
    String heroParameters;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_pick);
        heroName = findViewById(R.id.tv_hero_name);
        heroPicture = findViewById(R.id.tv_hero_picture);
        heroParams = findViewById(R.id.tv_hero_params);
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String name = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            heroName.setText(name);
            setHeroPicture(name);
            setHeroParams(name);
            heroParameters = "Attack: " + hero.getAttack() + "\n" + "HP: " + hero.getHealth() + "\n"
                    + "Defence " + hero.getDefense() + "\n" + "Can block: " + hero.isBlock() + "\n"
                    + "Can dodge: " + hero.isDodge();
            heroParams.setText(heroParameters);
        }
    }

    public void onClickPickHero(View view) {
        /*String stringToPassBack = textView.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("hero", stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();*/
        Context context = HeroPickActivity.this;
        Class destinationActivity = BattleLogs.class;
        Intent intent = new Intent(context, destinationActivity);
        intent.putExtra(Intent.EXTRA_TEXT, heroName.getText());
        startActivity(intent);
    }

    public void onClickGoBackToHeroesList(View view) {
        finish();
    }

    public void setHeroPicture(String name) {
        switch (name) {
            case "Elf":
                heroPicture.setBackgroundResource(R.drawable.little_elf);
                break;
            case "Dwarf":
                heroPicture.setBackgroundResource(R.drawable.little_dwarf);
                break;
            case "Old mage":
                heroPicture.setBackgroundResource(R.drawable.little_old_mage);
                break;
        }
    }

    public void setHeroParams(String name) {
        String s = "";
        switch (name) {
            case "Elf":
                hero = new Elf();
                break;
            case "Dwarf":
                hero = new Dwarf();
                break;
            case "Old mage":
                hero = new OldMage();
                break;
        }
    }
}

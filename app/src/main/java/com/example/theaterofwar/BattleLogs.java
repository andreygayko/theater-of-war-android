package com.example.theaterofwar;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theaterofwar.heroes.Dwarf;
import com.example.theaterofwar.heroes.Elf;
import com.example.theaterofwar.heroes.Hero;
import com.example.theaterofwar.heroes.OldMage;

import java.util.Random;

public class BattleLogs extends AppCompatActivity {

    TextView versus;
    TextView logs;
    StringBuilder log = new StringBuilder();
    String heroName;
    Hero hero1;
    Hero hero2;
    private int damage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_logs);
        versus = findViewById(R.id.tv_versus);
        logs = findViewById(R.id.tv_logs);
        logs.setMovementMethod(new ScrollingMovementMethod());
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            heroName = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
        }
        createHero1(heroName);
        createHero2();
        String vs = hero1.getName() + " vs " + hero2.getName();
        versus.setText(vs);
        action(hero1, hero2);
        SpannableString s = new SpannableString(log.toString());
        int x = 0;
        while (x >= 0 && x < log.toString().length()) {
            x = log.toString().indexOf('R', x);
            if (x >= 0) {
                s.setSpan(new RelativeSizeSpan(1.2f), x, x + 8, 0);
                x++;
            }
        }
        int z = 0;
        int y = log.toString().indexOf('!');
        if (log.toString().charAt(y - 8) == 'E')
            z = y - 8;
        if (log.toString().charAt(y - 10) == 'D')
            z = y - 10;
        if (log.toString().charAt(y - 13) == 'O')
            z = y - 13;
        if (log.toString().charAt(y - 18) == 'W')
            z = y - 18;
        s.setSpan(new RelativeSizeSpan(1.2f), z, y, 0);
        logs.setText(s, TextView.BufferType.SPANNABLE);
    }

    public void createHero1(String name) {
        switch (name) {
            case "Elf":
                hero1 = new Elf();
                break;
            case "Dwarf":
                hero1 = new Dwarf();
                break;
            case "Old mage":
                hero1 = new OldMage();
                break;
        }
    }

    public void createHero2() {
        int randomNum = new Random().nextInt(3);
        switch (randomNum) {
            case 0:
                hero2 = new Elf();
                break;
            case 1:
                hero2 = new Dwarf();
                break;
            case 2:
                hero2 = new OldMage();
                break;
        }
    }

    public void action(Hero h1, Hero h2) {
        String st;
        int round = 1;
        while ((h1.getHealth() > 0) && (h2.getHealth() > 0)) {
            String rnd = "Round " + round + "\n";
            log.append(rnd);
            SpannableString spannablString = new SpannableString(rnd);
            spannablString.setSpan(new RelativeSizeSpan(2f), 0, 8, 0);
            battleMechanics(h1, h2);
            battleMechanics(h2, h1);
            round++;
        }
        if (h1.getHealth() <= 0 && h2.getHealth() <= 0) {
            st = "We have two bodies!" + "\n";
            log.append(st);

        } else if (h1.getHealth() <= 0) {
            st = h2.getName() + " wins!" + "\n";
            log.append(st);
        } else if (h2.getHealth() <= 0) {
            st = h1.getName() + " wins!" + "\n";
            log.append(st);
        }
    }

    public void battleMechanics(Hero h1, Hero h2) {
        String s;
        if (new Random().nextInt(100) < 30) {
            if (h2.isBlock()) {
                damage = (h1.getAttack() - h2.getDefense()) / 3;
                s = h2.getName() + " blocks 60% damage" + "\n";
                log.append(s);
            }
            if (h2.isDodge()) {
                damage = 0;
                s = h2.getName() + " dodged" + "\n";
                log.append(s);
            }
        } else {
            if (new Random().nextInt(100) < 30) {
                damage = h1.getAttack() + h1.getAttack() / 2 - h2.getDefense();
                s = h1.getName() + " crits" + "\n";
                log.append(s);
            } else
                damage = h1.getAttack() - h2.getDefense();
        }

        h2.setHealth(h2.getHealth() - damage);
        s = h1.getName() + " makes " + damage + " damage" + "\n";
        log.append(s);
        s = "After round " + h2.getName() + " has " + h2.getHealth() + " hp" + "\n";
        log.append(s);
    }
}



package com.example.grey.zerro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.grey.zerro.entity.Game;
import com.example.grey.zerro.entity.Player;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Game game = new Game("testGame");
        game.addPlayer(new Player("John"));
        game.addPlayer(new Player("Ivan"));

        System.out.println("123");
    }
}

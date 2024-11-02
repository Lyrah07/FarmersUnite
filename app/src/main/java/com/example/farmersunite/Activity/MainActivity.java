package com.example.farmersunite.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.farmersunite.R;

public class MainActivity extends AppCompatActivity {
private Button intro_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        intro_button=findViewById(R.id.intro_button);
        intro_button.setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,ShopActivity.class)));

    }
}
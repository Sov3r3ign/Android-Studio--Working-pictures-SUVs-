package com.example.practical7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridItemActivity extends AppCompatActivity {

    TextView suvCarName;
    ImageView suvCarImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        suvCarName = findViewById(R.id.gridSuvCars);
        suvCarImage = findViewById(R.id.gridSuvCarImages);

        Intent intent = new Intent();

        suvCarName.setText(intent.getStringExtra("suvCarName"));
        suvCarImage.setImageResource(intent.getIntExtra("suvCarImage",0));

    }
}
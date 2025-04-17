package com.example.practical7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] suvCarNames ={"Toyota","Audi","Mercedes Benz","BMW","Honda","Lamborghini","Ford Mustang","Nissan","Porsche Cayenne"};
    int [] suvCarImages ={R.drawable.toyota,R.drawable.audi,R.drawable.benz,R.drawable.bmw,R.drawable.honda,R.drawable.lambo,R.drawable.mustang,R.drawable.nissan,R.drawable.porsche};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.suvGalleryView);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("suvCarName", suvCarNames[position]);
                intent.putExtra("suvCarImage", suvCarImages[position]);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return suvCarImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View suvCarView = getLayoutInflater().inflate(R.layout.row_data,null);

            TextView suvCarName = suvCarView.findViewById(R.id.suvCar);
            ImageView suvCarImage = suvCarView.findViewById(R.id.suvCarImages);

            suvCarName.setText(suvCarNames[position]);
            suvCarImage.setImageResource(suvCarImages[position]);
            return suvCarView;
        }
    }
}
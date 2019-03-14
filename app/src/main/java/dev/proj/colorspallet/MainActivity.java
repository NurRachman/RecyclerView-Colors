package dev.proj.colorspallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ColorsAdapater colorsAdapater;
    RecyclerView recyclerItems;
    List<Integer> dataColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerItems = findViewById(R.id.recyclerItems);
        dataColors = new ArrayList<>();
        dataColors.add(getResources().getColor(R.color.color1));
        dataColors.add(getResources().getColor(R.color.color2));
        dataColors.add(getResources().getColor(R.color.color3));
        dataColors.add(getResources().getColor(R.color.color4));
        dataColors.add(getResources().getColor(R.color.color5));

        colorsAdapater = new ColorsAdapater(this, dataColors);
        recyclerItems.setAdapter(colorsAdapater);
        recyclerItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerItems.addOnItemTouchListener(new RecyclerTouch(this, recyclerItems, new RecyclerTouch.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Kode Warna " + dataColors.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}

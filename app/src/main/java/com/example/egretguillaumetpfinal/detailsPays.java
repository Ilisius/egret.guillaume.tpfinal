package com.example.egretguillaumetpfinal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class detailsPays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pays);



        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Pays p = MainActivity.listPays.get(position);

        TextView tn = findViewById(R.id.nom);
        tn.setText(p.getName());

        TextView tr = findViewById(R.id.region);
        tr.setText(p.getRegion());

        TextView tsr = findViewById(R.id.subRegion);
        tsr.setText(p.getSubregion());

        TextView th = findViewById(R.id.nbhabs);
        th.setText("" + p.getPopulation());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

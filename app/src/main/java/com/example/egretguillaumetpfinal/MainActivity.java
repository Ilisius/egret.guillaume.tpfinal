package com.example.egretguillaumetpfinal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static adapterCustom adapter;
    private String API_BASE = "https://restcountries.eu/rest/v2/";
    public static List<Pays> listPays;
    private RecyclerView.LayoutManager layoutManagerRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listPays = new ArrayList<>();

        createRecyclerView();
        callApi();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRecyclerView();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void createRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerViewPays);
        recyclerView.setHasFixedSize(true);
        layoutManagerRV = new LinearLayoutManager(this);
        adapter = new adapterCustom(listPays);
        recyclerView.setLayoutManager(layoutManagerRV);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new adapterCustom.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, detailsPays.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }

    public void callApi()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyService service = retrofit.create(MyService.class);
        Call<List<Pays>> listPaysGet = service.getProducts();
        listPaysGet.enqueue(new Callback<List<Pays>>() {
            @Override
            public void onResponse(Call<List<Pays>> call, Response<List<Pays>>
                    response) {
                listPays.addAll(response.body());
                adapter.notifyDataSetChanged();
                Log.d("joyPAD","on a retrouvé " + listPays.size() + " produits");

            }
            @Override
            public void onFailure(Call<List<Pays>> call, Throwable t) {
                Log.d("joyPAD","on a rien trouvé ");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

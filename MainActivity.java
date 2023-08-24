//GetYourDoctor is Android app help you to locate the available doctor near by you.

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.getyourdoctor.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //5- initializing Recylerview
    RecyclerView recyclerView = findViewById(R.id.RecyclerView);
    private recyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> applist;

    //array of the images
    int[] covers = new int []{
            R.drawable.fash1,
            R.drawable.fash2,
            R.drawable.fash3,
            R.drawable.fash4,
            R.drawable.fash5,
            R.drawable.fash6,
    };

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 1-toolbar;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //4- making the home botton in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);

        applist = new ArrayList<>();

        //Adapter
        adapter = new recyclerViewAdaptery(this, applist);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        //layout
        recyclerView.setAdapter(manager);

        // adapter
        recyclerView.setAdapter(adapter);

        //-6 putting data into recyclerview
        IntializeDataIntoRecyclerView();



    }

    private void IntializeDataIntoRecyclerView() {

        row a = new row (covers[0]);
        applist.add(a);

         a = new row (covers[1]);
        applist.add(a);

         a = new row (covers[2]);
        applist.add(a);

        a = new row (covers[3]);
        applist.add(a);

        a = new row (covers[4]);
        applist.add(a);

        a = new row (covers[5]);
        applist.add(a);

        adapter.notifyDataSetChanged();


    }

    //adding buttons to toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the manu; this adds items to thee action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

}

// 3- Handing click on toolbar bottons

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar item clicks here. the action bar will
        //automatically handle clicks on the home/up button. so long
        //as you specify a parent activity in androidmainfest.xml
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

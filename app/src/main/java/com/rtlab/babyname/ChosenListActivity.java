package com.rtlab.babyname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ChosenListActivity extends AppCompatActivity {

    private Toolbar chosenToolbar;
    private SecondAdapter chosenAdapter;
    private ArrayList<String> chosenNames;
    ArrayList<Name> chosenNameObts;
    private ListView chosenLv;
    private SaveUtil sv = new SaveUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_list);


        chosenToolbar = findViewById(R.id.chosenToolbar);
        setSupportActionBar(chosenToolbar);
        if(getSupportActionBar() != null){
            Intent intent = getIntent();
            String extraString = intent.getStringExtra("chosen list name");
            getSupportActionBar().setTitle(extraString);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                chosenToolbar.setTitleTextColor(getResources().getColor(R.color.textRedColor));
            }
        }

        Intent intent = getIntent();
        String extraString = intent.getStringExtra("dieList");

        chosenNames = Namer.myListAssetReader(ChosenListActivity.this, extraString);
        chosenNameObts = Namer.nameLister(chosenNames);
        chosenLv = findViewById(R.id.chosenActLV);
        chosenAdapter = new SecondAdapter(ChosenListActivity.this, chosenNameObts);
        chosenLv.setAdapter(chosenAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuUtil.handleMenuItemClick(this, item) || super.onOptionsItemSelected(item);
    }
}
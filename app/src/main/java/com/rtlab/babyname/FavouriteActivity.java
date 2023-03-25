package com.rtlab.babyname;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    private Toolbar favToolbar;
    private ListAdapter adapter;
    private ArrayList<String> favNames;
    private ListView lv;
    private SaveUtil sv = new SaveUtil();
    private ReviewInfo reviewInfo;
    private ReviewManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);


        favToolbar = findViewById(R.id.favToolbar);
        setSupportActionBar(favToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.your_favorites);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                favToolbar.setTitleTextColor(getResources().getColor(R.color.textRedColor));
            }
        }


        favNames = sv.getNamesList(this);
        java.util.Collections.sort(favNames);
        lv = findViewById(R.id.favListView);
        adapter = new com.rtlab.babyname.ListAdapter(FavouriteActivity.this, favNames);
        lv.setAdapter(adapter);

        if (favNames.size() > 2){
            AppRater.app_launched(this);
        }
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

    //in app review
    void activateReviewInfo(){
        manager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> managerInfoTask = manager.requestReviewFlow();
        managerInfoTask.addOnCompleteListener((task)->
        {
            if (task.isSuccessful()){
                reviewInfo = task.getResult();
            }else {
                //Toast.makeText(this, "Review failed to start", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void startReviewFlow(){
        if(reviewInfo != null){
            Task<Void> flow = manager.launchReviewFlow(this, reviewInfo);
            flow.addOnCompleteListener(task -> {
                Toast.makeText(this, "Review started", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
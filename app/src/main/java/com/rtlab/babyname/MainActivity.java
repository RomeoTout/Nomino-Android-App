package com.rtlab.babyname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar cusToolbar;
    private Button favAvtBtn;
    private Button showdownActBtn;
    private Button listActBtn;
    private TextView nameTV;
    private TextView religionTV;
    private TextView descriptionTV;
    private ImageButton nextNameImgBtn;
    private ImageButton previousNameImgBtn;
    private ImageButton favImgBtn;
    private ImageButton shareImgBtn;
    ArrayList<Name> previousNameList;
    private RadioGroup rg;
    ArrayList stringCurrentNameList;
    ArrayList<Name> currentNameList;
    Name firstChosenName;
    SaveUtil sv = new SaveUtil();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //custom toolbar - others say setTitle(null) may get NullPointerException - remembers this if having crash reports
        cusToolbar = findViewById(R.id.cusToolbar);
        setSupportActionBar(cusToolbar);
        //for actionbar nullPointerException
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.app_name);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cusToolbar.setTitleTextColor(getResources().getColor(R.color.textRedColor));
            }
        }
        //to Favourite Activity
        favAvtBtn = findViewById(R.id.favouriteActivityBtn);
        Effect.buttonEffect(favAvtBtn);
        favAvtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
                startActivity(intent);
            }
        });

        //to Shodown Activity
        showdownActBtn = findViewById(R.id.showdownActivityBtn);
        Effect.buttonEffect(showdownActBtn);
        showdownActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowdownActivity.class);
                startActivity(intent);
            }
        });

        //to List Activity
        listActBtn = findViewById(R.id.listActivityButton);
        Effect.buttonEffect(listActBtn);
        listActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        //add to favorite list
        favImgBtn = findViewById(R.id.imageButtonFav);
        Effect.buttonEffect(favImgBtn);
        favImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nameTV.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), R.string.no_name, Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<String> nameList = new ArrayList<>();
                    //nameList.add(nameTV.getText().toString());
                    nameList.add(firstChosenName.getName() + firstChosenName.getMeaning());
                    sv.saveNames(view.getContext(), nameList, sv.NAMES_LIST);
                }
            }
        });

        //share app button
        shareImgBtn = findViewById(R.id.imageButtonShare);
        Effect.buttonEffect(shareImgBtn);
        shareImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                String shareBody = firstChosenName.getName() + firstChosenName.getMeaning();
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Name idea");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, getString(R.string.share)));
            }
        });


        //init views
        nameTV = findViewById(R.id.nameTextView);
        //religionTV = findViewById(R.id.religionTextView);
        descriptionTV = findViewById(R.id.descriptionTextView);

        //a name is already loaded at startup
        stringCurrentNameList = Namer.myListAssetReader(MainActivity.this, getString(R.string.allfemale));
        currentNameList = Namer.nameLister(stringCurrentNameList);
        firstChosenName = Namer.nameFromNameList(currentNameList);
        nameTV.setText(firstChosenName.getName());
        //religionTV.setText(firstChosenName.getReligion());
        //cut the  equal sign
        descriptionTV.setText(firstChosenName.getMeaning().substring(1));

        //radiogroup oncheckedchange
        rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioBtnGirl:
                        stringCurrentNameList = Namer.myListAssetReader(MainActivity.this, getString(R.string.allfemale));
                        currentNameList = Namer.nameLister(stringCurrentNameList);
                        firstChosenName = Namer.nameFromNameList(currentNameList);
                        nameTV.setText(firstChosenName.getName());
                        //religionTV.setText(firstChosenName.getReligion());
                        //cut the  equal sign
                        descriptionTV.setText(firstChosenName.getMeaning().substring(1));
                        break;
                    case R.id.radioBtnBoy:
                        stringCurrentNameList = Namer.myListAssetReader(MainActivity.this, getString(R.string.allmale));
                        currentNameList = Namer.nameLister(stringCurrentNameList);
                        firstChosenName = Namer.nameFromNameList(currentNameList);
                        nameTV.setText(firstChosenName.getName());
                        //religionTV.setText(firstChosenName.getReligion());
                        //cut the  equal sign
                        descriptionTV.setText(firstChosenName.getMeaning().substring(1));
                        break;
                    case R.id.radioBtnUni:
                        stringCurrentNameList = Namer.myListAssetReader(MainActivity.this, getString(R.string.alluni));
                        currentNameList = Namer.nameLister(stringCurrentNameList);
                        firstChosenName = Namer.nameFromNameList(currentNameList);
                        nameTV.setText(firstChosenName.getName());
                        //religionTV.setText(firstChosenName.getReligion());
                        //cut the  equal sign
                        descriptionTV.setText(firstChosenName.getMeaning().substring(1));
                        break;
                }
            }
        });

        //init list for previous button and adding the first name into the list
        previousNameList = new ArrayList<>();
        previousNameList.add(firstChosenName);

        nextNameImgBtn = findViewById(R.id.nextNameImgBtn);
        nextNameImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name chosenName = Namer.nameFromNameList(currentNameList);
                firstChosenName = chosenName;
                previousNameList.add(chosenName);
                nameTV.setText(chosenName.getName());
                //religionTV.setText(chosenName.getReligion());
                //cut the  equal sign
                descriptionTV.setText(chosenName.getMeaning().substring(1));
            }
        });

        previousNameImgBtn = findViewById(R.id.previousNameImgBtn);
        previousNameImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(previousNameList.size() > 1){
                    nameTV.setText(previousNameList.get(previousNameList.size() - 2).getName());
                    //religionTV.setText(previousNameList.get(previousNameList.size() - 2).getReligion());
                    //cut the  equal sign
                    descriptionTV.setText(previousNameList.get(previousNameList.size() - 2).getMeaning().substring(1));
                    previousNameList.remove(previousNameList.size() - 2);
                }
            }
        });
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


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//
//        switch (item.getItemId()){
//            case R.id.mShare:
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
//                String link = getString(R.string.uri);
//                shareIntent.putExtra(Intent.EXTRA_TEXT, link);
//                startActivity(Intent.createChooser(shareIntent, getString(R.string.share)));
//                return true;
//            case R.id.mFavourites:
//                Intent intent = new Intent(this, FavouriteActivity.class);
//                startActivity(intent);
//                return true;
//            case R.id.mRate:
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(this.getString(R.string.uri))));
//                return true;
//            case R.id.mPrivacyPolicy:
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(this.getString(R.string.privacy_uri))));
//                return true;
//            case R.id.mFeedback:
//                Intent feedbackIntent = new Intent(Intent.ACTION_SEND);
//                feedbackIntent.setType("text/plain");
//                feedbackIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { this.getString(R.string.feedback_email) });
//                feedbackIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.feedback);
//                startActivity(Intent.createChooser(feedbackIntent, ""));
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }
}
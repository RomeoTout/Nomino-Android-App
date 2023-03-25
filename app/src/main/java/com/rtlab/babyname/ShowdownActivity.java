package com.rtlab.babyname;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowdownActivity extends AppCompatActivity {

    private Toolbar showdownToolbar;
    RadioGroup sdRG;
    TextView firstSDNameTV;
    TextView firstSdDescTV;
    TextView secondSDNameTV;
    TextView secondSdDescTV;
    TextView thirdSDNameTV;
    TextView thirdSdDescTV;
    TextView fourthSDNameTV;
    TextView fourthSdDescTv;
    TextView fifthSDNameTV;
    TextView fifthSdDescTV;
    Button optionOneFavBtn;
    Button optionTwoFavBtn;
    Button optionThirdFavBtn;
    Button optionFourthFavBtn;
    Button optionFifthFavBtn;
    Button chooseOption1Btn;
    Button chooseOption2Btn;
    Button chooseOption3Btn;
    Button chooseOption4Btn;
    Button chooseOption5Btn;
    ArrayList stringSDNameList;
    ArrayList currentSDNameList;
    boolean chosenWinner;
    Name option1Name;
    Name option2Name;
    Name option3Name;
    Name option4Name;
    Name option5Name;
    SaveUtil sv = new SaveUtil();

    ArrayList<Name> selectedNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdown);

        //custom toolbar - others say setTitle(null) may get NullPointerException - remembers this if having crash reports
        showdownToolbar = findViewById(R.id.showdownToolbar);
        setSupportActionBar(showdownToolbar);
        //for actionbar nullPointerException
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.choose_name);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                showdownToolbar.setTitleTextColor(getResources().getColor(R.color.textRedColor));
            }
        }


        firstSDNameTV = findViewById(R.id.firstSdNameTV);
        firstSdDescTV = findViewById(R.id.firstSdDescTv);
        secondSDNameTV = findViewById(R.id.secSdNameTv);
        secondSdDescTV = findViewById(R.id.secSdDescTv);
        thirdSDNameTV = findViewById(R.id.thirdSdNameTv);
        thirdSdDescTV = findViewById(R.id.thirdSdDescTv);
        fourthSDNameTV = findViewById(R.id.fourthSdNameTv);
        fourthSdDescTv = findViewById(R.id.fourthSdDescTv);
        fifthSDNameTV = findViewById(R.id.fifthSdNameTv);
        fifthSdDescTV = findViewById(R.id.fifthSdDescTv);

        //save first name to favourites
        optionOneFavBtn = findViewById(R.id.optionOneFavBtn);
        optionOneFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstSDNameTV.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), R.string.no_name, Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<String> nameList = new ArrayList<>();
                    nameList.add(option1Name.getName() + option1Name.getMeaning());
                    sv.saveNames(view.getContext(), nameList, sv.NAMES_LIST);
                }
            }
        });

        //save second name to favourites
        optionTwoFavBtn = findViewById(R.id.optionTwoFavBtn);
        optionTwoFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(secondSDNameTV.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), R.string.no_name, Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<String> nameList = new ArrayList<>();
                    nameList.add(option2Name.getName() + option2Name.getMeaning());
                    sv.saveNames(view.getContext(), nameList, sv.NAMES_LIST);
                }
            }
        });

        //save third name to favourites
        optionThirdFavBtn = findViewById(R.id.optionThreeFavBtn);
        optionThirdFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thirdSDNameTV.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), R.string.no_name, Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<String> nameList = new ArrayList<>();
                    nameList.add(option3Name.getName() + option3Name.getMeaning());
                    sv.saveNames(view.getContext(), nameList, sv.NAMES_LIST);
                }
            }
        });

        //save fourth name to favourites
        optionFourthFavBtn = findViewById(R.id.optionFourFavBtn);
        optionFourthFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fourthSDNameTV.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), R.string.no_name, Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<String> nameList = new ArrayList<>();
                    nameList.add(option4Name.getName() + option4Name.getMeaning());
                    sv.saveNames(view.getContext(), nameList, sv.NAMES_LIST);
                }
            }
        });

        optionFifthFavBtn = findViewById(R.id.optionFiveFavBtn);
        optionFifthFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fifthSDNameTV.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), R.string.no_name, Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<String> nameList = new ArrayList<>();
                    nameList.add(option5Name.getName() + option5Name.getMeaning());
                    sv.saveNames(view.getContext(), nameList, sv.NAMES_LIST);
                }
            }
        });

        chooseOption1Btn = findViewById(R.id.optionOneBtn);
        chooseOption1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNames.add(option1Name);
                if(selectedNames.size() < 5){
                    option1Name = Namer.nameFromNameList(currentSDNameList);
                    option2Name = Namer.nameFromNameList(currentSDNameList);
                    option3Name = Namer.nameFromNameList(currentSDNameList);
                    option4Name = Namer.nameFromNameList(currentSDNameList);
                    option5Name = Namer.nameFromNameList(currentSDNameList);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else if(selectedNames.size() == 5){
                    option1Name = selectedNames.get(0);
                    option2Name = selectedNames.get(1);
                    option3Name = selectedNames.get(2);
                    option4Name = selectedNames.get(3);
                    option5Name = selectedNames.get(4);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else {
                    if (!chosenWinner){
                        chosenWinner = true;
                        firstSDNameTV.setTextSize(36);
                        firstSDNameTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                        Toast.makeText(view.getContext(), getString(R.string.winner_is) + " " + option1Name.getName(), Toast.LENGTH_SHORT).show();
                    }
                   }
            }
        });
        chooseOption2Btn = findViewById(R.id.optionTwoBtn);
        chooseOption2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNames.add(option2Name);
                if(selectedNames.size() < 5){
                    option1Name = Namer.nameFromNameList(currentSDNameList);
                    option2Name = Namer.nameFromNameList(currentSDNameList);
                    option3Name = Namer.nameFromNameList(currentSDNameList);
                    option4Name = Namer.nameFromNameList(currentSDNameList);
                    option5Name = Namer.nameFromNameList(currentSDNameList);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else if(selectedNames.size() == 5){
                    option1Name = selectedNames.get(0);
                    option2Name = selectedNames.get(1);
                    option3Name = selectedNames.get(2);
                    option4Name = selectedNames.get(3);
                    option5Name = selectedNames.get(4);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else {
                    if (!chosenWinner){
                        secondSDNameTV.setTextSize(36);
                        secondSDNameTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                        Toast.makeText(view.getContext(), getString(R.string.winner_is) + " " + option2Name.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        chooseOption3Btn = findViewById(R.id.optionThreeBtn);
        chooseOption3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNames.add(option3Name);
                if(selectedNames.size() < 5){
                    option1Name = Namer.nameFromNameList(currentSDNameList);
                    option2Name = Namer.nameFromNameList(currentSDNameList);
                    option3Name = Namer.nameFromNameList(currentSDNameList);
                    option4Name = Namer.nameFromNameList(currentSDNameList);
                    option5Name = Namer.nameFromNameList(currentSDNameList);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else if(selectedNames.size() == 5){
                    option1Name = selectedNames.get(0);
                    option2Name = selectedNames.get(1);
                    option3Name = selectedNames.get(2);
                    option4Name = selectedNames.get(3);
                    option5Name = selectedNames.get(4);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else {
                    if (!chosenWinner){
                        thirdSDNameTV.setTextSize(36);
                        thirdSDNameTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                        Toast.makeText(view.getContext(), getString(R.string.winner_is) + " " + option3Name.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        chooseOption4Btn = findViewById(R.id.optionFourBtn);
        chooseOption4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNames.add(option4Name);
                if(selectedNames.size() < 5){
                    option1Name = Namer.nameFromNameList(currentSDNameList);
                    option2Name = Namer.nameFromNameList(currentSDNameList);
                    option3Name = Namer.nameFromNameList(currentSDNameList);
                    option4Name = Namer.nameFromNameList(currentSDNameList);
                    option5Name = Namer.nameFromNameList(currentSDNameList);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else if(selectedNames.size() == 5){
                    option1Name = selectedNames.get(0);
                    option2Name = selectedNames.get(1);
                    option3Name = selectedNames.get(2);
                    option4Name = selectedNames.get(3);
                    option5Name = selectedNames.get(4);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else {
                    if (!chosenWinner){
                        fourthSDNameTV.setTextSize(36);
                        fourthSDNameTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                        Toast.makeText(view.getContext(), getString(R.string.winner_is) + " " + option4Name.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        chooseOption5Btn = findViewById(R.id.optionFiveBtn);
        chooseOption5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNames.add(option5Name);
                if(selectedNames.size() < 5){
                    option1Name = Namer.nameFromNameList(currentSDNameList);
                    option2Name = Namer.nameFromNameList(currentSDNameList);
                    option3Name = Namer.nameFromNameList(currentSDNameList);
                    option4Name = Namer.nameFromNameList(currentSDNameList);
                    option5Name = Namer.nameFromNameList(currentSDNameList);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else if(selectedNames.size() == 5){
                    option1Name = selectedNames.get(0);
                    option2Name = selectedNames.get(1);
                    option3Name = selectedNames.get(2);
                    option4Name = selectedNames.get(3);
                    option5Name = selectedNames.get(4);

                    firstSDNameTV.setText(option1Name.getName());
                    firstSdDescTV.setText(option1Name.getMeaning());
                    secondSDNameTV.setText(option2Name.getName());
                    secondSdDescTV.setText(option2Name.getMeaning());
                    thirdSDNameTV.setText(option3Name.getName());
                    thirdSdDescTV.setText(option3Name.getMeaning());
                    fourthSDNameTV.setText(option4Name.getName());
                    fourthSdDescTv.setText(option4Name.getMeaning());
                    fifthSDNameTV.setText(option5Name.getName());
                    fifthSdDescTV.setText(option5Name.getMeaning());

                }else {
                    if (!chosenWinner){
                        fifthSDNameTV.setTextSize(36);
                        fifthSDNameTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                        Toast.makeText(view.getContext(), getString(R.string.winner_is) + " " + option5Name.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //radiogroup oncheckedchange
        sdRG = findViewById(R.id.radioGroup2);
        sdRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.showRadBtnGirl:
                        playAgain();
                        stringSDNameList = Namer.myListAssetReader(ShowdownActivity.this, getString(R.string.allfemale));
                        currentSDNameList = Namer.nameLister(stringSDNameList);

                        option1Name = Namer.nameFromNameList(currentSDNameList);
                        option2Name = Namer.nameFromNameList(currentSDNameList);
                        option3Name = Namer.nameFromNameList(currentSDNameList);
                        option4Name = Namer.nameFromNameList(currentSDNameList);
                        option5Name = Namer.nameFromNameList(currentSDNameList);

                        firstSDNameTV.setText(option1Name.getName());
                        firstSdDescTV.setText(option1Name.getMeaning());
                        secondSDNameTV.setText(option2Name.getName());
                        secondSdDescTV.setText(option2Name.getMeaning());
                        thirdSDNameTV.setText(option3Name.getName());
                        thirdSdDescTV.setText(option3Name.getMeaning());
                        fourthSDNameTV.setText(option4Name.getName());
                        fourthSdDescTv.setText(option4Name.getMeaning());
                        fifthSDNameTV.setText(option5Name.getName());
                        fifthSdDescTV.setText(option5Name.getMeaning());

                        break;
                    case R.id.showRadBtnBoy:
                        playAgain();
                        stringSDNameList = Namer.myListAssetReader(ShowdownActivity.this, getString(R.string.allmale));
                        currentSDNameList = Namer.nameLister(stringSDNameList);

                        option1Name = Namer.nameFromNameList(currentSDNameList);
                        option2Name = Namer.nameFromNameList(currentSDNameList);
                        option3Name = Namer.nameFromNameList(currentSDNameList);
                        option4Name = Namer.nameFromNameList(currentSDNameList);
                        option5Name = Namer.nameFromNameList(currentSDNameList);

                        firstSDNameTV.setText(option1Name.getName());
                        firstSdDescTV.setText(option1Name.getMeaning());
                        secondSDNameTV.setText(option2Name.getName());
                        secondSdDescTV.setText(option2Name.getMeaning());
                        thirdSDNameTV.setText(option3Name.getName());
                        thirdSdDescTV.setText(option3Name.getMeaning());
                        fourthSDNameTV.setText(option4Name.getName());
                        fourthSdDescTv.setText(option4Name.getMeaning());
                        fifthSDNameTV.setText(option5Name.getName());
                        fifthSdDescTV.setText(option5Name.getMeaning());

                        break;
                    case R.id.showRadBtnUni:
                        playAgain();
                        stringSDNameList = Namer.myListAssetReader(ShowdownActivity.this, getString(R.string.alluni));
                        currentSDNameList = Namer.nameLister(stringSDNameList);

                        option1Name = Namer.nameFromNameList(currentSDNameList);
                        option2Name = Namer.nameFromNameList(currentSDNameList);
                        option3Name = Namer.nameFromNameList(currentSDNameList);
                        option4Name = Namer.nameFromNameList(currentSDNameList);
                        option5Name = Namer.nameFromNameList(currentSDNameList);

                        firstSDNameTV.setText(option1Name.getName());
                        firstSdDescTV.setText(option1Name.getMeaning());
                        secondSDNameTV.setText(option2Name.getName());
                        secondSdDescTV.setText(option2Name.getMeaning());
                        thirdSDNameTV.setText(option3Name.getName());
                        thirdSdDescTV.setText(option3Name.getMeaning());
                        fourthSDNameTV.setText(option4Name.getName());
                        fourthSdDescTv.setText(option4Name.getMeaning());
                        fifthSDNameTV.setText(option5Name.getName());
                        fifthSdDescTV.setText(option5Name.getMeaning());

                        break;

                }
            }
        });

        //a name is already loaded at startup
        stringSDNameList = Namer.myListAssetReader(ShowdownActivity.this, getString(R.string.allfemale));
        currentSDNameList = Namer.nameLister(stringSDNameList);

        option1Name = Namer.nameFromNameList(currentSDNameList);
        option2Name = Namer.nameFromNameList(currentSDNameList);
        option3Name = Namer.nameFromNameList(currentSDNameList);
        option4Name = Namer.nameFromNameList(currentSDNameList);
        option5Name = Namer.nameFromNameList(currentSDNameList);

        firstSDNameTV.setText(option1Name.getName());
        firstSdDescTV.setText(option1Name.getMeaning());
        secondSDNameTV.setText(option2Name.getName());
        secondSdDescTV.setText(option2Name.getMeaning());
        thirdSDNameTV.setText(option3Name.getName());
        thirdSdDescTV.setText(option3Name.getMeaning());
        fourthSDNameTV.setText(option4Name.getName());
        fourthSdDescTv.setText(option4Name.getMeaning());
        fifthSDNameTV.setText(option5Name.getName());
        fifthSdDescTV.setText(option5Name.getMeaning());




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

    void playAgain(){
        firstSDNameTV.setTextColor(getResources().getColor(R.color.textRedColor));
        firstSDNameTV.setTextSize(30);
        secondSDNameTV.setTextColor(getResources().getColor(R.color.textRedColor));
        secondSDNameTV.setTextSize(30);
        thirdSDNameTV.setTextColor(getResources().getColor(R.color.textRedColor));
        thirdSDNameTV.setTextSize(30);
        fourthSDNameTV.setTextColor(getResources().getColor(R.color.textRedColor));
        fourthSDNameTV.setTextSize(30);
        fifthSDNameTV.setTextColor(getResources().getColor(R.color.textRedColor));
        fifthSDNameTV.setTextSize(30);
        selectedNames.clear();
        chosenWinner = false;
    }

}
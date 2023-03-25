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

public class ListActivity extends AppCompatActivity {

    private Button frenchFem;
    private Button frenchMasc;
    private Button englishFem;
    private Button englishMasc;
    private Button germanFem;
    private Button germanMasc;
    private Button greekFem;
    private Button greekMasc;
    private Button hebrewFem;
    private Button hebrewMasc;
    private Button irishFem;
    private Button irishMasc;
    private Button italianFem;
    private Button italianMasc;
    private Button latinFem;
    private Button latinMasc;
    private Button middleeastFem;
    private Button middleeastMasc;
    private Button oldenglishFem;
    private Button oldenglishMasc;
    private Button oldgermanFem;
    private Button oldgermanMasc;
    private Button welshFem;
    private Button welshMasc;



    private Toolbar listActToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listActToolbar = findViewById(R.id.listActToolbar);
        setSupportActionBar(listActToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.origins);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                listActToolbar.setTitleTextColor(getResources().getColor(R.color.textRedColor));
            }
        }

        frenchFem = findViewById(R.id.frenchFemListBtn);
        Effect.buttonEffect(frenchFem);
        frenchFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.frenchf));
                intent.putExtra("chosen list name", getString(R.string.girl_french));
                startActivity(intent);
            }
        });

        frenchMasc = findViewById(R.id.frenchMascListBtn);
        Effect.buttonEffect(frenchMasc);
        frenchMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.frenchm));
                intent.putExtra("chosen list name", getString(R.string.boy_french));
                startActivity(intent);
            }
        });

        italianFem = findViewById(R.id.italianFemListBtn);
        Effect.buttonEffect(italianFem);
        italianFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.italianf));
                intent.putExtra("chosen list name", getString(R.string.girl_italian));
                startActivity(intent);
            }
        });

        italianMasc = findViewById(R.id.italianMascListBtn);
        Effect.buttonEffect(italianMasc);
        italianMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.italianm));
                intent.putExtra("chosen list name", getString(R.string.boy_italian));
                startActivity(intent);
            }
        });

        latinFem = findViewById(R.id.latinFemListBtn);
        Effect.buttonEffect(latinFem);
        latinFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.latinf));
                intent.putExtra("chosen list name", getString(R.string.girl_latin));
                startActivity(intent);
            }
        });

        latinMasc = findViewById(R.id.latinMascListBtn);
        Effect.buttonEffect(latinMasc);
        latinMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.latinm));
                intent.putExtra("chosen list name", getString(R.string.boy_latin));
                startActivity(intent);
            }
        });

        hebrewFem = findViewById(R.id.hebrewFemListBtn);
        Effect.buttonEffect(hebrewFem);
        hebrewFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.hebrewf));
                intent.putExtra("chosen list name", getString(R.string.girl_hebrew));
                startActivity(intent);
            }
        });

        hebrewMasc = findViewById(R.id.hebrewMascListBtn);
        Effect.buttonEffect(hebrewMasc);
        hebrewMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.hebrewm));
                intent.putExtra("chosen list name", getString(R.string.boy_hebrew));
                startActivity(intent);
            }
        });

        irishFem = findViewById(R.id.irishFemListBtn);
        Effect.buttonEffect(irishFem);
        irishFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.irishf));
                intent.putExtra("chosen list name", getString(R.string.girl_irish));
                startActivity(intent);
            }
        });

        irishMasc = findViewById(R.id.irishMascListBtn);
        Effect.buttonEffect(irishMasc);
        irishMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.irishm));
                intent.putExtra("chosen list name", getString(R.string.boy_irish));
                startActivity(intent);
            }
        });

        englishFem = findViewById(R.id.englishFemListBtn);
        Effect.buttonEffect(englishFem);
        englishFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.englishf));
                intent.putExtra("chosen list name", getString(R.string.girl_english));
                startActivity(intent);
            }
        });

        englishMasc = findViewById(R.id.englishMascListBtn);
        Effect.buttonEffect(englishMasc);
        englishMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.englishm));
                intent.putExtra("chosen list name", getString(R.string.boy_english));
                startActivity(intent);
            }
        });

        germanFem = findViewById(R.id.germanFemListBtn);
        Effect.buttonEffect(germanFem);
        germanFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.germanf));
                intent.putExtra("chosen list name", getString(R.string.girl_german));
                startActivity(intent);
            }
        });

        germanMasc = findViewById(R.id.germanMascListBtn);
        Effect.buttonEffect(germanMasc);
        germanMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.germanm));
                intent.putExtra("chosen list name", getString(R.string.boy_german));
                startActivity(intent);
            }
        });

        greekFem = findViewById(R.id.greekFemListBtn);
        Effect.buttonEffect(greekFem);
        greekFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.greekf));
                intent.putExtra("chosen list name", getString(R.string.girl_greek));
                startActivity(intent);
            }
        });

        greekMasc = findViewById(R.id.greekMascListBtn);
        Effect.buttonEffect(greekMasc);
        greekMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.greekm));
                intent.putExtra("chosen list name", getString(R.string.boy_greek));
                startActivity(intent);
            }
        });

        middleeastFem = findViewById(R.id.middleEastFemListBtn);
        Effect.buttonEffect(middleeastFem);
        middleeastFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.middleeastf));
                intent.putExtra("chosen list name", getString(R.string.girl_middleast));
                startActivity(intent);
            }
        });

        middleeastMasc = findViewById(R.id.middleEastMascListBtn);
        Effect.buttonEffect(middleeastMasc);
        middleeastMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.middleeastm));
                intent.putExtra("chosen list name", getString(R.string.boy_middleeast));
                startActivity(intent);
            }
        });

        oldenglishFem = findViewById(R.id.oldEnglishFemListBtn);
        Effect.buttonEffect(oldenglishFem);
        oldenglishFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.oldenglishf));
                intent.putExtra("chosen list name", getString(R.string.girl_oldenglish));
                startActivity(intent);
            }
        });

        oldenglishMasc = findViewById(R.id.oldEnglishMascListBtn);
        Effect.buttonEffect(oldenglishMasc);
        oldenglishMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.oldenglishm));
                intent.putExtra("chosen list name", getString(R.string.boy_oldenglish));
                startActivity(intent);
            }
        });

        oldgermanFem = findViewById(R.id.oldGermanFemListBtn);
        Effect.buttonEffect(oldgermanFem);
        oldgermanFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.oldgermanf));
                intent.putExtra("chosen list name", getString(R.string.girl_oldgerman));
                startActivity(intent);
            }
        });

        oldgermanMasc = findViewById(R.id.oldGermanMascListBtn);
        Effect.buttonEffect(oldgermanMasc);
        oldgermanMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.oldgermanm));
                intent.putExtra("chosen list name", getString(R.string.boy_oldgerman));
                startActivity(intent);
            }
        });

        welshFem = findViewById(R.id.welshFemListBtn);
        Effect.buttonEffect(welshFem);
        welshFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.welshf));
                intent.putExtra("chosen list name", getString(R.string.girl_welsh));
                startActivity(intent);
            }
        });

        welshMasc = findViewById(R.id.welshMascListBtn);
        Effect.buttonEffect(welshMasc);
        welshMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ChosenListActivity.class);
                intent.putExtra("dieList", getString(R.string.welshm));
                intent.putExtra("chosen list name", getString(R.string.boy_welsh));
                startActivity(intent);
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
}
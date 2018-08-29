package com.example.danie.testappusingjava;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;
//import com.example.danie.parseJSON.parseJSON;

//https://code.tutsplus.com/tutorials/how-to-code-a-bottom-navigation-bar-for-an-android-app--cms-30305
//used to make bottom navigation
public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ActionBar toolbar;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        parseJSON.parse();

        btn = (Button) findViewById(R.id.button_quiz);

        //OnClickListener for when user taps the button
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openTriviaActivity();
            }
        });

        toolbar = getSupportActionBar();
        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.navigationView);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.d(TAG, menuItem.getTitle()+" has been selected.");
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        selectedFragment = BlankFragment.newInstance();
                        break;
                    case R.id.navigation_quiz:
                        selectedFragment = QuizFragment.newInstance();
                        break;
                    case R.id.navigation_account:
                        selectedFragment = AccountFragment.newInstance();
                        break;

                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.commit();
                return true;
            }

        });

    }

    //method to lead to trivia activity
    public void openTriviaActivity(){
        Intent in = new Intent (this, Trivia.class); //must create an Intent object
        startActivity(in); //pass the Intent object into the startActivity(Intent) class in order to actually start the activity
    }






}



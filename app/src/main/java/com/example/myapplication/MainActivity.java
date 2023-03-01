package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private static final String TAG = "MainActivityLog";

    private int onCreateCounter = 0;
    private int onStartCounter = 0;
    private int onResumeCounter = 0;
    private int onPauseCounter = 0;
    private int onStopCounter = 0;
    private int onDestroyCounter = 0;
    private int onRestartCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Toast.makeText(getApplicationContext(), "Create the first activity.", Toast.LENGTH_SHORT)
                .show();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        onCreateCounter = onCreateCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView1);
        String temp = String.valueOf(onCreateCounter);
        StringBuffer temp1 = new StringBuffer("OnCreate: " + temp);
        displayCounter.setText(temp1);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Message icon");
                Snackbar.make(view, "Good Morning!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

        onStartCounter = onStartCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView2);
        String temp = String.valueOf(onStartCounter);
        StringBuffer temp1 = new StringBuffer("OnStart: " + temp);
        displayCounter.setText(temp1);

        Toast.makeText(getApplicationContext(), "Start the first activity.", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d(TAG, "onResume");

        onResumeCounter = onResumeCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView3);
        String temp = String.valueOf(onResumeCounter);
        StringBuffer temp1 = new StringBuffer("OnResume: " + temp);
        displayCounter.setText(temp1);

        Toast.makeText(getApplicationContext(), "Resume the first activity.", Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d(TAG, "onPause");

        onPauseCounter = onPauseCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView4);
        String temp = String.valueOf(onPauseCounter);
        StringBuffer temp1 = new StringBuffer("OnPause: " + temp);
        displayCounter.setText(temp1);

        Toast.makeText(getApplicationContext(), "Pause the first activity.", Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

        onStopCounter = onStopCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView5);
        String temp = String.valueOf(onStopCounter);
        StringBuffer temp1 = new StringBuffer("OnStop: " + temp);
        displayCounter.setText(temp1);

        Toast.makeText(getApplicationContext(), "Stop the first activity.", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

        onCreateCounter = 0;
        onStartCounter = 0;
        onResumeCounter = 0;
        onPauseCounter = 0;
        onStopCounter = 0;
        onRestartCounter = 0;

        onDestroyCounter = onDestroyCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView7);
        String temp = String.valueOf(onDestroyCounter);
        StringBuffer temp1 = new StringBuffer("OnDestroy: " + temp);
        displayCounter.setText(temp1);

        Toast.makeText(getApplicationContext(), "Destroy the first activity.", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

        onRestartCounter = onRestartCounter + 1;
        TextView displayCounter = findViewById(R.id.TextView6);
        String temp = String.valueOf(onRestartCounter);
        StringBuffer temp1 = new StringBuffer("OnRestart: " + temp);
        displayCounter.setText(temp1);

        Toast.makeText(getApplicationContext(), "Restart the first activity.", Toast.LENGTH_SHORT)
                .show();

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
        if (id == R.id.action_share) {
            Toast.makeText(getApplicationContext(), "You click share", Toast.LENGTH_SHORT)
                    .show();
        }else if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "You click settings", Toast.LENGTH_SHORT)
                    .show();
        }else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "You click search", Toast.LENGTH_SHORT)
                   .show();
            Intent mIntent = new Intent(this, MainActivity2.class);
            startActivity(mIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "Going up a level from arrow on header bar");
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
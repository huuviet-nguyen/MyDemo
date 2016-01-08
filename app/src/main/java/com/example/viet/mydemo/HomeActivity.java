package com.example.viet.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    private Button buttonCommencer;
    private EditText prenom;
    private EditText nombreQuestion;
    String TAG_PRENOM = "prenom";
    String TAG_NOMBRE = "nombre";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        buttonCommencer = (Button) findViewById(R.id.bCommencer);
        prenom = (EditText) findViewById(R.id.prenom);
        nombreQuestion = (EditText) findViewById(R.id.nombreQuestion);
        buttonCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void startMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        String prenomUser = prenom.getText().toString();
        String NombreQuestion = nombreQuestion.getText().toString();
        i.putExtra(TAG_PRENOM,prenomUser);
        i.putExtra(TAG_NOMBRE,NombreQuestion);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

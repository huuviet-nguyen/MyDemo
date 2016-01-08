package com.example.viet.mydemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements CalculFragment.transferDatafromFragmenttoActivity {
    int numberQuestion = 10;
    int numberBonReponse = 0;
    String TAG_PRENOM = "prenom";
    String TAG_NOMBRE = "nombre";
    String TAG_BON_REPONSE = "bonreponse";
    String prenom;
    int i = 1;
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prenom = getIntent().getStringExtra(TAG_PRENOM);
        numberQuestion = Integer.parseInt(getIntent().getStringExtra(TAG_NOMBRE));
        fragmentTransaction = fragmentManager.beginTransaction();
        final CalculFragment calculFragment = new CalculFragment();
        fragmentTransaction.add(R.id.containe, calculFragment, "firstFragment");
        fragmentTransaction.commit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void transferData(Boolean data) {
        if (data == true) {
            numberBonReponse++;
        }
        getFragmentManager().popBackStack();
        remplaceCalculFragment();
    }

    public void remplaceCalculFragment() {
        fragmentTransaction = getFragmentManager().beginTransaction();
        if (i < numberQuestion) {
            CalculFragment calculFragment = new CalculFragment();
            fragmentTransaction.replace(R.id.containe, calculFragment);
            fragmentTransaction.commit();
        } else {
            remplaceResultatFragment();
        }
        i++;
    }
    public void remplaceResultatFragment() {
        ResultatFragment resultatFragment = new ResultatFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TAG_BON_REPONSE, numberBonReponse);
        bundle.putString(TAG_PRENOM, prenom);
        bundle.putInt(TAG_NOMBRE,numberQuestion);
        resultatFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.containe, resultatFragment);
        fragmentTransaction.commit();
    }
}

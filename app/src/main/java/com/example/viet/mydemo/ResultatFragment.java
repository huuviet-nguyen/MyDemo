package com.example.viet.mydemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by viet on 08/01/2016.
 */
public class ResultatFragment extends Fragment {
    TextView res;
    Button finish;
    String TAG_PRENOM = "prenom";
    String TAG_NOMBRE = "nombre";
    String TAG_BON_REPONSE = "bonreponse";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int BonResponse = getArguments().getInt(TAG_BON_REPONSE);
        int nombre = getArguments().getInt(TAG_NOMBRE);
        String prenom = getArguments().getString(TAG_PRENOM);
        final View view = inflater.inflate(R.layout.fragment_resultat, container, false);
        res = (TextView) view.findViewById(R.id.numResultat);
        res.setText( prenom+" !!!, Vous avez " +String.valueOf(BonResponse) + " sur " + nombre + " reponses corrects !!!");
        finish = (Button) view.findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
}

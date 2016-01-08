package com.example.viet.mydemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class CalculFragment extends Fragment {
    final int MAX = 100;
    TextView equation;
    EditText resultat;
    boolean isGoodReponse = false;
    int result;
    String[] operationString = {"+","-"};
    public interface transferDatafromFragmenttoActivity {
        public void transferData(Boolean data);
    }
    transferDatafromFragmenttoActivity mData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calcul, container, false);
        equation = (TextView) view.findViewById(R.id.equation);
        resultat = (EditText) view.findViewById(R.id.result);
        gerererCalcul(equation);
        resultat.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (resultat.getText().toString().equals(String.valueOf(result))){
                        isGoodReponse = true;
                    }
                    passDatatoActivity(isGoodReponse);
                }
                return false;
            }
        });
        return view;
    }

    public void gerererCalcul(TextView textview) {
        Random rand = new Random();
        int number1 = rand.nextInt(MAX)+1;
        int number2 = rand.nextInt(MAX)+1;
        String operator = operationString[rand.nextInt(operationString.length)];
        if (operator.equals("+")) {
            result = number1 + number2;
        }
        if (operator.equals("-")) {
            while (number1 < number2) {
                number1 = rand.nextInt(MAX)+1;
            }
            result = number1 - number2;
        }
        textview.setText(String.valueOf(number1) + "  " + operator + "  " + String.valueOf(number2) + " = ");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mData = (transferDatafromFragmenttoActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public void passDatatoActivity(Boolean data) {
        mData.transferData(data);
    }

}

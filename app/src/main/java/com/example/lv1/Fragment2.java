package com.example.lv1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class Fragment2 extends Fragment {

    private Button oBtnPredmet;
    private TextInputEditText oPredmet;
    private TextInputEditText oProfesor;
    private TextInputEditText oGodina;
    private TextInputEditText oPredavanja;
    private String sPredmet;
    private String sIme;
    private String sPrezime;
    private String sDatum;
    private String sProfesor;
    private String sGodina;
    private String sPredavanja;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_student_info, container, false);

        oBtnPredmet = v.findViewById(R.id.button2);
        oPredmet = v.findViewById(R.id.text2);
        oProfesor = v.findViewById(R.id.profesor);
        oGodina = v.findViewById(R.id.godina);
        oPredavanja = v.findViewById(R.id.predavanja);
        oBtnPredmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPredmet = oPredmet.getText().toString();
                sProfesor = oProfesor.getText().toString();
                sGodina = oGodina.getText().toString();
                sPredavanja = oPredavanja.getText().toString();

                SharedPreferences sharedpreferences;
                sharedpreferences = getContext().getSharedPreferences("podatci", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("predmet", sPredmet);
                editor.putString("profesor", sProfesor);
                editor.putString("godina", sGodina);
                editor.putString("predavanja", sPredavanja);
                editor.commit();

            }
        });
        // Inflate the layout for this fragment
        return v;
    }
}
package com.example.lv1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class Fragment3 extends Fragment {

    private String sPredmet;
    private String sIme;
    private String sPrezime;
    private String sDatum;
    private String sProfesor;
    private String sGodina;
    private String sPredavanja;
    private Button oBtnNatrag;
    private TextView oTextIme;
    private TextView oTextDatum;
    private TextView oTextPredmet;
    private TextView oTextProfesor;
    private TextView oTextGodina;
    private TextView oTextPredavanja;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_summary, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("podatci", MODE_PRIVATE);
        String restoredText = prefs.getString("TAG_NAME", null);

        sIme = prefs.getString("ime", null);
        sPrezime = prefs.getString("prezime", null);
        sDatum = prefs.getString("datum", null);
        sPredmet = prefs.getString("predmet", null);
        sProfesor = prefs.getString("profesor", null);
        sGodina = prefs.getString("godina", null);
        sPredavanja = prefs.getString("predavanja", null);

        oTextIme = v.findViewById(R.id.textView);
        oTextPredmet = v.findViewById(R.id.textView2);
        oBtnNatrag = v.findViewById(R.id.button3);
        oTextDatum = v.findViewById(R.id.textView5);
        oTextProfesor = v.findViewById(R.id.textView6);
        oTextGodina = v.findViewById(R.id.textView7);
        oTextPredavanja = v.findViewById(R.id.textView8);

        Student student = new Student(sIme,sPrezime,sDatum,sPredmet,sPredavanja,sGodina ,sProfesor);
        MyDataStorage.getInstance().addStudent(student);
        oTextIme.setText(sIme + " " + sPrezime);
        oTextPredmet.setText(sPredmet);
        oTextDatum.setText(sDatum);
        oTextPredavanja.setText(sPredavanja);
        oTextGodina.setText(sGodina);
        oTextProfesor.setText(sProfesor);
        oBtnNatrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), HomeActivity.class));
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
}
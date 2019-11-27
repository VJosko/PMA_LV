package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatum = oExtras.getString("datum");
        sPredmet = oExtras.getString("predmet");
        sProfesor = oExtras.getString("profesor");
        sGodina = oExtras.getString("godina");
        sPredavanja = oExtras.getString("predavanja");

        oTextIme = findViewById(R.id.textView);
        oTextPredmet = findViewById(R.id.textView2);
        oBtnNatrag = findViewById(R.id.button3);
        oTextDatum = findViewById(R.id.textView5);
        oTextProfesor = findViewById(R.id.textView6);
        oTextGodina = findViewById(R.id.textView7);
        oTextPredavanja = findViewById(R.id.textView8);

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
                startActivity(new Intent(SummaryActivity.this, HomeActivity.class));
            }
        });
    }
}

package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class StudentInfoActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatum = oExtras.getString("datum");

        oBtnPredmet = findViewById(R.id.button2);
        oPredmet = findViewById(R.id.text2);
        oProfesor = findViewById(R.id.profesor);
        oGodina = findViewById(R.id.godina);
        oPredavanja = findViewById(R.id.predavanja);
        oBtnPredmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPredmet = oPredmet.getText().toString();
                sProfesor = oProfesor.getText().toString();
                sGodina = oGodina.getText().toString();
                sPredavanja = oPredavanja.getText().toString();

                Intent prosljediPredmet = new Intent(getApplicationContext(), SummaryActivity.class);
                prosljediPredmet.putExtra("ime", sIme);
                prosljediPredmet.putExtra("prezime", sPrezime);
                prosljediPredmet.putExtra("datum", sDatum);
                prosljediPredmet.putExtra("predmet", sPredmet);
                prosljediPredmet.putExtra("profesor", sProfesor);
                prosljediPredmet.putExtra("godina", sGodina);
                prosljediPredmet.putExtra("predavanja", sPredavanja);
                startActivity(prosljediPredmet);
            }
        });

    }
}

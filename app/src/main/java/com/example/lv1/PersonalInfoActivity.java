package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class PersonalInfoActivity extends AppCompatActivity {

    private Button oBtnIme;
    private TextInputEditText oIme;
    private TextInputEditText oPrezime;
    private EditText datum;
    private String sIme;
    private String sPrezime;
    private String sDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        oBtnIme = findViewById(R.id.button);
        oIme = findViewById(R.id.ime);
        oPrezime = findViewById(R.id.prezime);
        datum = findViewById(R.id.datum);
        oBtnIme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sIme = oIme.getText().toString();
                sPrezime = oPrezime.getText().toString();
                sDatum = datum.getText().toString();
                Intent prosljediIme = new Intent(getApplicationContext(), StudentInfoActivity.class);
                prosljediIme.putExtra("ime", sIme);
                prosljediIme.putExtra("prezime", sPrezime);
                prosljediIme.putExtra("datum", sDatum);
                startActivity(prosljediIme);
            }
        });


    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }
}

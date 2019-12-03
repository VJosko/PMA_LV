package com.example.lv1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import static android.app.Activity.RESULT_OK;

public class Fragment1 extends Fragment {

    private ImageView oSlika;
    private Button oBtnIme;
    private TextInputEditText oIme;
    private TextInputEditText oPrezime;
    private EditText datum;
    private String sIme;
    private String sPrezime;
    private String sDatum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_personal_info, container, false);
        oSlika = v.findViewById(R.id.slika);
        oBtnIme = v.findViewById(R.id.button);
        oIme = v.findViewById(R.id.ime);
        oPrezime = v.findViewById(R.id.prezime);
        datum = v.findViewById(R.id.datum);
        oBtnIme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sIme = oIme.getText().toString();
                sPrezime = oPrezime.getText().toString();
                sDatum = datum.getText().toString();
                SharedPreferences sharedpreferences;
                sharedpreferences = getContext().getSharedPreferences("podatci", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("ime", sIme);
                editor.putString("prezime", sPrezime);
                editor.putString("datum", sDatum);
                editor.commit();

            }
        });

        oSlika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            oSlika.setImageBitmap(imageBitmap);
        }
    }
}
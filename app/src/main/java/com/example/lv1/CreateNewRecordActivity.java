package com.example.lv1;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNewRecordActivity extends AppCompatActivity{
    private Fragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        fragment1 = new Fragment1();

        getSupportFragmentManager().beginTransaction().replace(R.id.fL, fragment1).commit();
    }
}


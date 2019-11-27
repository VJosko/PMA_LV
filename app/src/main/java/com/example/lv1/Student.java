package com.example.lv1;

import android.widget.TextView;

public class Student {
    String ime;
    String prezime;
    String datum;
    String predmet;
    String profesor;
    String godina;
    String predavanja;

    public Student(String Ime,String Prezime,String Datum,String Predmet,String Profesor,String Godina,String Predavanje){
        ime = Ime;
        prezime = Prezime;
        datum = Datum;
        predmet = Predmet;
        profesor = Profesor;
        godina = Godina;
        predavanja = Predavanje;
    }

}

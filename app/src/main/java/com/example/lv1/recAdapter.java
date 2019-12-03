package com.example.lv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recAdapter extends RecyclerView.Adapter<recAdapter.MyViewHolder> {
    private List<Student> students = MyDataStorage.getInstance().readStudents();
    private List<Object> holderi;
    private String title = "Studenti";

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewIme;
        public TextView textViewPrezime;
        public TextView textViewPredmet;
        public MyViewHolder(View v){
            super(v);
            textViewIme = v.findViewById(R.id.recIme);
            textViewPrezime = v.findViewById(R.id.recPrezime);
            textViewPredmet = v.findViewById(R.id.recPredmet);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        public TextView naslov;
        public HeaderViewHolder(View header){
            super(header);
            naslov = header.findViewById(R.id.recNaslov);
        }
    }

    public recAdapter(){
    }

    @NonNull
    @Override
    public recAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.v, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull recAdapter.MyViewHolder holder, int position) {
            holder.textViewIme.setText(students.get(position).ime);
            holder.textViewPrezime.setText(students.get(position).prezime);
            holder.textViewPredmet.setText(students.get(position).predmet);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}

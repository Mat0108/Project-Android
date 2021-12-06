package com.example.projectandroidtest;

import android.util.Log;

import androidx.core.math.MathUtils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Matiere {
    public long francais;
    public long maths;
    public long physique;
    public long chemie;
    public long histoire;
    public long geographie;
    public long anglais;
    public long espagnol;
    public long allemand;

    public Matiere(long francais, long maths, long physique, long chemie, long histoire, long geographie, long anglais, long espagnol, long allemand) {
        this.francais = francais;
        this.maths = maths;
        this.physique = physique;
        this.chemie = chemie;
        this.histoire = histoire;
        this.geographie = geographie;
        this.anglais = anglais;
        this.espagnol = espagnol;
        this.allemand = allemand;
    }
    public Matiere(){}
    public long getFrancais() {return francais;}
    public void setFrancais(long francais) {this.francais = francais;}
    public long getMaths() {return maths;}
    public void setMaths(long maths) {this.maths = maths;}
    public long getPhysique() {return physique;}
    public void setPhysique(long physique) {this.physique = physique;}
    public long getChemie() {return chemie;}
    public void setChemie(long chemie) {this.chemie = chemie;}
    public long getHistoire() {return histoire;}
    public void setHistoire(long histoire) {this.histoire = histoire;}
    public long getGeographie() {return geographie;}
    public void setGeographie(long geographie) {this.geographie = geographie;}
    public long getAnglais() {return anglais;}
    public void setAnglais(long anglais) {this.anglais = anglais;}
    public long getEspagnol() {return espagnol;}
    public void setEspagnol(long espagnol) {this.espagnol = espagnol;}
    public long getAllemand() {return allemand; }
    public void setAllemand(long allemand) {this.allemand = allemand;}
    public void setAll(long francais, long maths, long physique, long chemie, long histoire, long geographie, long anglais, long espagnol, long allemand) {
        this.francais = francais;
        this.maths = maths;
        this.physique = physique;
        this.chemie = chemie;
        this.histoire = histoire;
        this.geographie = geographie;
        this.anglais = anglais;
        this.espagnol = espagnol;
        this.allemand = allemand;
    }
    public void setAll2(Matiere matiere){
        this.francais = matiere.getFrancais();
        this.maths = matiere.getMaths();
        this.physique = matiere.getPhysique();
        this.chemie = matiere.getChemie();
        this.histoire = matiere.getHistoire();
        this.geographie = matiere.getGeographie();
        this.anglais = matiere.getAnglais();
        this.espagnol = matiere.getEspagnol();
        this.allemand = matiere.getAllemand();
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "francais=" + francais +
                ", maths=" + maths +
                ", physique=" + physique +
                ", chemie=" + chemie +
                ", histoire=" + histoire +
                ", geographie=" + geographie +
                ", anglais=" + anglais +
                ", espagnol=" + espagnol +
                ", allemand=" + allemand +
                '}';
    }

    public ArrayList<Matiere> MatiereTab(){
        ArrayList<Matiere> matieres = new ArrayList<Matiere>();
        Matiere matiere = new Matiere(0L,0L,0L,0L,0L,0L,0L,0L,0L);
        DatabaseReference matieresRef = FirebaseDatabase.getInstance().getReference().child("matieres");
        ValueEventListener matieresEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {


                }
                for (Matiere matiere2 : matieres) {
                    Log.d("initDataset",matiere2.toString());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        matieresRef.addListenerForSingleValueEvent(matieresEvent);
        return (matieres);
    }
}

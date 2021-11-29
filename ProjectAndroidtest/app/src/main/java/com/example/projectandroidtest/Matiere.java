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
    public int francais;
    public int maths;
    public int physique;
    public int chemie;
    public int histoire;
    public int geographie;
    public int anglais;
    public int espagnol;
    public int allemand;

    public Matiere(int francais, int maths, int physique, int chemie, int histoire, int geographie, int anglais, int espagnol, int allemand) {
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
    public int getFrancais() {return francais;}
    public void setFrancais(int francais) {this.francais = francais;}
    public int getMaths() {return maths;}
    public void setMaths(int maths) {this.maths = maths;}
    public int getPhysique() {return physique;}
    public void setPhysique(int physique) {this.physique = physique;}
    public int getChemie() {return chemie;}
    public void setChemie(int chemie) {this.chemie = chemie;}
    public int getHistoire() {return histoire;}
    public void setHistoire(int histoire) {this.histoire = histoire;}
    public int getGeographie() {return geographie;}
    public void setGeographie(int geographie) {this.geographie = geographie;}
    public int getAnglais() {return anglais;}
    public void setAnglais(int anglais) {this.anglais = anglais;}
    public int getEspagnol() {return espagnol;}
    public void setEspagnol(int espagnol) {this.espagnol = espagnol;}
    public int getAllemand() {return allemand; }
    public void setAllemand(int allemand) {this.allemand = allemand;}
    public void setAll(int francais, int maths, int physique, int chemie, int histoire, int geographie, int anglais, int espagnol, int allemand) {
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
        Matiere matiere = new Matiere(0,0,0,0,0,0,0,0,0);
        DatabaseReference matieresRef = FirebaseDatabase.getInstance().getReference().child("matieres");
        ValueEventListener matieresEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    try{matiere.setFrancais(ds.child("francais").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setFrancais(0);}

                    try{matiere.setMaths(ds.child("maths").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setMaths(0);}

                    try{matiere.setPhysique(ds.child("physique").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setPhysique(0);}

                    try{matiere.setChemie(ds.child("chemie").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setChemie(0);}

                    try{matiere.setHistoire(ds.child("histoire").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setHistoire(0);}

                    try{matiere.setGeographie(ds.child("geographie").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setGeographie(0);}

                    try{matiere.setAnglais(ds.child("anglais").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setAnglais(0);}

                    try{matiere.setEspagnol(ds.child("espagnol").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setEspagnol(0);}

                    try{matiere.setAllemand(ds.child("allemand").getValue(Long.class).intValue());
                    }catch (Exception e){matiere.setAllemand(0);}

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

package com.example.projectandroidtest;

import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String Mail;
    private String Nom;
    private String Adresse;
    public User(String mail,  String nom, String adresse) {
        Mail = mail;
        Nom = nom;
        Adresse = adresse;
    }
    public User(){

    }
    public void setAll(String mail,String nom,String adresse){
        Mail = mail;
        Nom = nom;
        Adresse = adresse;
    }
    public String getMail() {return Mail;}
    public void setMail(String mail) {Mail = mail;}
    public String getNom() {return Nom;}
    public void setNom(String nom) {Nom = nom;}
    public String getAdresse() {return Adresse;}
    public void setAdresse(String adresse) {Adresse = adresse; }

    @Override
    public String toString() {
        return "User{" +
                "Mail='" + Mail + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Adresse='" + Adresse + '\'' +
                '}';
    }


    public boolean compare(User user) {
        if (Mail.equals(user.getMail()) && Nom.equals(user.getNom()) && Adresse.equals(user.getAdresse())) {
            return true;
        } else {
            return false;
        }
    }
}

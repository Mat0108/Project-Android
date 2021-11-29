package com.example.projectandroidtest;

import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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
    public ArrayList<User> UserTab(){
        ArrayList<User> users = new ArrayList<User>(20);
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");
        ValueEventListener userEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("nom").getValue(String.class);
                    String mail = ds.child("mail").getValue(String.class);
                    String adresse = ds.child("adresse").getValue(String.class);
                    User user = new User(mail,name,adresse);
                    users.add(user);
                    Log.d("test",user.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        for (User user : users) {
            Log.d("initDataset",user.toString());
        }
        usersRef.addListenerForSingleValueEvent(userEvent);
        return users;
    }
}

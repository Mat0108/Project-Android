package com.example.projectandroidtest;

import android.provider.ContactsContract;

public class User {
    private String Mail;
    private String Password;
    private String Nom;
    private String Adresse;
    public User(String mail, String password, String nom, String adresse) {
        Mail = mail;
        Password = password;
        Nom = nom;
        Adresse = adresse;
    }
    public User(){

    }
    public void setAll(String mail,String password,String nom,String adresse){
        Mail = mail;
        Password = password;
        Nom = nom;
        Adresse = adresse;
    }
    public String getMail() {return Mail;}
    public void setMail(String mail) {Mail = mail;}
    public String getPassword() {return Password;}
    public void setPassword(String password) {Password = password;}
    public String getNom() {return Nom;}
    public void setNom(String nom) {Nom = nom;}
    public String getAdresse() {return Adresse;}
    public void setAdresse(String adresse) {Adresse = adresse; }
}

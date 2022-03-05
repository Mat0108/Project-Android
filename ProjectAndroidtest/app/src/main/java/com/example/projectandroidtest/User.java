package com.example.projectandroidtest;

import android.util.Log;

import java.util.ArrayList;

public class User {
    private String Mail;
    private String Nom;
    private String Adresse;

    private ArrayList<Messages> messages = new ArrayList<Messages>();
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
    public void setAll2(User user){
        Mail = user.getMail();
        Nom = user.getNom();
        Adresse = user.getAdresse();
    }
    public String getMail() {return Mail;}
    public void setMail(String mail) {Mail = mail;}
    public String getNom() {return Nom;}
    public void setNom(String nom) {Nom = nom;}
    public String getAdresse() {return Adresse;}
    public void setAdresse(String adresse) {Adresse = adresse; }
    public void setMessage(ArrayList<Messages> messages) {
        this.messages = messages;
    }
    public void addMessage(Messages text){this.messages.add(text);}
    public ArrayList<Messages> getMessage(){return this.messages;}
    public void printMessage(){
        for (int i = 0; i < this.messages.size(); i++) {
            Log.d("message", messages.get(i).toString());
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "Mail='" + Mail + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Adresse='" + Adresse + '\''+
                '}';
    }


    public boolean compare(User user) {
        if (Mail.equals(user.getMail()) && Nom.equals(user.getNom()) && Adresse.equals(user.getAdresse())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean compareMail(String mail){
        if (Mail.equals(mail)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean compareNom(String nom){
        if (Nom.equals(nom)){
            return true;
        }
        else{
            return false;
        }
    }
    public User ReturnUser(){
        User newuser = new User();
        newuser.setAll2(this);
        return newuser;
    }

}

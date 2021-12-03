package com.example.projectandroidtest;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class BDD {
    private static final String TAG = "BDD";
    protected int lenght;
    protected final int MaxInt = 50;
    private ArrayList<User> users;
    private ArrayList<Matiere> matieres;


    public ArrayList<User> getUsers() {return users; }
    public void setUsers(ArrayList<User> users) {this.users = users;}
    public ArrayList<Matiere> getMatieres() {return matieres;}
    public void setMatieres(ArrayList<Matiere> matieres) {this.matieres = matieres;}



    public BDD(){
        this.users = new ArrayList<User>(MaxInt);
        this.matieres = new ArrayList<Matiere>(MaxInt);
    }

    public void addUsers(User user){
        this.users.add(user);
    }
    public void addMatieres(Matiere matiere) {this.matieres.add(matiere);}
    public ArrayList<String> UsertoString(){
        ArrayList<String> listeuser = new ArrayList<String>();
        for (User user : this.users) {
            listeuser.add(user.getNom());
        }
        return listeuser;
    }
    public ArrayList<String> MatieretoString(){
        ArrayList<String> listematiere= new ArrayList<String>();

        for (Matiere matiere : this.matieres) {
            String text = new String();
            if (matiere.getFrancais() == 2) {text = text+"Francais\n";}
            if (matiere.getMaths() == 2) {text = text+"Maths\n";}
            if (matiere.getPhysique() == 2) {text = text+"Physique\n";}
            if (matiere.getChemie() == 2) {text = text+"Chemie\n";}
            if (matiere.getHistoire() == 2) {text = text+"Histoire\n";}
            if (matiere.getGeographie() == 2) {text = text+"Geographie\n";}
            if (matiere.getAnglais() == 2) {text = text+"Anglais\n";}
            if (matiere.getEspagnol() == 2) {text = text+"Espagnol\n";}
            if (matiere.getAllemand() == 2) {text = text+"Allemand";}
            listematiere.add(text);

        }
        return listematiere;
    }
    public void print(int choix){
        if (choix == 1){
            Log.d("BDD print",String.valueOf(this.users.size()));
        }else {
            for (int i = 0; i < this.users.size(); i++) {
                Log.d("BDD print", this.users.get(i).toString());
                Log.d("BDD print", this.matieres.get(i).toString());
            }
        }
    }
    public void update(BDD bdd){
        this.users = bdd.getUsers();
        this.matieres = bdd.getMatieres();
    }
    public BDD Selected(String matiere){
        BDD bdd = new BDD();
        Log.i("text matiere",matiere);
        for (int i = 0;i<this.users.size();i++) {
            if (matiere == "Francais" && this.matieres.get(i).getFrancais() == 2){
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Maths" && this.matieres.get(i).getMaths() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Physique" && this.matieres.get(i).getPhysique() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Chemie" && this.matieres.get(i).getChemie() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Histoire" && this.matieres.get(i).getHistoire() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Geographie" && this.matieres.get(i).getGeographie() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Anglais" && this.matieres.get(i).getAnglais() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Espagnol" && this.matieres.get(i).getEspagnol() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if (matiere == "Allemand" && this.matieres.get(i).getAllemand() == 2) {
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
            if(matiere == " "){
                bdd.addUsers(this.users.get(i));
                bdd.addMatieres(this.matieres.get(i));
            }
        }
        bdd.print(2);
        return bdd;
    }
}

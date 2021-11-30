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
    public void print(){
        for (int i = 0;i<this.users.size();i++) {
            Log.d("BDD print",this.users.get(i).toString());
            Log.d("BDD print",this.matieres.get(i).toString());
        }
    }
    /*public void UserTab(){
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
                    Log.d("test3 ",String.valueOf(users.size()));

                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        usersRef.addListenerForSingleValueEvent(userEvent);

    }*/
}

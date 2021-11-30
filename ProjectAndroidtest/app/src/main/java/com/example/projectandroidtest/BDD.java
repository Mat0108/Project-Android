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

    private Matiere[] matieres;

    public ArrayList<User> getUsers() {return users; }
    public void setUsers(ArrayList<User> users) {this.users = users;}

    public Matiere[] getMatieres() {return matieres;}
    public void setMatieres(Matiere[] matieres) {this.matieres = matieres; }

    public BDD(){
        this.users = new ArrayList<User>(MaxInt);
        this.matieres = new Matiere[MaxInt];
    }

    public void addUsers(User user){
        this.users.add(user);
    }

    @Override
    public String toString() {
        return "BDD{" +
                "users=" + users +
                '}';
    }

    public void UserTab(){
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");
        ValueEventListener userEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("nom").getValue(String.class);
                    String mail = ds.child("mail").getValue(String.class);
                    String adresse = ds.child("adresse").getValue(String.class);
                    User user = new User(mail,name,adresse);
                    addUsers(user);
                    Log.d("test",user.toString());
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        usersRef.addListenerForSingleValueEvent(userEvent);

    }
}

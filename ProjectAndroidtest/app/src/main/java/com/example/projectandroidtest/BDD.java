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
    protected User[] users;
    protected Matiere[] matieres;
    protected int lenght;

    public int len() {
        lenght = 0;
        DatabaseReference matieresRef = FirebaseDatabase.getInstance().getReference().child("matieres");
        ValueEventListener matieresEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    lenght++;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        return lenght;

    }
    public User[] UserTab(){
        final int[] l = {0};
        users = new User[lenght];
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");
        ValueEventListener userEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("nom").getValue(String.class);
                    String mail = ds.child("mail").getValue(String.class);
                    String adresse = ds.child("adresse").getValue(String.class);
                    User user = new User(mail,name,adresse);
                    users[l[0]] = user;
                    l[0]++;
                    Log.d("test",user.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        usersRef.addListenerForSingleValueEvent(userEvent);
        return users;
    }
}

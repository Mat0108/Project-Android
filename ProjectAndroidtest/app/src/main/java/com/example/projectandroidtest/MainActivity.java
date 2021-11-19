package com.example.projectandroidtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroidtest.recyclerview.RecyclerViewFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private int status;
    public int getStatus() {return status;}
    public void setStatus(int lestatus){status = lestatus;}

    private void updateUI(FirebaseUser user) { }
    private void reload() { }
    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    public class varLayout {
        protected int layout;

        public varLayout(int layout) {
            this.layout = layout;
            setContentView(layout);
        }
        public void setlayout(int lelayout){
            this.layout = lelayout;
            setContentView(lelayout);
        }
        public int getLayout(){
            return this.layout;
        }
        public void signIn(String email, String password) {

            // [START sign_in_with_email]
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                                setlayout(R.layout.recherche);
                                LayoutRecherche();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.d("TAG", "signInWithEmail:failure", task.getException());
                                updateUI(null);

                            }
                        }
                    });
            // [END sign_in_with_email]
        }
        public void LayoutRecherche(){
            if (getLayout() == R.layout.recherche){

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                RecyclerViewFragment fragment = new RecyclerViewFragment();
                transaction.replace(R.id.sample_content_fragment, fragment);
                transaction.commit();

                Button back = (Button)findViewById(R.id.rechercheback);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.connection);
                        LayoutConnection();
                    }
                });
            }
        }
        public void LayoutConnection(){
            if (getLayout() == R.layout.connection){
                EditText Mail = (EditText) findViewById(R.id.connectionmail);
                EditText Password = (EditText) findViewById(R.id.connectionpassword);
                Button connection = (Button) findViewById(R.id.connectionbutton);
                connection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = Mail.getText().toString();
                        String password = Password.getText().toString();
                        if (email.isEmpty() || password.isEmpty()){
                            Toast.makeText(MainActivity.this, "Merci de remplir les zones de textes",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            signIn(email,password);
                        }
                    }

                });
                Button inscription = (Button) findViewById(R.id.inscriptionbutton);
                inscription.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.inscription);
                        LayoutInscription();
                    }
                });

            }

        }
        public void LayoutInscription(){
            if (getLayout() == R.layout.inscription) {

                Button inscription = (Button) findViewById(R.id.inscriptionback2);
                inscription.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //String email = "test@test.com";
                        //String password = "test1234";
                        //createAccount(email,password);
                        setlayout(R.layout.recherche);
                        LayoutRecherche();

                    }
                });
            }
        }

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final varLayout layout;
        layout = new varLayout(R.layout.connection);
        setContentView(layout.getLayout());
        getSupportActionBar().hide();
        layout.LayoutConnection();
        layout.LayoutInscription();
        layout.LayoutRecherche();
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }

    }
}
package com.example.projectandroidtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.renderscript.Allocation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projectandroidtest.recyclerview.RecyclerViewFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabase;
    public Matiere matiere = new Matiere();
    public User user = new User();

    private void updateUI(FirebaseUser user) {
    }

    private void reload() {
    }

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

    public void OnClickMatiere() {

        RadioGroup Fr = (RadioGroup) findViewById(R.id.Fr_Group);

        if (Fr.getCheckedRadioButtonId() == R.id.Fr_R){matiere.setFrancais(1);}
        else if(Fr.getCheckedRadioButtonId()==R.id.Fr_M){matiere.setFrancais(2);}
        else {matiere.setFrancais(0);}

        RadioGroup Maths = (RadioGroup) findViewById(R.id.Mt_Group);
        if (Maths.getCheckedRadioButtonId() == R.id.Mt_R){matiere.setMaths(1);}
        else if(Maths.getCheckedRadioButtonId()==R.id.Mt_M){matiere.setMaths(2);}
        else {matiere.setMaths(0);}

        RadioGroup Physique = (RadioGroup) findViewById(R.id.Ph_group);
        if (Physique.getCheckedRadioButtonId() == R.id.Ph_R){matiere.setPhysique(1);}
        else if(Physique.getCheckedRadioButtonId()==R.id.Ph_M){matiere.setPhysique(2);}
        else {matiere.setPhysique(0);}

        RadioGroup Chemie = (RadioGroup) findViewById(R.id.Ch_group);
        if (Chemie.getCheckedRadioButtonId() == R.id.Ch_R){matiere.setChemie(1);}
        else if(Chemie.getCheckedRadioButtonId()==R.id.Ch_M){matiere.setChemie(2);}
        else {matiere.setChemie(0);}

        RadioGroup Histoire = (RadioGroup) findViewById(R.id.Hi_group);
        if (Histoire.getCheckedRadioButtonId() == R.id.Hi_R){matiere.setHistoire(1);}
        else if(Histoire.getCheckedRadioButtonId()==R.id.Hi_M){matiere.setHistoire(2);}
        else {matiere.setHistoire(0);}

        RadioGroup Geo = (RadioGroup) findViewById(R.id.Ge_Group);
        if (Geo.getCheckedRadioButtonId() == R.id.Ge_R){matiere.setGeographie(1);}
        else if(Geo.getCheckedRadioButtonId()==R.id.Ge_M){matiere.setGeographie(2);}
        else {matiere.setGeographie(0);}

        RadioGroup Anglais = (RadioGroup) findViewById(R.id.An_group);
        if (Anglais.getCheckedRadioButtonId() == R.id.An_R){matiere.setAnglais(1);}
        else if(Anglais.getCheckedRadioButtonId()==R.id.An_M){matiere.setAnglais(2);}
        else {matiere.setAnglais(0);}

        RadioGroup Espagnol = (RadioGroup) findViewById(R.id.Es_group);
        if (Espagnol.getCheckedRadioButtonId() == R.id.Es_R){matiere.setEspagnol(1);}
        else if(Espagnol.getCheckedRadioButtonId()==R.id.Es_M){matiere.setEspagnol(2);}
        else {matiere.setEspagnol(0);}

        RadioGroup Allemand = (RadioGroup) findViewById(R.id.Al_group);
        if (Allemand.getCheckedRadioButtonId() == R.id.Al_R){matiere.setAllemand(1);}
        else if(Allemand.getCheckedRadioButtonId()==R.id.Al_M){matiere.setAllemand(2);}
        else {matiere.setAllemand(0);}
        Log.i("onclick", matiere.toString());
    }
    public void writeUser(String mail,String password,String Nom,String Adresse){
        OnClickMatiere();
        createAccount(mail,password);
        user.setAll(mail,password,Nom,Adresse);

        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("users").child(id).setValue(user);
        mDatabase.child("matiere").child(id).setValue(matiere);


    }
    public class varLayout {
        protected int layout;

        public varLayout(int layout) {
            this.layout = layout;
            setContentView(layout);
        }

        public void setlayout(int lelayout) {
            this.layout = lelayout;
            setContentView(lelayout);
        }

        public int getLayout() {
            return this.layout;
        }
        public int barrebas(){
            Button recherche = (Button) findViewById(R.id.bRecherche);
            Button reglage = (Button) findViewById(R.id.bReglage);
            Button messagerie = (Button) findViewById(R.id.bMessagerie);
            recherche.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setlayout(R.layout.recherche);
                    LayoutRecherche();
                }
            });
            reglage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setlayout(R.layout.matiere);
                    LayoutMatiere();
                }
            });
            messagerie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setlayout(R.layout.recherche);
                    LayoutRecherche();
                }
            });

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

        public void LayoutRecherche() {
            if (getLayout() == R.layout.recherche) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                RecyclerViewFragment fragment = new RecyclerViewFragment();
                transaction.replace(R.id.sample_content_fragment, fragment);
                transaction.commit();

                Button back = (Button) findViewById(R.id.rechercheback);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.connection);
                        LayoutConnection();
                    }
                });
                barrebas();
            }
        }

        public void LayoutConnection() {
            if (getLayout() == R.layout.connection) {
                EditText Mail = (EditText) findViewById(R.id.connectionmail);
                EditText Password = (EditText) findViewById(R.id.connectionpassword);
                Button connection = (Button) findViewById(R.id.connectionbutton);
                connection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = Mail.getText().toString();
                        String password = Password.getText().toString();
                        if (email.isEmpty() || password.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Merci de remplir les zones de textes",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            signIn(email, password);
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

        public void LayoutInscription() {
            if (getLayout() == R.layout.inscription) {

                Button inscription = (Button) findViewById(R.id.inscriptionback2);
                inscription.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //compte test
                        //String email = "test@test.com";
                        //String password = "test1234";

                        setlayout(R.layout.recherche);
                        LayoutRecherche();

                    }
                });
            }
        }
        public void LayoutMatiere(){
            if (getLayout() == R.layout.matiere){
                Button Save = (Button) findViewById(R.id.Save);
                Save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OnClickMatiere();
                        createAccount(user.getMail(),user.getPassword());
                        signIn(user.getMail(),user.getPassword());
                        String id = mAuth.getCurrentUser().getUid();
                        mDatabase.child("users").child(id).setValue(user);
                        mDatabase.child("matieres").child(id).setValue(matiere);
                        */
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
        layout.LayoutMatiere();
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }


    }
}
package com.example.projectandroidtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.projectandroidtest.recyclerview.ItemClickSupport;
import com.example.projectandroidtest.recyclerview.RecyclerViewFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    public Matiere matiere = new Matiere();
    public User user = new User();
    public String pass;
    public BDD bdd = new BDD();
    public User globallastclik = new User("test","test","test");

    public varLayout varLayout;

    public MainActivity.varLayout getVarLayout() {return varLayout;}

    public void setVarLayout(MainActivity.varLayout varLayout) {this.varLayout = varLayout;}

    public Activity activity ;

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

                            FirebaseUser mUser = mAuth.getCurrentUser();
                            updateUI(mUser);


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

        RadioGroup Fr = findViewById(R.id.Fr_Group);

        if (Fr.getCheckedRadioButtonId() == R.id.Fr_R){matiere.setFrancais(1L);}
        else if(Fr.getCheckedRadioButtonId()==R.id.Fr_M){matiere.setFrancais(2L);}
        else {matiere.setFrancais(0L);}

        RadioGroup Maths = findViewById(R.id.Mt_Group);
        if (Maths.getCheckedRadioButtonId() == R.id.Mt_R){matiere.setMaths(1L);}
        else if(Maths.getCheckedRadioButtonId()==R.id.Mt_M){matiere.setMaths(2L);}
        else {matiere.setMaths(0L);}

        RadioGroup Physique = findViewById(R.id.Ph_group);
        if (Physique.getCheckedRadioButtonId() == R.id.Ph_R){matiere.setPhysique(1L);}
        else if(Physique.getCheckedRadioButtonId()==R.id.Ph_M){matiere.setPhysique(2L);}
        else {matiere.setPhysique(0L);}

        RadioGroup Chemie = findViewById(R.id.Ch_group);
        if (Chemie.getCheckedRadioButtonId() == R.id.Ch_R){matiere.setChemie(1L);}
        else if(Chemie.getCheckedRadioButtonId()==R.id.Ch_M){matiere.setChemie(2L);}
        else {matiere.setChemie(0L);}

        RadioGroup Histoire = findViewById(R.id.Hi_group);
        if (Histoire.getCheckedRadioButtonId() == R.id.Hi_R){matiere.setHistoire(1L);}
        else if(Histoire.getCheckedRadioButtonId()==R.id.Hi_M){matiere.setHistoire(2L);}
        else {matiere.setHistoire(0L);}

        RadioGroup Geo = findViewById(R.id.Ge_Group);
        if (Geo.getCheckedRadioButtonId() == R.id.Ge_R){matiere.setGeographie(1L);}
        else if(Geo.getCheckedRadioButtonId()==R.id.Ge_M){matiere.setGeographie(2L);}
        else {matiere.setGeographie(0L);}

        RadioGroup Anglais = findViewById(R.id.An_group);
        if (Anglais.getCheckedRadioButtonId() == R.id.An_R){matiere.setAnglais(1L);}
        else if(Anglais.getCheckedRadioButtonId()==R.id.An_M){matiere.setAnglais(2L);}
        else {matiere.setAnglais(0L);}

        RadioGroup Espagnol = findViewById(R.id.Es_group);
        if (Espagnol.getCheckedRadioButtonId() == R.id.Es_R){matiere.setEspagnol(1L);}
        else if(Espagnol.getCheckedRadioButtonId()==R.id.Es_M){matiere.setEspagnol(2L);}
        else {matiere.setEspagnol(0L);}

        RadioGroup Allemand = findViewById(R.id.Al_group);
        if (Allemand.getCheckedRadioButtonId() == R.id.Al_R){matiere.setAllemand(1L);}
        else if(Allemand.getCheckedRadioButtonId()==R.id.Al_M){matiere.setAllemand(2L);}
        else {matiere.setAllemand(0L);}
        Log.i("onclick", matiere.toString());
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

        @Override
        public String toString() {
            return "varLayout{" +
                    "layout=" + layout +
                    '}';
        }

        public int getLayout() {
            return this.layout;
        }
        public void barrebas(){
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
                    LayoutReglage();
                }
            });
            messagerie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setlayout(R.layout.messagerie);
                    LayoutMessagerie();

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
                                FirebaseUser mUser = mAuth.getCurrentUser();
                                updateUI(mUser);
                                user.setMail(mUser.getEmail());
                                for (int i = 0; i < bdd.getSize(); i++) {
                                    if (bdd.getUsers().get(i).compareMail(user.getMail())){
                                        user.setAll2(bdd.getUsers().get(i));
                                        matiere.setAll2(bdd.getMatieres().get(i));
                                    }
                                }
                                setlayout(R.layout.recherche);
                                LayoutRecherche();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.d("TAG", "signInWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, "user not found",Toast.LENGTH_SHORT).show();
                                updateUI(null);

                            }
                        }
                    });

            // [END sign_in_with_email]
        }

        public void LayoutRecherche() {
            if (getLayout() == R.layout.recherche) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                RecyclerViewFragment fragment = new RecyclerViewFragment(bdd,activity,R.layout.recherche_result,varLayout);
                transaction.replace(R.id.sample_content_fragment, fragment);
                transaction.commit();



                Spinner choix = (Spinner) findViewById(R.id.choix);
                String matiere[] = {"Francais","Maths","Physique","Chemie","Histoire","Geographie","Anglais","Espagnol","Allemand"};

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                        R.array.Matiere, R.layout.spinner);
                adapter.setDropDownViewResource(R.layout.spinnerdropdown);

                choix.setAdapter(adapter);
                choix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int pos, long id) {
                        // An spinnerItem was selected. You can retrieve the selected item using
                        // parent.getItemAtPosition(pos)
                        String text = (String) parent.getItemAtPosition(pos);
                        BDD bdd2 = new BDD();
                        bdd2.update(bdd);
                        bdd2.Selected(text);
                        fragment.updateDataset(bdd2);

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing, just another required interface callback
                    }

                });
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

                Button inscription = (Button) findViewById(R.id.inscription_bouton_confiramtion);
                Button retour = (Button) findViewById(R.id.retour);
                
                retour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.connection);
                        LayoutConnection();
                    }
                });
                EditText Nom = (EditText) findViewById(R.id.editTextTextPassword);
                EditText Password = (EditText) findViewById(R.id.inscriptionpassword1);
                EditText Password_confirmed = (EditText) findViewById(R.id.inscriptionpassword2);
                EditText Adresse = (EditText) findViewById(R.id.incriptionadresse);
                EditText Email = (EditText) findViewById(R.id.inscriptionmail);

                inscription.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = Nom.getText().toString();
                        String password0 = Password.getText().toString();
                        String password = Password_confirmed.getText().toString();
                        String adresse = Adresse.getText().toString();
                        String email = Email.getText().toString();

                        if (name.isEmpty() || password0.isEmpty() || password.isEmpty() || adresse.isEmpty() || email.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Merci de remplir les zones de textes",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            if (password0.equals(password)){
                                user.setAll(email, name, adresse);
                                pass = password;
                                setlayout(R.layout.matiere);
                                LayoutMatiere();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Mot de passe different ",
                                        Toast.LENGTH_SHORT).show();
                            }



                        }

                        //compte test
                        //String email = "test@test.com";
                        //String password = "test1234";



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
                        createAccount(user.getMail(),pass);
                        signIn(user.getMail(),pass);

                        String id = mAuth.getCurrentUser().getUid();
                        mDatabase.child("users").child(id).setValue(user);
                        mDatabase.child("matieres").child(id).setValue(matiere);
                        setlayout(R.layout.recherche);
                        LayoutRecherche();
                    }
                         
                });
            }
        }

        public void LayoutReglage(){
            if (getLayout() == R.layout.matiere){
                if (matiere.getFrancais() == 1L){
                    RadioButton radio = findViewById(R.id.Fr_R);
                    radio.setChecked(true);
                }
                if (matiere.getFrancais() == 2L){
                    RadioButton radio = findViewById(R.id.Fr_M);
                    radio.setChecked(true);
                }
                if (matiere.getMaths() == 1L){
                    RadioButton radio = findViewById(R.id.Mt_R);
                    radio.setChecked(true);
                }
                if (matiere.getMaths() == 2L){
                    RadioButton radio = findViewById(R.id.Mt_M);
                    radio.setChecked(true);
                }
                if (matiere.getPhysique() == 1L){
                    RadioButton radio = findViewById(R.id.Ph_R);
                    radio.setChecked(true);
                }
                if (matiere.getPhysique() == 2L){
                    RadioButton radio = findViewById(R.id.Ph_M);
                    radio.setChecked(true);
                }
                if (matiere.getChemie() == 1L){
                    RadioButton radio = findViewById(R.id.Ch_R);
                    radio.setChecked(true);
                }
                if (matiere.getChemie() == 2L){
                    RadioButton radio = findViewById(R.id.Ch_M);
                    radio.setChecked(true);
                }
                if (matiere.getHistoire() == 1L){
                    RadioButton radio = findViewById(R.id.Hi_R);
                    radio.setChecked(true);
                }
                if (matiere.getHistoire() == 2L){
                    RadioButton radio = findViewById(R.id.Hi_M);
                    radio.setChecked(true);
                }
                if (matiere.getGeographie() == 1L){
                    RadioButton radio = findViewById(R.id.Ge_R);
                    radio.setChecked(true);
                }
                if (matiere.getGeographie() == 2L){
                    RadioButton radio = findViewById(R.id.Ge_M);
                    radio.setChecked(true);
                }
                if (matiere.getAnglais() == 1L){
                    RadioButton radio = findViewById(R.id.An_R);
                    radio.setChecked(true);
                }
                if (matiere.getAnglais() == 2L){
                    RadioButton radio = findViewById(R.id.An_M);
                    radio.setChecked(true);
                }
                if (matiere.getAllemand() == 1L){
                    RadioButton radio = findViewById(R.id.An_R);
                    radio.setChecked(true);
                }
                if (matiere.getAllemand() == 2L){
                    RadioButton radio = findViewById(R.id.Al_M);
                    radio.setChecked(true);
                }
                if (matiere.getEspagnol() == 1L){
                    RadioButton radio = findViewById(R.id.Es_R);
                    radio.setChecked(true);
                }
                if (matiere.getEspagnol() == 2L){
                    RadioButton radio = findViewById(R.id.Es_M);
                    radio.setChecked(true);
                }
                Button Save = findViewById(R.id.Save);
                Save.setText("Mise à jour");
                Save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.recherche);
                        LayoutRecherche();
                    }

                });
            }

        }

        public void LayoutMessagerie(){
            Log.d("test","test3");
            if (getLayout() == R.layout.messagerie) {

                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                RecyclerViewFragment fragment2 = new RecyclerViewFragment(bdd, activity, R.layout.messagerie_result,varLayout);

                transaction2.replace(R.id.sample_content_fragment, fragment2);
                transaction2.commit();
                barrebas();
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = this;
        varLayout = new varLayout(R.layout.connection);
        setContentView(varLayout.getLayout());
        getSupportActionBar().hide();
        varLayout.LayoutConnection();
        varLayout.LayoutInscription();
        varLayout.LayoutRecherche();
        varLayout.LayoutMatiere();
        varLayout.LayoutReglage();
        varLayout.LayoutMessagerie();
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
        EditText Mail = (EditText) findViewById(R.id.connectionmail);
        EditText Password = (EditText) findViewById(R.id.connectionpassword);
        Mail.setText("test@test.com");
        Password.setText("test1234");

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");
        ValueEventListener usersEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String name = ds.child("nom").getValue(String.class);
                        String mail = ds.child("mail").getValue(String.class);
                        String adresse = ds.child("adresse").getValue(String.class);
                        User user = new User(mail, name, adresse);
                        bdd.addUsers(user);
                        //Log.d("test", user.toString());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        usersRef.addListenerForSingleValueEvent(usersEvent);
        DatabaseReference matieresRef = FirebaseDatabase.getInstance().getReference().child("matieres");
        ValueEventListener matieresEvent = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Matiere matiere3 = new Matiere();
                    try {matiere3.setFrancais(ds.child("francais").getValue(long.class));}
                    catch (Exception e){matiere3.setFrancais(0);}
                    try {matiere3.setMaths(ds.child("maths").getValue(long.class));}
                    catch (Exception e){matiere3.setMaths(0);}
                    try {matiere3.setPhysique(ds.child("physique").getValue(long.class));}
                    catch (Exception e){matiere3.setPhysique(0);}
                    try {matiere3.setChemie(ds.child("chemie").getValue(long.class));}
                    catch (Exception e){matiere3.setChemie(0);}
                    try {matiere3.setHistoire(ds.child("histoire").getValue(long.class));}
                    catch (Exception e){matiere3.setHistoire(0);}
                    try {matiere3.setGeographie(ds.child("geographie").getValue(long.class));}
                    catch (Exception e){matiere3.setGeographie(0);}
                    try {matiere3.setAnglais(ds.child("anglais").getValue(long.class));}
                    catch (Exception e){matiere3.setAnglais(0);}
                    try {matiere3.setEspagnol(ds.child("espagnol").getValue(long.class));}
                    catch (Exception e){matiere3.setEspagnol(0);}
                    try {matiere3.setAllemand(ds.child("allemand").getValue(long.class));}
                    catch (Exception e){matiere3.setAllemand(0);}
                    bdd.getMatieres().add(matiere3);


                    //Log.d("matieresEvent",matiere3.toString());
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        matieresRef.addListenerForSingleValueEvent(matieresEvent);

    }


}
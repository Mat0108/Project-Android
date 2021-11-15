package com.example.projectandroidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

        public void LayoutRecherche(){
            if (getLayout() == R.layout.recherche){
                /*
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                com.example.projectandroidtest.RecyclerViewFragment fragment = new com.example.projectandroidtest.RecyclerViewFragment();
                transaction.replace(R.id.sample_content_fragment, fragment);
                transaction.commit();

                Button back = (Button)findViewById(R.id.rechercheback);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.connection);
                        LayoutConnection();
                    }
                });*/
            }
        }
        public void LayoutConnection(){
            if (getLayout() == R.layout.connection){
                Button connection = (Button) findViewById(R.id.connectionbutton);
                connection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.recherche);
                        LayoutRecherche();


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
                Button back = (Button) findViewById(R.id.inscriptionback2);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlayout(R.layout.connection);
                        LayoutConnection();

                    }
                });
            }
        }
        public void LayoutMain(){
            setlayout(R.layout.activity_main);

        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final varLayout layout;
        layout = new varLayout(R.layout.recherche);
        setContentView(layout.getLayout());
        getSupportActionBar().hide();
        //layout.LayoutConnection();
        //layout.LayoutInscription();
        //layout.LayoutRecherche();


    }
}
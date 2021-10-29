/*
* Copyright 2013 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


package com.example.android;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.common.activities.SampleActivityBase;
import com.example.android.recyclerview.R;
import com.example.android.recyclerview.RecyclerViewFragment;


/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link android.support.v4.app.Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class MainActivity extends SampleActivityBase {

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
        layout = new varLayout(R.layout.connection);
        setContentView(layout.getLayout());
        getActionBar().hide();
        layout.LayoutRecherche();
        layout.LayoutConnection();
        layout.LayoutInscription();
        /*
        Button search = (Button)findViewById(R.id.Button1);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               layout.LayoutMain();
            }
        });*/
        /*if (savedInstanceState == null){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                RecyclerViewFragment fragment = new RecyclerViewFragment();
                transaction.replace(R.id.sample_content_fragment, fragment);
                transaction.commit();

        }*/

    }


}


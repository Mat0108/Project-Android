/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.projectandroidtest.recyclerview;


import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.projectandroidtest.BDD;
import com.example.projectandroidtest.MainActivity;
import com.example.projectandroidtest.Message;
import com.example.projectandroidtest.R;
import com.example.projectandroidtest.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public class RecyclerViewFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private int DATASET_COUNT = 60;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();;
    private BDD bdd = new BDD();
    private BDD bdds = new BDD();
    private Activity activity;
    private User user = new User("","","");
    private User user2 = new User("","","");
    private int layout;
    private Message messages = new Message();

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public int getDATASET_COUNT() {return DATASET_COUNT;}
    public void setDATASET_COUNT(int DATASET_COUNT) {
        this.DATASET_COUNT = DATASET_COUNT;
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RadioButton mLinearLayoutRadioButton;
    protected RadioButton mGridLayoutRadioButton;

    protected RecyclerView mRecyclerView;
    protected CustomAdapterRecherche mAdapterR;
    protected CustomAdapterMessagerie mAdapterM;
    protected CustomAdapterChat mAdapterC;

    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;
    protected String[] mDataset2;
    protected String[] mDataset3;
    protected String[] mDataset4;



    protected MainActivity.varLayout varLayout;


    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public RecyclerViewFragment(BDD bdd,Activity activity,int layout,MainActivity.varLayout varLayout,User user) {
        this.bdd = bdd;
        this.activity = activity;
        this.layout = layout;
        this.varLayout = varLayout;
        this.user = user;
    }
    public RecyclerViewFragment(Activity activity,int layout,MainActivity.varLayout varLayout,User user, User user2){
        this.activity = activity;
        this.layout = layout;
        this.varLayout = varLayout;
        this.user = user;
        this.user2 = user2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view, container, false);
        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;


        if (layout == R.layout.recherche_result){
            mAdapterR = new CustomAdapterRecherche(mDataset,mDataset2);
            mRecyclerView.setAdapter(mAdapterR);
            this.configureOnClickRecyclerView(R.layout.recherche_result);
            mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
        }
        if(layout == R.layout.messagerie_result){
            mAdapterM = new CustomAdapterMessagerie(mDataset,mDataset2,mDataset3);
            mRecyclerView.setAdapter(mAdapterM);
            this.configureOnClickRecyclerView(R.layout.messagerie_result);
            mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        }
        if(layout == R.layout.chat_result){
            mAdapterC = new CustomAdapterChat(mDataset4);
            mRecyclerView.setAdapter(mAdapterC);
            mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;




        }
        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);



        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void configureOnClickRecyclerView(int layout){

            ItemClickSupport.addTo(mRecyclerView, layout)
                    .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                            if (layout == R.layout.recherche_result){
                                if (position < bdds.getSize()) {
                                    user.setAll2(bdds.getUsers().get(position));
                                    varLayout.setlayout(R.layout.messagerie);

                                    varLayout.LayoutMessagerie();



                                }
                            }
                            if (layout == R.layout.messagerie_result){
                                varLayout.setlayout(R.layout.chat);
                                varLayout.setUserid(position);
                                varLayout.LayoutChat();

                            }
                        }
                    });


    }
    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {

        this.bdds.update(this.bdd);
        ArrayList<String> liste = bdd.UsertoString();
        ArrayList<String> liste2 = bdd.MatieretoString();
        mDataset = new String[DATASET_COUNT];
        mDataset2 = new String[DATASET_COUNT];
        mDataset3 = new String[DATASET_COUNT];
        if (layout == R.layout.chat_result){

            ArrayList<Message> message = user.getMessage();
            String nom = new String();
            nom = user2.getNom();
            int val = 0;

            for (int i=0;i<message.size();i++){
                if(message.get(i).getUser1().compareNom(nom) || message.get(i).getUser2().compareNom(nom)){
                    messages = message.get(i);
                }

            }

            mDataset4 = new String[messages.getMessage1().size()+messages.getMessage2().size()];

            for (int i=0;i<messages.getMessage1().size();i++){
                mDataset4[i*2]=messages.getMessage1().get(i);


            }
            for (int i=0;i<messages.getMessage2().size();i++){
                    mDataset4[i*2+1]=messages.getMessage2().get(i);
            }
        }
        if (layout == R.layout.messagerie_result){
            ArrayList<Message> message = user.getMessage();

            for (int i = 0;i<DATASET_COUNT;i++){
                if (i<message.size()){

                    mDataset[i] = message.get(i).checknom(user);
                    String text = message.get(i).checklast(user);
                    if(text.length() > 35){
                        text = text.substring(0,35);
                        text = text+" ...";
                    }
                    mDataset2[i] = text;
                    mDataset3[i] = "";
                }
                else{
                    mDataset[i] = "utilisateur";
                    mDataset2[i] = "merci";
                    mDataset3[i] = "";
                }

            }
        }
        if (layout == R.layout.recherche_result)
        {
            for (int i = 0; i < DATASET_COUNT; i++) {
                if (i < liste.size()) {
                    mDataset[i] = liste.get(i);
                    mDataset2[i] = liste2.get(i);
                }
                else {
                    mDataset[i] = "element " + i;
                    mDataset2[i] = "element 1\nelement 2";
                }

            }
        }



    }
    public void updateDataset(BDD bdd2){
        this.bdds.update(bdd2);
        ArrayList<String> liste = bdd2.UsertoString();
        ArrayList<String> liste2 = bdd2.MatieretoString();
        for (int i = 0; i < DATASET_COUNT; i++) {
            if (i < liste.size()){
                mDataset[i] = liste.get(i);
                mDataset2[i] = liste2.get(i);
            }
            else {
                mDataset[i] = "element " + i;
                mDataset2[i] = "element 1\nelement 2";
            }
        }
        mAdapterR.notifyDataSetChanged();
    }
    public void updateDataset(Message message,int position){
        mDataset4 = new String[messages.getMessage1().size()+messages.getMessage2().size()];


        for (int i=0;i<messages.getMessage1().size();i++){
            mDataset4[i*2]=messages.getMessage1().get(i);


        }
        for (int i=0;i<messages.getMessage2().size();i++){
            mDataset4[i*2+1]=messages.getMessage2().get(i);

        }
        for (int i=0;i<messages.getMessage2().size();i++){
            Log.d("mdataset",mDataset4[i*2+1]);

        }
        mAdapterC.notifyItemChanged(position);
    }
    public void print(String[] Dataset){
        for (int i = 0; i<Dataset.length;i++){
            Log.d("print",Dataset[i]);
        }
    }
}

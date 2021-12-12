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

import com.example.projectandroidtest.BDD;
import com.example.projectandroidtest.MainActivity;
import com.example.projectandroidtest.R;
import com.example.projectandroidtest.User;
import com.example.projectandroidtest.recyclerview.CustomAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;


/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public class RecyclerViewFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private int DATASET_COUNT = 60;
    private BDD bdd = new BDD();
    private BDD bdds = new BDD();
    private Activity activity;
    private User user;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();;

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
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;
    protected String[] mDataset2;


    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public RecyclerViewFragment(BDD bdd,Activity activity) {
        this.bdd = bdd;
        this.activity = activity;
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

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapter(mDataset,mDataset2);

        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        this.configureOnClickRecyclerView();

        // END_INCLUDE(initializeRecyclerView)
        /*
        mLinearLayoutRadioButton = (RadioButton) rootView.findViewById(R.id.linear_layout_rb);
        mLinearLayoutRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
            }
        });

        mGridLayoutRadioButton = (RadioButton) rootView.findViewById(R.id.grid_layout_rb);
        mGridLayoutRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
            }
        });*/
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

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(mRecyclerView, R.layout.recherche_result)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        if (position < bdds.getSize()) {
                            Log.d("TAG", "" + bdds.getUsers().get(position).toString());
                            user.setAll2(bdds.getUsers().get(position));

                            activity.setContentView(R.layout.messagerie);


                        }
                        else{
                            Log.d("TAG","Position : "+position);
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
        mAdapter.notifyDataSetChanged();
    }
}

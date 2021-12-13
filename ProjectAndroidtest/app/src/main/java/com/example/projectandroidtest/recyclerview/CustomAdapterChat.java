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





//import android.support.v7.widget.RecyclerView;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroidtest.R;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapterChat extends RecyclerView.Adapter<CustomAdapterChat.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private final TextView chat;
        private final RelativeLayout chat_layout;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.

            chat = (TextView) v.findViewById(R.id.chat);
            chat_layout = (RelativeLayout) v.findViewById(R.id.chat_layout);



        }

        public TextView getChat() {
            return chat;
        }
        public RelativeLayout getLayout(){return chat_layout;}

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapterChat(String[] dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chat_result, viewGroup, false);


        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)


    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        ViewGroup.LayoutParams layoutParams = viewHolder.getLayout().getLayoutParams();
        layoutParams.height = (int)((mDataSet[position].length()/68.0)*30+200);
        viewHolder.getLayout().setLayoutParams(layoutParams);
        Log.d("position",String.valueOf(position));
        if (position % 2 == 0){
            //viewHolder.getLayout().setLayoutParams(layoutParams);
            viewHolder.getChat().setBackgroundColor(Color.parseColor("#7DABA9"));
            viewHolder.getChat().setText(mDataSet[position]);
            ViewGroup.MarginLayoutParams layoutParams1 = (ViewGroup.MarginLayoutParams) viewHolder.getLayout().getLayoutParams();
            layoutParams1.setMargins(270, 0,0,0);
            viewHolder.getLayout().setLayoutParams(layoutParams1);

        }
        else{
            viewHolder.getChat().setBackgroundColor(Color.parseColor("#80AB7D"));
            viewHolder.getChat().setText(mDataSet[position]);
            ViewGroup.MarginLayoutParams layoutParams1 = (ViewGroup.MarginLayoutParams) viewHolder.getLayout().getLayoutParams();
            layoutParams1.setMargins(0, 0,0,0);
            viewHolder.getLayout().setLayoutParams(layoutParams1);
        }


    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)
    
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

}

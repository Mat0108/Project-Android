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

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroidtest.Message;
import com.example.projectandroidtest.Messages;
import com.example.projectandroidtest.R;
import com.example.projectandroidtest.User;

import java.util.ArrayList;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapterMessagerie extends RecyclerView.Adapter<CustomAdapterMessagerie.ViewHolder> {


    private ArrayList<Messages> mDataSet;
    private User user;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private final TextView name2;
        private final TextView messages;
        private final TextView point;
        private final ImageView font;
        private final ImageView photo;
        private final ImageView mask;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.

            name2 = (TextView) v.findViewById(R.id.name2);
            messages = (TextView) v.findViewById(R.id.message2);
            point = (TextView) v.findViewById(R.id.point);
            font = (ImageView) v.findViewById(R.id.font2);
            photo = (ImageView) v.findViewById(R.id.photo2);
            mask = (ImageView) v.findViewById(R.id.mask2);


        }

        public TextView getName2() {return name2;}
        public TextView getMessages(){return messages;}
        public TextView getPoint(){return point;}
        public ImageView getFont(){return font;}
        public ImageView getPhoto(){return photo;}
        public ImageView getMask(){return mask;}

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)


    public CustomAdapterMessagerie(User user,User user2) {
        this.mDataSet = user.getMessage();
        this.user = user;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.messagerie_result, viewGroup, false);


        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)


    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        // Get element from your dataset at this position and replace the contents of the view
        // with that element*

        if (mDataSet.get(position).getUser1().compare(user)){
            viewHolder.getName2().setText(mDataSet.get(position).getUser2().getNom());
        }
        else{
            viewHolder.getName2().setText(mDataSet.get(position).getUser1().getNom());
        }
        if (mDataSet.get(position).getMessage().size() != 0){
            if (!user.compare(mDataSet.get(position).getMessage().get(mDataSet.get(position).getMessage().size()-1).getUser())){
                viewHolder.getPoint().setText(".");
                viewHolder.getName2().setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                viewHolder.getPoint().setText("");
            }
            viewHolder.getMessages().setText(mDataSet.get(position).getMessage().get(mDataSet.get(position).getMessage().size()-1).getMessage());
        }
        else{
            viewHolder.getMessages().setText("Nouvelles discussions");
            viewHolder.getPoint().setText("");
        }


        /*if(mDataset3[position].contains(".")){


        }*/
        viewHolder.getFont().setImageResource(R.drawable.messagerieresult);
        viewHolder.getPhoto().setImageResource(R.drawable.recherchephoto);
        viewHolder.getMask().setImageResource(R.drawable.recherchemask);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)
    
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}

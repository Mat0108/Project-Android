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

package com.example.android.recyclerview;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView matiere;
        private final ImageView font;
        private final ImageView photo;
        private final ImageView mask;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.

            name = (TextView) v.findViewById(R.id.name);
            matiere = (TextView) v.findViewById(R.id.matiere);
            font = (ImageView) v.findViewById(R.id.font);
            photo = (ImageView) v.findViewById(R.id.photo);
            mask = (ImageView) v.findViewById(R.id.mask);

        }

        public TextView getName() {
            return name;
        }
        public TextView getMatiere(){return matiere;}
        public ImageView getFont(){return font;}
        public ImageView getPhoto(){return photo;}
        public ImageView getMask(){return mask;}
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recherche_result, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getName().setText(mDataSet[position]);
        viewHolder.getMatiere().setText("Matière 1\nMatière 2");
        viewHolder.getFont().setImageResource(R.drawable.rechercheresult);
        viewHolder.getPhoto().setImageResource(R.drawable.rechercheprofile2);
        viewHolder.getMask().setImageResource(R.drawable.rechercheprofile1);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}

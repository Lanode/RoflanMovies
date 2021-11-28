//package com.cum.roflanmovies;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.media.Image;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import org.json.JSONArray;
//
//public class MoviesAdapter extends
//        RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public ImageView imageView;
//
//        // We also create a constructor that accepts the entire item row
//        // and does the view lookups to find each subview
//        public ViewHolder(View itemView) {
//            // Stores the itemView in a public final member variable that can be used
//            // to access the context from any ViewHolder instance.
//            super(itemView);
//
//            imageView = (ImageView) itemView;
//        }
//
//        public void onClick(View v) {
//            Context context = itemView.getContext();
//            Intent myIntent = new Intent(context, MovieActivity.class);
//            context.startActivity(myIntent);
////            context.
//        }
//    }
//
//    // ... view holder defined above...
//
//    // Store a member variable for the contacts
//    private JSONArray movies;
//
//    // Pass in the contact array into the constructor
//    public MoviesAdapter(JSONArray movies) {
//        this.movies = movies;
//    }
//
//    @Override
//    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//
//        View movieView = new ImageView(context);
//
//        return new ViewHolder(movieView);
//    }
//
//    // Involves populating data into the item through holder
//    @Override
//    public void onBindViewHolder(MoviesAdapter.ViewHolder holder, int position) {
////        (movies.getJSONObject(position).getString("img"))
//    }
//
//    // Returns the total count of items in the list
//    @Override
//    public int getItemCount() {
//        return movies.size();
//    }
//}
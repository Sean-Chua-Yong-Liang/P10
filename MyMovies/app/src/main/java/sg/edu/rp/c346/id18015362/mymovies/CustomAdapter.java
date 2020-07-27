package sg.edu.rp.c346.id18015362.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.TextViewTitle);
        TextView tvYear = rowView.findViewById(R.id.TextViewYear);
        TextView tvGenre = rowView.findViewById(R.id.TextViewGenre);
        ImageView ivRating = rowView.findViewById(R.id.ImageViewMovie);

        switch(movieList.get(position).getRated()){

            case "g":
                ivRating.setImageResource(R.drawable.rating_g);
                break;

            case "pg":
                ivRating.setImageResource(R.drawable.rating_pg);
                break;

            case "pg13":
                ivRating.setImageResource(R.drawable.rating_pg13);
                break;

            case "nc16":
                ivRating.setImageResource(R.drawable.rating_nc16);
                break;

            case "m18":
                ivRating.setImageResource(R.drawable.rating_m18);
                break;

            case "r21":
                ivRating.setImageResource(R.drawable.rating_r21);
                break;

        }

        Movie currentItem = movieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear() + " - ");
        tvGenre.setText(currentItem.getGenre() + "");


        return rowView;
    }

}

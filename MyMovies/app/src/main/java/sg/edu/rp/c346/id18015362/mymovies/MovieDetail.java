package sg.edu.rp.c346.id18015362.mymovies;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MovieDetail extends AppCompatActivity {

    ImageView ivRatingDetail;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvWatched;
    TextView tvTheatre;
    ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ivRatingDetail = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.TextViewTitleDetail);
        tvYear = findViewById(R.id.TextViewYearDetail);
        tvGenre = findViewById(R.id.TextViewGenreDetail);
        tvDescription = findViewById(R.id.TextViewDescription);
        tvWatched = findViewById(R.id.TextViewWatched);
        tvTheatre = findViewById(R.id.TextViewTheatre);

        Intent intentReceived = getIntent();
        Bundle args = intentReceived.getBundleExtra("Bundle");
        int position = intentReceived.getIntExtra("position", 99999999);
        movieArrayList = (ArrayList<Movie>) args.getSerializable("MovieList");

        switch(movieArrayList.get(position).getRated()){

            case "g":
                ivRatingDetail.setImageResource(R.drawable.rating_g);
                break;

            case "pg":
                ivRatingDetail.setImageResource(R.drawable.rating_pg);
                break;

            case "pg13":
                ivRatingDetail.setImageResource(R.drawable.rating_pg13);
                Log.i("tag", "PG13 PICTURE SELECTED");
                break;

            case "nc16":
                ivRatingDetail.setImageResource(R.drawable.rating_nc16);
                break;

            case "m18":
                ivRatingDetail.setImageResource(R.drawable.rating_m18);
                break;

            case "r21":
                ivRatingDetail.setImageResource(R.drawable.rating_r21);
                break;

        }

        Movie currentItem = movieArrayList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear() + " - ");
        tvGenre.setText(currentItem.getGenre());
        tvDescription.setText(currentItem.getDescription());

        Calendar cal = currentItem.getWatched_on();
        String dateString = cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);

        tvWatched.setText(dateString);
        tvTheatre.setText(currentItem.getIn_theatre());


    }

}

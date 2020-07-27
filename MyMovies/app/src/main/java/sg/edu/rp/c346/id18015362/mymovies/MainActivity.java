package sg.edu.rp.c346.id18015362.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewContacts);
        alMovieList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014,11,15);
        Movie item1 = new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", calendar, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovieList.add(item1);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2015,5,15);
        Movie item2 = new Movie("Planes", 2013, "pg", "Animation | Comedy", calendar1, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovieList.add(item2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetail.class);
                Bundle args = new Bundle();
                args.putSerializable("MovieList",(Serializable)alMovieList);
                intent.putExtra("position", position);
                intent.putExtra("Bundle", args);
                startActivity(intent);
            }
        });
    }
}
